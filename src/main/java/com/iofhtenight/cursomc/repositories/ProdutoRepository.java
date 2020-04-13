package com.iofhtenight.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iofhtenight.cursomc.domain.Categoria;
import com.iofhtenight.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat "
			+ "WHERE obj.nome like %:nome% AND cat IN :categorias")
//	Page<Produto> search(@Param("nome") String nome,@Param("categorias") List<Categoria> categorias, Pageable pageRequest);
	Page<Produto> findDistinctByNomeContainingAndCategoriaIn(String nome, List<Categoria> categorias, Pageable pageRequest);

}
