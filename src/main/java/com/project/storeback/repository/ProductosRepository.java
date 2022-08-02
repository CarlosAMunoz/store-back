package com.project.storeback.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.storeback.models.Productos;

@Repository
@Transactional
public interface ProductosRepository extends CrudRepository<Productos, Long>{

    @Query(value = "SELECT * FROM `tbl_producto` WHERE id_categoria = :idCategoria", nativeQuery = true)
    Iterable<Productos> findByCategoria(@Param("idCategoria") Long Id);
   
}
