package fema.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fema.beans.Pais;

public class PaisDao {

	private EntityManager em;
	
	public PaisDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Pais pais) throws SQLException {
		em.getTransaction().begin();
		em.persist(pais);
		em.getTransaction().commit();
	}

	public void alterar(Pais pais) throws SQLException {
		em.getTransaction().begin();
		em.persist(pais);
		em.getTransaction().commit();
	}

	public void exluir(Pais pais) throws SQLException {
		em.getTransaction().begin();
		em.remove(pais);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Pais> getPaises() throws SQLException {
		String sql = "select * from pais ";
		Query consulta = em.createNativeQuery(sql, Pais.class);
		List<Pais> paises = consulta.getResultList();
		return paises;
	}

	public Pais getPaisPorCodigo(Integer id) throws SQLException {
		return em.find(Pais.class, id);
	}
}
