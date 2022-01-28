package com.back.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.back.Models.*;
import com.back.Repositories.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class MovieController {
    private ObjectMapper objectMapper;
    private String apy_key= "bb3fd8ab419097d83adf66e0d7a06ab2";
    @Autowired // This means to get the bean called userRepository
            // Which is auto-generated by Spring, we will use it to handle the data
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    JdbcTemplate database;

    public MovieController() {
        super();
        objectMapper = new ObjectMapper();
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
    , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        return "Saved";
    }

    @GetMapping(path="/generos")
    public @ResponseBody Iterable<Box> getGeneros() {
        // This returns a JSON or XML with the users
        URL url = null;
        List<Box> generos = new ArrayList<>();
        try {
            url = new URL(String.format("https://api.themoviedb.org/3/genre/movie/list?api_key=%s&language=es-MX", apy_key));
            GeneroContainer container = objectMapper.readValue(url, GeneroContainer.class);
            generos = container.getGenres(); 
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (StreamReadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatabindException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return generos;
    }

    @GetMapping(path="/personas")
    public @ResponseBody Iterable<Box> getPersonas(@RequestParam String name) {
        // This returns a JSON or XML with the users
        URL url = null;
        int max_personas = 15;
        String src = String.format("https://api.themoviedb.org/3/search/person?api_key=%s&language=es-MX&query=%s&page=1&include_adult=false",apy_key, name.trim());
        System.out.println(src);
        List<Box> personas = new ArrayList<>();
        try {
            url = new URL(src);
            ResultadoContainer container = objectMapper.readValue(url, ResultadoContainer.class);
            personas = container.getResults()
                .stream()
                .distinct()
                .collect(Collectors.toList()); 
            while (personas.size()>max_personas) {
                personas.remove(personas.size()-1);
            }
            System.out.println(container); 
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (StreamReadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatabindException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return personas;
    }

    @GetMapping(path="/peliculas")
    public @ResponseBody Iterable<Box> getPeliculas(@RequestParam String title) {
        // This returns a JSON or XML with the users
        URL url = null;
        int max_pelis = 15;
        String src = String.format("https://api.themoviedb.org/3/search/movie?api_key=%s&language=es-MX&query=%s&page=1&include_adult=false",apy_key, title.trim());
        System.out.println(src);
        List<Box> peliculas = new ArrayList<>();
        try {
            url = new URL(src);
            ResultadoContainer container = objectMapper.readValue(url, ResultadoContainer.class);
            peliculas = container.getResults()
                .stream()
                .distinct()
                .collect(Collectors.toList()); 
            while (peliculas.size()>max_pelis) {
                peliculas.remove(peliculas.size()-1);
            }
            System.out.println(container); 
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (StreamReadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatabindException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return peliculas;
    }

    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.POST)
    @PostMapping(path="/usuario") 
    public ResponseEntity<String> addUsuario (@RequestBody FormaUsuario forma){
        Usuario usuario = new Usuario();
        String query = String.format("select count(*) from usuario where alias='%s' or correo='%s' ", forma.getAlias(), forma.getCorreo());
        int rowCount = this.database.
            queryForObject(query, Integer.class);
        if (rowCount>=1) { // hay almenos un usuario con el mismo alias y/o correo
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error en agregar al usuario. Ya existe un usuario con ese alias y/o nombre.");
        }
        usuario.setAlias(forma.getAlias());
        usuario.setNombre(forma.getNombre());
        usuario.setPassword(forma.getPassword());
        usuario.setApellido1(forma.getApellido1());
        usuario.setApellido2(forma.getApellido2());
        usuario.setEdad(Integer.parseInt(forma.getEdad()));
        usuario.setCorreo(forma.getCorreo());
        usuario.setGenero(forma.getGenero());
        String token = UUID.randomUUID().toString();   
        usuario.setToken(token);
        usuarioRepositorio.save(usuario);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Ok");
    }

    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.POST)
    @PostMapping(path="/usuario/access") 
    public ResponseEntity<String> checkUsuario (@RequestBody Cuenta forma){
        System.out.println(forma.getAlias_correo() + "  " + forma.getPassword());
        String query = String.format("select count(*) from usuario where (alias='%s' or correo='%s') and password='%s'", 
                                        forma.getAlias_correo( ), forma.getAlias_correo( ), forma.getPassword( ));
        int rowCount = this.database.queryForObject(query, Integer.class);
        if (rowCount == 1) { // Existe un usuario que hace match 
            query = String.format("select token from usuario where (alias='%s' or correo='%s') and password='%s'", 
                forma.getAlias_correo( ), forma.getAlias_correo( ), forma.getPassword( ));
            String token = this.database.queryForObject(query, String.class);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(token); // manda token del usuario para que pueda tener activa su sesión
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No existe coincidencias, Favor de revisar Usuario o contraseña");
        }
    }

    @GetMapping(path="/usuario/verificacion") 
    public ResponseEntity<String> checkToken (@RequestParam String token){
        String query = String.format("select count(*) from usuario where token='%s' ", token);
        int rowCount = this.database.queryForObject(query, Integer.class);
        if (rowCount == 1) { // Existe un usuario que hace match con el token
            query = String.format("select * from usuario where token='%s' limit 1 ", token);
            Usuario usuario = this.database.queryForObject(query, new RowMapper<Usuario>() {
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                Usuario usuario = new Usuario();
                usuario.setAlias(rs.getString("alias"));
                usuario.setToken(rs.getString("token"));
                return usuario;
            }
        });
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuario.getAlias());
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Token invalido");
        }
    }
}