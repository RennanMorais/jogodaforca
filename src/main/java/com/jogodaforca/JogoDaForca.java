package com.jogodaforca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jogodaforca.model.LetrasPalavra;

@ViewScoped
@ManagedBean(name = "jogoBean")
public class JogoDaForca {

	private final String[] PALAVRAS = { "CACHORRO", "GATO", "CELULAR", "CARRO", "MOTO", "PASSEIO", "RODA", "TRABALHO", "AJUDAR", "CABELO", "FUTEBOL", "VOLEI", "NADAR", "COZINHAR", "PARALELEPIPEDO", "ESCOLA", "PAPEL", "BASQUETE", "PASTEL"};
	private String palavra;
	private LetrasPalavra letrasPalavra;
	List<LetrasPalavra> letras = new ArrayList<LetrasPalavra>();
	private String letraJogada;
	private int chances = 6;

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public LetrasPalavra getLetrasPalavra() {
		return letrasPalavra;
	}

	public void setLetrasPalavra(LetrasPalavra letrasPalavra) {
		this.letrasPalavra = letrasPalavra;
	}
//
	public List<LetrasPalavra> getLetras() {
		return letras;
	}

	public void setLetras(List<LetrasPalavra> letras) {
		this.letras = letras;
	}

	public String getLetraJogada() {
		return letraJogada;
	}

	public void setLetraJogada(String letraJogada) {
		this.letraJogada = letraJogada;
	}

	public void novaPalavra() {
		
		letras.clear();
		
		Random prop = new Random();
		int a = prop.nextInt(PALAVRAS.length);
		palavra = PALAVRAS[a];

		for (int i = 0; i < palavra.length(); i++) {
			
			letrasPalavra = new LetrasPalavra();
			letrasPalavra.setLetra(palavra.substring(i, i + 1));
			letras.add(letrasPalavra);
			// System.out.println(palavra.substring(i, i+1));

		}

	}

	public void mostrarLetra() {

		String letraJogadaM = letraJogada.toUpperCase();
		
		for(int i=0; i < letras.size(); i++) {
			
			if(letraJogadaM.equals(letras.get(i).getLetra())) {
				letras.get(i).setContem(true);
			} else {
				chances -= 1;
			}
			
		}
		
		letraJogada = "";

	}

}
