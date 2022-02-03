package com.back.Controllers;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Iterator;

import com.back.Models.*;
import com.back.Repositories.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller // This means that this class is a Controller
@RequestMapping(path="/api") // This means URL's start with /api (after Application path)
public class MovieController {

    private ObjectMapper objectMapper;
    private String apy_key= "bb3fd8ab419097d83adf66e0d7a06ab2";

    @Autowired 
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired 
    private FavoritoRepositorio favoritoRepositorio;

    @Autowired 
    private RecomendacionRepositorio recomendacionRepositorio;


    @Autowired
    JdbcTemplate database;

    public MovieController() {
        super();
        objectMapper = new ObjectMapper();
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

    private String formateaNombre_completo(String nombre_completo){
        String s = "";
        for(int i = 0; i < nombre_completo.length( ); ++i){
            if(Character.isLetterOrDigit(nombre_completo.charAt(i))){
                s += Character.toString(nombre_completo.charAt(i));
            }else{
                s += "%" + Integer.toHexString((int)(nombre_completo.charAt(i)));
            }
        }
        return s;
    }
    private List<Pelicula> byPelicula(String src){
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            URL url = new URL(src);
            ResultadoPeliculaContainer container = objectMapper.readValue(url, ResultadoPeliculaContainer.class);
            peliculas = container.getResults()
                .stream()
                .distinct()
                .collect(Collectors.toList());

            int maxPelis = 15;
            Collections.shuffle(peliculas);
            while (peliculas.size() > maxPelis) {
                peliculas.remove(peliculas.size() - 1);
            }
            System.out.println(container); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    private List<Pelicula> byPersona(String src){
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            URL url = new URL(src);
            ResultadoPersonaContainer container = objectMapper.readValue(url, ResultadoPersonaContainer.class);
            List<Persona> personas = new ArrayList<>();
            personas = container.getResults(); 
            peliculas = personas.get(0).getKnown_for() // obtenemos la persona y de ella las peliculas en las cuales participa
                .stream()
                .distinct()
                .collect(Collectors.toList());

            int maxPelis = 15;
            Collections.shuffle(peliculas);
            while (peliculas.size() > maxPelis) {
                peliculas.remove(peliculas.size() - 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    private List<Pelicula> getRecomendacionTabla(long usuario_id, long catalogo_id){
        String query = String.format("select * from recomendacion where usuario_id=%s and catalogo_id=%s", usuario_id, catalogo_id);
        List<Pelicula> peliculas = this.database.query(query, new RowMapper<Pelicula>( ) {
            public Pelicula mapRow(ResultSet rs, int rowNum) throws SQLException {
                Pelicula pelicula = new Pelicula( );
                pelicula.setId(rs.getString("api_id"));
                pelicula.setTitle(rs.getString("title"));
                pelicula.setOverview(rs.getString("overview"));
                pelicula.setPoster_path(rs.getString("poster_path"));
                pelicula.setRelease_date(rs.getString("release_date"));
                return pelicula;
            }
        });
       return peliculas;
    }
    private void saveRecomendaciones(List<Pelicula> peliculas, Long usuario_id, Long catalogo_id){
               //guardando en tabla de recomendaciones
               ListIterator<Pelicula> it = peliculas.listIterator();
               while(it.hasNext( )){
                   Pelicula peli = it.next( );
                   Recomendacion recomendacion = new Recomendacion( );
                   recomendacion.setApi_id(Long.parseLong(peli.getId( )));
                   recomendacion.setTitle(peli.getTitle( ));
                   recomendacion.setOverview(peli.getOverview( ));
                   recomendacion.setPoster_path(peli.getPoster_path( ));
                   recomendacion.setRelease_date(peli.getRelease_date( ));
                   recomendacion.setUsuario_id(usuario_id);
                   recomendacion.setGenre_ids(peli.getGenre_ids( ).toString( ));
                   recomendacion.setCatalogo_id(catalogo_id);
                   recomendacionRepositorio.save(recomendacion);
               }
    }
    @GetMapping(path="/peliculas/recomendacion")
    public @ResponseBody ResponseEntity<Iterable<Pelicula>> getRecomendacionby(@RequestParam String token, @RequestParam String tipoDeRecomendacion) {
        long catalogo_id;
        String src;

        long usuario_id = this.database.queryForObject(String.format("select usuario_id from usuario where token ='%s'", token), Integer.class);
        List<Pelicula> peliculas = new ArrayList<>( );

        if(tipoDeRecomendacion.equals("pelicula")){
            catalogo_id = 2;
            peliculas = getRecomendacionTabla(usuario_id, catalogo_id);

            if(peliculas.isEmpty( )){ // si es TRUE no teniamos recomendaciones guardadas
                String query = String.format("select api_id from favorito where usuario_id=%s and catalogo_id=%s", usuario_id, catalogo_id);
                int api_id = this.database.queryForObject(query, Integer.class);
                src = String.format("https://api.themoviedb.org/3/movie/%s/recommendations?api_key=%s&language=es-MX", api_id, apy_key);
                peliculas = byPelicula(src);
                saveRecomendaciones(peliculas, usuario_id, catalogo_id);
            }
        }else{
            catalogo_id = tipoDeRecomendacion.equals("actor") ? 3 : 4;
            peliculas = getRecomendacionTabla(usuario_id, catalogo_id);

            if(peliculas.isEmpty( )){ // si es null no teniamos recomendaciones guardadas
                String query = String.format("select nombre_completo from favorito where usuario_id=%s and catalogo_id=%s", usuario_id, catalogo_id);
                String nombre_completo = this.database.queryForObject(query, String.class);
                nombre_completo = formateaNombre_completo(nombre_completo);
                src = String.format("https://api.themoviedb.org/3/search/person?api_key=%s&query=%s",apy_key, nombre_completo);
                peliculas = byPersona(src);    
                saveRecomendaciones(peliculas, usuario_id, catalogo_id);            
            }
        }
        return ResponseEntity.status(peliculas.iterator().hasNext() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(peliculas);
    }

    @GetMapping(path="/usuario") 
    public ResponseEntity<Usuario> getUsuario (@RequestParam String token){
        Usuario usuario = new Usuario();
        String query = String.format("select count(*) from usuario where token='%s' ", token);
        int rowCount = this.database.queryForObject(query, Integer.class);
        if (rowCount == 1) { // Existe un usuario que hace match con el token
            query = String.format("select * from usuario where token='%s' limit 1 ", token);
            usuario = this.database.queryForObject(query, new RowMapper<Usuario>() {
                public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Usuario usuario = new Usuario();
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setAlias(rs.getString("alias"));
                    usuario.setApellido1(rs.getString("apellido1"));
                    usuario.setApellido2(rs.getString("apellido2"));
                    usuario.setEdad(Integer.parseInt(rs.getString("edad")));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setGenero(rs.getString("genero"));
                    return usuario;
                }
            });
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuario);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body(usuario);
        }
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
        // tabla usuario
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

        // tabla favorito
        int cat_id = 0;
        query = String.format("select usuario_id from usuario where alias='%s' or correo='%s' ", forma.getAlias(), forma.getCorreo());
        int usuario_id = this.database.queryForObject(query, Integer.class);

        // para genero
        Favorito genero_fav = new Favorito();
        query = String.format("select catalogo_id from catalogo where nombre='%s' ", "genero");
        cat_id = this.database.queryForObject(query, Integer.class);
        genero_fav.setApi_id(forma.getGenero_favorito_id());
        genero_fav.setUsuario_id(usuario_id);
        genero_fav.setNombre_completo(forma.getGenero_favorito_nombre());
        genero_fav.setCatalogo_id(cat_id);
        favoritoRepositorio.save(genero_fav);

        // para pelicula
        Favorito peli_fav = new Favorito();
        query = String.format("select catalogo_id from catalogo where nombre='%s' ", "pelicula");
        cat_id = this.database.queryForObject(query, Integer.class);
        peli_fav.setApi_id(forma.getPeli_favorita_id());
        peli_fav.setUsuario_id(usuario_id);
        peli_fav.setNombre_completo(forma.getPeli_favorita_nombre());
        peli_fav.setCatalogo_id(cat_id);
        favoritoRepositorio.save(peli_fav);

        // para actor
        Favorito actor_fav = new Favorito();
        query = String.format("select catalogo_id from catalogo where nombre='%s' ", "actor");
        cat_id = this.database.queryForObject(query, Integer.class);
        actor_fav.setApi_id(forma.getActor_favorito_id());
        actor_fav.setUsuario_id(usuario_id);
        actor_fav.setNombre_completo(forma.getActor_favorito_nombre());
        actor_fav.setCatalogo_id(cat_id);
        favoritoRepositorio.save(actor_fav);

        // para director
        Favorito dir_fav = new Favorito();
        query = String.format("select catalogo_id from catalogo where nombre='%s' ", "director");
        cat_id = this.database.queryForObject(query, Integer.class);
        dir_fav.setApi_id(forma.getDir_favorito_id());
        dir_fav.setUsuario_id(usuario_id);
        dir_fav.setNombre_completo(forma.getDir_favorito_nombre());
        dir_fav.setCatalogo_id(cat_id);
        favoritoRepositorio.save(dir_fav);

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

    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.DELETE)
    @DeleteMapping(path="/usuario/clean-cache") 
    public ResponseEntity<String> cleanCache (@RequestParam String token){
        String query = String.format("select usuario_id from usuario where token='%s' ", token);
        int usuario_id = this.database.queryForObject(query, Integer.class);
        try {
            this.database.update("delete from recomendacion where usuario_id = ?", usuario_id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cache del usuario borrado exitosamente");
            
        } catch (Exception _e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error al borrar el cache del usuario.");
        }
    }
}