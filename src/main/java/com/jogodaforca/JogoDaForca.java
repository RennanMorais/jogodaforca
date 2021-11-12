package com.jogodaforca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.jogodaforca.model.LetrasPalavra;

@SessionScoped
@ManagedBean(name = "jogoBean")
public class JogoDaForca {

	private String palavra;
	private LetrasPalavra letrasPalavra;
	private List<LetrasPalavra> letras = new ArrayList<LetrasPalavra>();
	private String letraJogada;
	private int chances = 6;
	private List<String> letrasUsadas = new ArrayList<String>();
	

	public void novaPalavra() {
		
		letrasUsadas.clear();
		letras.clear();
		chances = 6;
		palavra = palavra.toUpperCase();
		
		for (int i = 0; i < palavra.length(); i++) {
			
			letrasPalavra = new LetrasPalavra();
			letrasPalavra.setLetra(palavra.substring(i, i + 1));
			letras.add(letrasPalavra);
			// System.out.println(palavra.substring(i, i+1));

		}
		
		palavra = "";

	}

	public void mostrarLetra() {

		boolean acertou = false;
		
		for(int i=0; i < letras.size(); i++) {
			
			if(letras.get(i).getLetra().equalsIgnoreCase(letraJogada)) {
				acertou = true;
				letras.get(i).setContem(true);
			}
		}
		
		if(!acertou) {
			chances--;
		}
		
		letrasUsadas.add(letraJogada.toUpperCase());
		letraJogada = "";

	}
	
	public boolean isAcertou() {
		
		if(letras.isEmpty()) {
			return false;
		}
		
		for(int i=0; i < letras.size(); i++) {
			
			if(!letras.get(i).isContem()) {
				return false;
			}
		
		}
		
		return true;
	}

	public String getPalavra() {
		return palavra;
	}

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

	public int getChances() {
		return chances;
	}

	public void setChances(int chances) {
		this.chances = chances;
	}

	public List<String> getLetrasUsadas() {
		return letrasUsadas;
	}

	public void setLetrasUsadas(List<String> letrasUsadas) {
		this.letrasUsadas = letrasUsadas;
	}
}
