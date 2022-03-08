package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	private List<String> listaparole;
	
	public Parole() {
		this.listaparole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		this.listaparole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(listaparole, new ComparatoreOrdineAlfabetico());
		return listaparole;
	}
	
	public void reset() {
		this.listaparole = new ArrayList<String>();
	}
	
	public void delete(String parolaDaCancellare) {
		List<String> listaparole2 = new ArrayList<String>(listaparole);
		listaparole.clear();
		for(String s: listaparole2)
			if(s.compareTo(parolaDaCancellare)!=0)
				listaparole.add(s);
	}
	
	@Override
	public String toString() {
		String risultato = "";
		for(String s: listaparole)
			risultato+= s + "\n";
		return risultato;
	}

}
