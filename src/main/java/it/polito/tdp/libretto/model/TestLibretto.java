package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {
		
	Libretto lib;
	
	private void run() {
		this.lib=new Libretto();//creo un libretto vuoto
		Voto v1= new Voto("Tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2= new Voto("Analisi 2", 28, LocalDate.of(2020, 06, 28));
		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("Economia", 24, LocalDate.of(2020, 02, 14)));
		System.out.println("Stampo tutto il libretto:\n");
		System.out.println(this.lib.toString());
		System.out.println("Stampo voti uguali a 28 (ricevendo una stringa):\n");
		System.out.println(this.lib.stampaVotiUguali(28));//println riceve una stringa e la stampa
		System.out.println("Stampo voti uguali a 28 (ricevendo un libretto):\n");
		System.out.println(this.lib.estraiVotiUguali(28));//è println che chiama toString()
		//il vantaggio di ricevere un oggetto libretto è che potre farci delle operazioni di cui ho bisogno
		
	}

	public static void main(String[] args) {
		TestLibretto test= new TestLibretto();
		test.run();
	}

}
