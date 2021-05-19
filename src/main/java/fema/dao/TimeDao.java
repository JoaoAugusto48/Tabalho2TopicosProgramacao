package fema.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fema.beans.Time;

public class TimeDao {

	private EntityManager em;
	
	public TimeDao(EntityManager em) {
		this.em = em;
	}

	public void cadastrar(Time time) throws SQLException {
		em.getTransaction().begin();
		em.persist(time);
		em.getTransaction().commit();
	}

	public void alterar(Time time) throws SQLException {
		em.getTransaction().begin();
		em.persist(time);
		em.getTransaction().commit();
	}

	public void exluir(Time time) throws SQLException {
		em.getTransaction().begin();
		em.remove(time);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Time> getTimes() throws SQLException {
		String sql = "select * from time";
		Query consulta = em.createNativeQuery(sql, Time.class);
		List<Time> times = consulta.getResultList();
		return times;
	}

	public Time getTimePorCodigo(Integer id) throws SQLException {
		return em.find(Time.class, id);
	}
	
}