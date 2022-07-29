package com.project.storeback.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.storeback.models.Usuario;


@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
}
