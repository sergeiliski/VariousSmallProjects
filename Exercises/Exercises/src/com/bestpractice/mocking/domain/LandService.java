package com.bestpractice.mocking.domain;

import com.bestpractice.mocking.persistence.PersistentieController;

public class LandService {

	private PersistentieController persistentieController;

	public LandService() {
		this.persistentieController = new PersistentieController();
	}

	public LandService(PersistentieController persistentieController) {
		this.persistentieController = persistentieController;
	}

	public LandStatistiek getLandStatistiek(String code) {
		if (code.isEmpty()) {
			throw new IllegalArgumentException("Code kan niet leeg zijn");
		}

		Land land = persistentieController.findLand(code);
		if (land == null) {
			return null;
		}

		double verhouding = getVerhouding(land);

		return new LandStatistiek(land, verhouding);
	}

	public double getVerhouding(Land land) {
		int oppervlakteAlleLanden = persistentieController.findOppervlakteAlleLanden();
		double verhouding = (double) (land.getOppervlakte()) / (double) (oppervlakteAlleLanden);

		return verhouding;
	}
}
