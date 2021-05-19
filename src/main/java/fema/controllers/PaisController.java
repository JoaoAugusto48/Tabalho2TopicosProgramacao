package fema.controllers;

import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fema.beans.Pais;
import fema.dao.PaisDao;

@Named
@SessionScoped
public class PaisController {

private static final long serialVersionUID = 1L;
	
	private Pais pais = new Pais();
	
	@Inject
	private PaisDao paisDao;
	
	public void adicionaPais() throws Exception{
		this.paisDao.cadastrar(this.pais);
	}
	
	
	public void excluiPais(Pais pais) throws Exception{
		this.paisDao.exluir(pais);
	}
	
	public Pais buscaPaisCodigo(Integer id) throws Exception{
		return this.paisDao.getPaisPorCodigo(id);
	}
	
	public List<Pais> buscaPaises() throws Exception{
		List<Pais> pais = this.paisDao.getPaises();
		return pais;
	}
	
	public void atualizaPais(Pais pais) throws Exception{
		 this.paisDao.alterar(pais);
	}
	
}
