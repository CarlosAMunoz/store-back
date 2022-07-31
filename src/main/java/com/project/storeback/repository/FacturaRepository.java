package com.project.storeback.repository;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.storeback.models.Factura;

@Repository
@Transactional
public interface FacturaRepository extends CrudRepository<Factura, Long>{
    
}
