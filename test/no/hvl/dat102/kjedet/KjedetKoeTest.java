package no.hvl.dat102.kjedet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exception.EmptyCollectionException;

/**
 * Test for StabelADT.
 * 
 * @author Gruppe9
 */
public class KjedetKoeTest {

	// Referanse til stabel
	private KjedetKoe<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	/**
	 * Hent en ny koe for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = new KjedetKoe<Integer>();
	}

	/**
	 * Test p� at en ny k� er tom.
	 */
	@Test
	public void nyKoeErTomTest() {
		assertTrue(koe.erTom());
	}

	/**
	 * Test p� at en k� med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTomTest() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test p� at en k� tar imot flere elementer og at de g�r ut av k�en i rett
	 * rekkef�lge
	 */
	@Test
	public final void innOgUtKoeTest() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		assertEquals(e0, koe.utKoe());
		assertEquals(e1, koe.utKoe());
		assertEquals(e2, koe.utKoe());
		assertEquals(e3, koe.utKoe());
		assertEquals(e4, koe.utKoe());
	}

	/**
	 * Test p� inn og ut med duplikater
	 */
	@Test
	public final void innOgUtMedDuplikaterTest() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e2);
		koe.innKoe(e3);
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("failed unexpectedly " + e.getMessage());
		}

	}

	/**
	 *  
	 */
	@Test
	public void utKoeTomKoeExeptionTest() {

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}

	/**
	 * Test p� at en k� kan vise det f�rste elementet.
	 */
	@Test
	public final void foerste() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.utKoe();
		assertEquals(e1, koe.foerste());
	}

	/**
	 * Test p� at en k� holder styr p� antall elementer.
	 */
	@Test
	public final void toStringTest() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		assertEquals("1\n2\n3\n4\n5\n", koe.toString());
	}

	/**
	 * Test p� at en k� holder styr p� antall elementer.
	 */
	@Test
	public final void antallTest() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
		assertEquals(5, koe.antall());
	}
}