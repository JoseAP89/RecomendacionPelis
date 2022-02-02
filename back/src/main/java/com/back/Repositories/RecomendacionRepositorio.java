package com.back.Repositories;
import org.springframework.data.repository.CrudRepository;
import com.back.Models.Recomendacion;

public interface RecomendacionRepositorio  extends CrudRepository<Recomendacion, Integer> {
    
}
