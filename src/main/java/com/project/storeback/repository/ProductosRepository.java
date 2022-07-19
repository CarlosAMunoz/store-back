package com.project.storeback.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.storeback.models.Productos;

@Repository
@Transactional
public interface ProductosRepository extends CrudRepository<Productos, Long>{
    
}
