package fema.controllers;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fema.beans.Time;
import fema.dao.TimeDao;

@Named
@SessionScoped
public class TimeController {

private static final long serialVersionUID = 1L;
	
	private Time time = new Time();
	
	@Inject
	private TimeDao timeDao;
	
	public void adicionaTime() throws Exception{
		this.timeDao.cadastrar(this.time);
	}
	
	
	public void excluiTime(Time time) throws Exception{
		this.timeDao.exluir(time);
	}
	
	public Time buscaTimesCodigo(Integer id) throws Exception{
		return this.timeDao.getTimePorCodigo(id);
	}
	
	public List<Time> buscaTimes() throws Exception{
		List<Time> time = this.timeDao.getTimes();
		return time;
	}
	
	public void atualizaTime(Time time) throws Exception{
		 this.timeDao.alterar(time);
	}
	
}
