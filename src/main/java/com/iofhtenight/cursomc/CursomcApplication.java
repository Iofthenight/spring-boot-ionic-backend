package com.iofhtenight.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iofhtenight.cursomc.domain.Categoria;
import com.iofhtenight.cursomc.domain.Cidade;
import com.iofhtenight.cursomc.domain.Cliente;
import com.iofhtenight.cursomc.domain.Endereco;
import com.iofhtenight.cursomc.domain.Estado;
import com.iofhtenight.cursomc.domain.ItemPedido;
import com.iofhtenight.cursomc.domain.Pagamento;
import com.iofhtenight.cursomc.domain.PagamentoComBoleto;
import com.iofhtenight.cursomc.domain.PagamentoComCartao;
import com.iofhtenight.cursomc.domain.Pedido;
import com.iofhtenight.cursomc.domain.Produto;
import com.iofhtenight.cursomc.domain.enums.EstadoPagamento;
import com.iofhtenight.cursomc.domain.enums.TipoCliente;
import com.iofhtenight.cursomc.repositories.CategoriaRepository;
import com.iofhtenight.cursomc.repositories.CidadeRepository;
import com.iofhtenight.cursomc.repositories.ClienteRepository;
import com.iofhtenight.cursomc.repositories.EnderecoRepository;
import com.iofhtenight.cursomc.repositories.EstadoRepository;
import com.iofhtenight.cursomc.repositories.ItemPedidoRepository;
import com.iofhtenight.cursomc.repositories.PagamentoRepository;
import com.iofhtenight.cursomc.repositories.PedidoRepository;
import com.iofhtenight.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				
	}
}
