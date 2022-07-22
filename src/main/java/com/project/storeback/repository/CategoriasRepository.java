package com.project.storeback.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.storeback.models.Categorias;


@Repository
@Transactional
public interface CategoriasRepository extends CrudRepository<Categorias, Long>{
}
