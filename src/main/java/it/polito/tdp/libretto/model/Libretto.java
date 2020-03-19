package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di voti superati.
 * 
 * @author Lorenzo
 *
 */
public class Libretto {
	private List<Voto> voti= new ArrayList<>();

	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v Voto da aggiungere
	 * @return Restituisce {@code true} se inserisco il voto, {@code false} se non ha inserito 
	 * perche' in conflitto o duplicato
	 */
	public boolean add(Voto v) {
		if(this.isConflitto(v) || this.isDuplicato(v))
			return false;//non inserisco il voto perchè sarebbe duplicato o in conflitto
		 this.voti.add(v);
		 return true;
	}

	/**
	 * Dato un Libretto, restituisce una stringa nella quale vi sono solamente i
	 * voti pari al valore specificato
	 * 
	 * @param voto valore specificato
	 * @return stringa formattata per visualizzare il sotto-libretto
	 */
	public String stampaVotiUguali(int voto) {
		String votiUguali="";
		for(Voto v: this.voti) {
			if(v.getVoto()==voto)
				votiUguali+=v.toString()+"\n";
		}
		return votiUguali;
	}
	
	/**
	 * Genera un nuovo libretto, a partire da quello esistente,
	 * che conterrà esclusivamente i voti con votazione pari a quella specificata.
	 * @param voto votazione specificata
	 * @return nuovo Libretto "ridotto"
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto libretto=new Libretto();
		for(Voto v:this.voti) {
			if(v.getVoto()==voto)
				libretto.add(v);
		}
		return libretto;
	}

	public String toString() {
		String s="";
		for(Voto v:this.voti) {
			s+=v.toString()+"\n";
		}
		return s;
	}
	/**
	 * Dato il nome di un corso, ricerca se quell'esame esiste nel libretto, 
	 * in caso affermativo restituisce l'oggetto {@link Voto} corrispondente.
	 * Se l'esame non esiste restituisce {@code null}
	 * @param nomeCorso
	 * @return Se il corso esiste ritorna il {@link Voto} corrispondente, {@code null} altrimenti
	 */
	public Voto cercaNomeCorso(String nomeCorso) {
		/*for(Voto v:voti) {
			if(v.getCorso().compareTo(nomeCorso)==0)
				return v;
		}
		return null;*/
		int pos=this.voti.indexOf(new Voto(nomeCorso, 0, null) );
		if(pos!=-1)
			return voti.get(pos);
		return null;
	}
	/**
	 * Ritorna {@code true} se il corso specificato dal {@link Voto} {@code v} 
	 * esiste nel libretto, con la stessa valutazione. 
	 * Se non esiste, o se la valutazione e' diversa ritorna {@code false}
	 * @param v il {@link Voto} da cercare
	 * @returnl'esistenza di un duplicato
	 */
	public boolean isDuplicato(Voto v) {
		Voto esiste= this.cercaNomeCorso(v.getCorso());
		if(esiste==null)
			return false;//non l'ho trovato quindi non può essere duplicato
		/*if(esiste.getVoto()==v.getVoto())
			return true;
		else return false;*/
		return (esiste.getVoto()==v.getVoto());
	}
	/**
	 * Determina se esiste un {@link voto} con lo stesso nome corso ma con valutazione diversa
	 * @param v
	 * @return
	 */
	public boolean isConflitto(Voto v) {
		Voto esiste= this.cercaNomeCorso(v.getCorso());
		if(esiste==null)
			return false;//non l'ho trovato quindi non può essere duplicato
		return (esiste.getVoto()!=v.getVoto());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
