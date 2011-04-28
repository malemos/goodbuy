package br.com.goodbuy.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.goodbuy.model.Produto;
import br.com.goodbuy.model.dao.ProdutoDao;

@Resource
public class ProdutoController {

	private ProdutoDao produtoDao;
	private Result result;
	private Validator validator;

	public ProdutoController(ProdutoDao produtoDao, Result result, Validator validator) {
		this.produtoDao = produtoDao;
		this.result = result;
		this.validator = validator;
	}

	@Get("/produto")
	public List<Produto> lista() {
		return produtoDao.findAll();
	}

	@Get("/produto/novo")
	public void formulario() {
	}

	@Post("/produto")
	public void adiciona(Produto produto) {
		validator.validate(produto);
		validator.onErrorRedirectTo(this).formulario();
		produtoDao.adicao(produto);
		result.redirectTo(this).lista();
	}

	@Get("/produto/{id}")
	public Produto edita(Long id) {
		return produtoDao.findById(id);
	}

	@Put("/produto/{produto.id}")
	public void altera(Produto produto) {
		validator.validate(produto);
		validator.onErrorRedirectTo(this).formulario();
		produtoDao.edicao(produto);
		result.redirectTo(this).lista();
	}
	
	@Delete("/produto/{id}")
	public void remove(Long id) {
		Produto produto = produtoDao.findById(id);
		produtoDao.exclusao(produto);
		result.redirectTo(this).lista();
	}
}
