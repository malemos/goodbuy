package br.com.goodbuy.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.goodbuy.model.Produto;

@Component
public class ProdutoDao {

	private Session session;

	public ProdutoDao(Session session) {
		this.session = session;
	}

	public void adicao(Produto produto) {
		Transaction transaction = this.session.beginTransaction();
		session.save(produto);
		transaction.commit();
	}

	public void edicao(Produto produto) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(produto);
		transaction.commit();
	}

	public void exclusao(Produto produto) {
		Transaction transaction = session.beginTransaction();
		session.delete(produto);
		transaction.commit();
	}

	public Produto findById(Long id) {
		return (Produto) session.load(Produto.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Produto> findAll() {
		return (List<Produto>) session.createCriteria(Produto.class).list();
	}
}
