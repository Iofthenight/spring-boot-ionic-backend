package com.iofhtenight.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.iofhtenight.cursomc.domain.Cidade;
import com.iofhtenight.cursomc.domain.Cliente;
import com.iofhtenight.cursomc.domain.Endereco;
import com.iofhtenight.cursomc.domain.enums.TipoCliente;
import com.iofhtenight.cursomc.repositories.CidadeRepository;
import com.iofhtenight.cursomc.repositories.ClienteRepository;
import com.iofhtenight.cursomc.repositories.EnderecoRepository;
import com.iofhtenight.cursomc.services.exception.DataIntegrityException;
import com.iofhtenight.cursomc.services.exception.ObjectNotFoundException;
import com.iofthenight.cursomc.dto.ClienteDTO;
import com.iofthenight.cursomc.dto.ClienteNewDTO;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() ->  new ObjectNotFoundException(
				"Objecto não encontrado! Id:" + id + ", Tipo: " + Cliente.class.getName()));
	}


	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}	

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);			
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um cliente porque há entidades relacionadas.");
		}
	}

	public List<Cliente> findAll(){
		return repo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}


	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()));
		Optional<Cidade> cid = cidadeRepository.findById(objDto.getCidadeId());
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid.get());
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone());
		if(objDto.getTelefone1() != null)
			cli.getTelefones().add(objDto.getTelefone1());
		if(objDto.getTelefone1() != null)
			cli.getTelefones().add(objDto.getTelefone2());
		return cli;
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
