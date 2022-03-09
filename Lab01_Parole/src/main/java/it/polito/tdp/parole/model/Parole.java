package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	List<String> parole;
		
	public Parole() {
		//TODO
		parole = new LinkedList<String>();
		//parole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		//TODO
		parole.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		// TODO
		parole.clear();
	}
	
	public void cancella(String s) {
		parole.remove(s);
	}

}
