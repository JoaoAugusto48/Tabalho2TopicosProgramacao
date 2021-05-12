package fema.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fema.beans.Jogador;

public class JogadorDao {

	private EntityManager em;
	
	public JogadorDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Jogador jogador) throws SQLException {
		em.getTransaction().begin();
		em.persist(jogador);
		em.getTransaction().commit();
	}

	public void alterar(Jogador jogador) throws SQLException {
		em.getTransaction().begin();
		em.persist(jogador);
		em.getTransaction().commit();
	}

	public void exluir(Jogador jogador) throws SQLException {
		em.getTransaction().begin();
		em.remove(jogador);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Jogador> getJogadores(String nome) throws SQLException {
		String sql = "select * from jogador where nome ilike :nome order by nome";
		Query consulta = em.createNativeQuery(sql, Jogador.class);
		consulta.setParameter("nome", "%" + nome + "%");
		List<Jogador> jogadores = consulta.getResultList();
		return jogadores;
	}

	public Jogador getJogadorPorCodigo(Integer id) throws SQLException {
		return em.find(Jogador.class, id);
	}
	
}