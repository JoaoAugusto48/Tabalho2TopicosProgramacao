package fema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class Controlador implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Banda> listaBanda = new ArrayList<Banda>();
	
	@Inject
	private BandaDao bandaDao;

	public void mostrarDados() {
		listaBanda = bandaDao.getBandas();
		for (Banda b : listaBanda) {
			System.out.println(b.getNome());
		}
	}

	public List<Banda> getListaBanda() {
		return listaBanda;
	}

	public void setListaBanda(List<Banda> listaBanda) {
		this.listaBanda = listaBanda;
	}
	
}
