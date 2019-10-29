package com.iofhtenight.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.iofhtenight.cursomc.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
