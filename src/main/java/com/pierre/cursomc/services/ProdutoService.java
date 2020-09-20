package com.pierre.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pierre.cursomc.domain.Categoria;
import com.pierre.cursomc.domain.Produto;
import com.pierre.cursomc.repositories.CategoriaRepository;
import com.pierre.cursomc.repositories.ProdutoRepository;
import com.pierre.cursomc.services.exceptions.ObjectNotfoundException;
@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotfoundException(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
 }
   		public Page<Produto> search(String nome, List<Integer> ids,Integer page, Integer linesPerPage, String orderBy, String direction) {
   			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
   			List<Categoria> categoarias = categoriaRepository.findAllById(ids);
   			return repo.search(nome,categoarias,pageRequest);
   		}
}
