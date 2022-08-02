package com.project.storeback.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.storeback.models.Factura_Producto;

@Repository
@Transactional
public interface Factura_ProductoRepository extends CrudRepository<Factura_Producto, Long>{

}
