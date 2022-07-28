package com.project.storeback.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.storeback.models.Direcciones;

@Repository
@Transactional
public interface DireccionesRepository extends CrudRepository<Direcciones, Long>{
    
}
