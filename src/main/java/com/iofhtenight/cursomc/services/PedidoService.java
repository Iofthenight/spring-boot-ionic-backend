package com.iofhtenight.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iofhtenight.cursomc.domain.Pedido;
import com.iofhtenight.cursomc.repositories.PedidoRepository;
import com.iofhtenight.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() ->  new ObjectNotFoundException(
				"Objecto não encontrado! Id:" + id + ", Tipo: " + Pedido.class.getName()));
		}
}
