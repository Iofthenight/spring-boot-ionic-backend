package com.iofhtenight.cursomc.repositories;

import org.springframework.stereotype.Repository;

import com.iofhtenight.cursomc.domain.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer>{

}
