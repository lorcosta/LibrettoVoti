package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
		
	Libretto lib;
	
	private void run() {
		this.lib=new Libretto();//creo un libretto vuoto
		//1. Inserire alcuni voti
		Voto v1= new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2= new Voto("Analisi 2", 28, LocalDate.of(2020, 06, 28));
		lib.add(v1);
		lib.add(v2);
		if(lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)))==false)
				System.err.println("Errore nell'inserimento del voto");
		System.out.println("Stampo tutto il libretto:\n");
		System.out.println(this.lib.toString());
		//2. Stampa tutti i voti uguali a 28
		System.out.println("Stampo voti uguali a 28 (ricevendo una stringa):\n");
		System.out.println(this.lib.stampaVotiUguali(28));//println riceve una stringa e la stampa
		System.out.println("Stampo voti uguali a 28 (ricevendo un libretto):\n");
		System.out.println(this.lib.estraiVotiUguali(28));//è println che chiama toString()
		//il vantaggio di ricevere un oggetto libretto è che potre farci delle operazioni di cui ho bisogno
		//3. Cerca un esame superato conoscendo il nome del corso
		String nomeCorso="Analisi 2";
		Voto votoAnalisi=lib.cercaNomeCorso(nomeCorso); 
		System.out.println("Il voto di "+nomeCorso+" e' "+votoAnalisi.getVoto());
		nomeCorso="Fisica 1";
		Voto votoMancante=lib.cercaNomeCorso(nomeCorso); 
		System.out.println("Il voto di "+nomeCorso+" e' "+votoMancante);
		//4./5.Creo nuovo Voto e verifico se esiste già o se è in conflitto
		Voto economia2 =new Voto("Economia", 24, LocalDate.now());
		Voto economia3 =new Voto("Economia", 21, LocalDate.now());
		System.out.println("Economia con 24 e' duplicato: "+lib.isDuplicato(economia2)+
				"/ conflitto: "+lib.isConflitto(economia2));
		System.out.println("Economia con 21 e' duplicato: "+lib.isDuplicato(economia3)+
				"/ conflitto: "+lib.isConflitto(economia3));
		
	}

	public static void main(String[] args) {
		TestLibretto test= new TestLibretto();
		test.run();
	}

}
