package com.iofhtenight.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.iofhtenight.cursomc.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
