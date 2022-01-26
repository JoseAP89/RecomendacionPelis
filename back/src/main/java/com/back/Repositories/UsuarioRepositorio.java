package com.back.Repositories;
import org.springframework.data.repository.CrudRepository;
import com.back.Models.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
    
}
