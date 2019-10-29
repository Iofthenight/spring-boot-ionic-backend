package com.iofhtenight.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.iofhtenight.cursomc.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
