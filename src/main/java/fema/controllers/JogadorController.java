package fema.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fema.beans.Jogador;
import fema.dao.JogadorDao;

@Named
@SessionScoped
public class JogadorController {
	
	private static final long serialVersionUID = 1L;
	
	private Jogador jogador = new Jogador();
	
	@Inject
	private JogadorDao jogadorDao;
	
	public void adicionaJogador() throws Exception{
		this.jogadorDao.cadastrar(this.jogador);
	}
	
	
	public void excluiJogador(Jogador jogador) throws Exception{
		this.jogadorDao.exluir(jogador);
	}
	
	public Jogador buscaJogadorCodigo(Integer id) throws Exception{
		return this.jogadorDao.getJogadorPorCodigo(id);
	}
	
	public List<Jogador> buscaJogadores() throws Exception{
		List<Jogador> jogadores = this.jogadorDao.getJogadores();
		return jogadores;
	}
	
	public void atualizaJogador(Jogador jogador) throws Exception{
		 this.jogadorDao.alterar(jogador);
	}
	
}
