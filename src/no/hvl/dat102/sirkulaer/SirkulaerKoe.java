/**
 * 
 */
package no.hvl.dat102.sirkulaer;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

/**
 * @author TAE
 * @param <T>
 * 
 */
public class SirkulaerKoe<T> implements KoeADT<T> {

	private final static int STDK = 100;
	private int foran, bak, antall;
	private T[] koe;

	public SirkulaerKoe() {
		this(STDK);
	}

	public SirkulaerKoe(int startKapasitet) {
		foran = bak = antall = 0;
		koe = ((T[]) (new Object[startKapasitet]));
	}

	public void innKoe(T element) {
		if (antall() == koe.length)
			utvid();
		koe[bak++] = element;
		antall++;

	}

	public T utKoe() {
		if (erTom())
			throw new EmptyCollectionException("koe");
		T element = koe[foran];
		koe[foran] = null;
		foran++;
		antall--;
		return element;
	}

	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("koe");

		T resultat = koe[foran];
		return resultat;
	}

	public boolean erTom() {
		return (antall == 0);
	}

	public int antall() {
		return antall;
	}

	private void utvid() {
		T[] hjelpetabell = (T[]) (new Object[koe.length * 2]);
		for (int i = 0; i < hjelpetabell.length; i++) {
			hjelpetabell[i] = koe[i];
		}
		koe = hjelpetabell;

	}

	/******************************************************************
	 * Returnerer en strengrepresentasjon av elementene i k�en.
	 ******************************************************************/
	public String toString() {
		String resultat = "";

		for (int i = foran; i < bak; i++) {
			resultat = resultat + koe[i].toString() + "\n";
		}

		return resultat;
	}
}// class
