package com.exams.frontend.test20102011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KlantenkantoorTest {

	private List<Klantenkantoor> lijst;
	private ArrayList<Klantenkantoor> list;

	private Klantenkantoor kantoor1 = new Klantenkantoor(1500, "Halle", "Straat 1");
	private Klantenkantoor kantoor2 = new Klantenkantoor(1800, "Merelbeke", "Straat 2");
	private Klantenkantoor kantoor3 = new Klantenkantoor(6500, "Brussel", "Straat 3");
	private Klantenkantoor kantoor4 = new Klantenkantoor(9000, "Gent", "Straat 4");

	private final Klantenkantoor KANTOREN[] = { kantoor1, kantoor2, kantoor3, kantoor4 };

	@Before
	public void setUp() throws Exception {
		lijst = Arrays.asList(KANTOREN);
		list = new ArrayList<Klantenkantoor>();
	}

	@After
	public void tearDown() throws Exception {
		lijst = null;
	}

	@Test
	public void juisteSelectie() {
		list = (ArrayList<Klantenkantoor>) KlantenkantoorUtilities.kantorenMetZelfdeBegincijferPostcode(lijst, 1250);
		Assert.assertEquals(2, list.size());

		for (Klantenkantoor kantoor : list) {
			if (kantoor.getPostcode() == 1500) {
				Assert.assertEquals(1500, kantoor.getPostcode());
			} else if (kantoor.getPostcode() == 1800) {
				Assert.assertEquals(1800, kantoor.getPostcode());
			}
		}
	}

	@Test
	public void legeSelectie() {
		list = (ArrayList<Klantenkantoor>) KlantenkantoorUtilities.kantorenMetZelfdeBegincijferPostcode(lijst, 4500);
		Assert.assertEquals(true, list.isEmpty());
	}
}
