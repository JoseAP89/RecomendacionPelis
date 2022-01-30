package com.back.Repositories;
import org.springframework.data.repository.CrudRepository;
import com.back.Models.Favorito;

public interface FavoritoRepositorio  extends CrudRepository<Favorito, Integer> {
    
}
