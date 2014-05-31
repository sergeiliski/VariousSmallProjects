package com.bestpractice.mocking.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.bestpractice.mocking.domain.Land;
import com.bestpractice.mocking.domain.LandService;
import com.bestpractice.mocking.domain.LandStatistiek;
import com.bestpractice.mocking.persistence.ILandMapper;
import com.bestpractice.mocking.persistence.PersistentieController;

public class LandServiceTest {

	private static final String CODE = "BE";

	private LandService landService;
	private ILandMapper landMapperDummy;

	@Before
	public void setUp() throws Exception {
		// Mock object van de te mocken klasse aanmaken
		landMapperDummy = Mockito.mock(ILandMapper.class);

		// Mock object injecteren via de gekozen methode
		PersistentieController persistentieController = new PersistentieController();
		persistentieController.setLandMapper(landMapperDummy);

		landService = new LandService(persistentieController);
	}

	@Test
	public void getLandStatistiek() {
		// Mock trainen met waarden
		// Aka: Instellen wat er teruggegeven moet worden indien die methode
		// wordt aangeroepen
		// Dit is niet de eigenlijk test!
		Mockito.when(landMapperDummy.findLand(CODE)).thenReturn(new Land(CODE, 50));
		Mockito.when(landMapperDummy.findOppervlakteAlleLanden()).thenReturn(100);

		// Eigenlijke test uitvoeren
		LandStatistiek landStatistiek = landService.getLandStatistiek(CODE);
		assertEquals(0.5, landStatistiek.getVerhouding(), 0.49);

		// Nagaan of de mock werd gebruikt in de bovenstaande test
		Mockito.verify(landMapperDummy).findLand(CODE);
		Mockito.verify(landMapperDummy).findOppervlakteAlleLanden();
	}

	@Test(expected = IllegalArgumentException.class)
	public void legeCode() {
		landService.getLandStatistiek("");
	}

	@Test(expected = NullPointerException.class)
	public void nullCode() {
		landService.getLandStatistiek(null);
	}

	@Test
	public void getVerhouding() {
		Mockito.when(landMapperDummy.findLand(CODE)).thenReturn(new Land(CODE, 50));
		Mockito.when(landMapperDummy.findOppervlakteAlleLanden()).thenReturn(100);

		assertEquals(0.5, landService.getLandStatistiek(CODE).getVerhouding(), 0.0);

		Mockito.verify(landMapperDummy).findLand(CODE);
		Mockito.verify(landMapperDummy).findOppervlakteAlleLanden();
	}

	@Test
	public void geenLand() {
		Mockito.when(landMapperDummy.findLand(CODE)).thenReturn(null);

		assertNull(landService.getLandStatistiek(CODE));

		Mockito.verify(landMapperDummy).findLand(CODE);
	}
}
