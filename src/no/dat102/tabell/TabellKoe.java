package no.dat102.tabell;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

/**
 * @author TAE
 * @param <T>
 * 
 */
//********************************************************************
//  Representerer en tabell implementasjon av samling kø.
// front til køen er i posisjon 0.
//********************************************************************

public class TabellKoe<T> implements KoeADT<T> {
	private final static int STDK = 100;
	private int bak;
	private T[] koe;

	/******************************************************************
	 * Oppretter en tom kø med standard størrelse.
	 ******************************************************************/
	public TabellKoe() {
		this(STDK);
		bak = 0;
	}

	/******************************************************************
	 * Oppretter en tom kø med spesifisert kapasitet..
	 ******************************************************************/
	public TabellKoe(int startKapasitet) {
		bak = 0;
		koe = (T[]) (new Object[startKapasitet]);
	}

	/******************************************************************
	 * Legger til et spesifisert element bak i køen, utvider hvis nødvendig
	 ******************************************************************/
	public void innKoe(T element) {
		if (bak == koe.length) {
			utvid();
		}
		koe[bak] = element;
		bak++;
		trimTab(koe, bak);
	}

	/******************************************************************
	 * Fjerner elementet foran i køen.
	 ******************************************************************/
	public T utKoe() {

		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}

		T resultat = koe[0];

		/** flytter elementene en plass fram */
		for (int i = 0; i < bak; i++) {
			koe[i] = koe[i + 1];
		}
		koe[bak--] = null;
		return resultat;

	}

	/******************************************************************
	 * Returnerer elementet foran, her blir dette index 0.
	 ******************************************************************/
	public T foerste() {

		if (erTom()) {
			throw new EmptyCollectionException("koe");
		}

		T resultat = koe[0];
		return resultat;

	}

	/******************************************************************
	 * Returnerer sann hvis køen er tom, usann ellers..
	 ******************************************************************/
	public boolean erTom() {
		return (bak == 0);
	}

	/******************************************************************
	 * Returnerer antall elementer i køen.
	 ******************************************************************/
	public int antall() {
		return bak;
	}

	/******************************************************************
	 * Returnerer en strengrepresentasjon av elementene i køen.
	 ******************************************************************/
	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + koe[i].toString() + "\n";
		}
		return resultat;
	}

	/******************************************************************
	 * Oppretter en ny større tabell for å lagre elmenetene.
	 ******************************************************************/
	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[bak + 1]);

		for (int i = 0; i < koe.length; i++) {
			hjelpetabell[i] = koe[i];
		}

		koe = hjelpetabell;
	}

	/******************************************************************
	 * Tar en tabell som parameter og trimmer den til antall.
	 ******************************************************************/
	private T[] trimTab(T[] tab, int n) { // n er antall elementer
		T[] hjelpetabell = (T[]) (new Object[n]);
		int i = 0;
		while (i < n) {
			hjelpetabell[i] = tab[i];
			i++;
		}
		return hjelpetabell;
	}

}// class
