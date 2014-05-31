package com.bestpractice.mocking.persistence;

import com.bestpractice.mocking.domain.Land;

public class PersistentieController {

	private ILandMapper landMapper = new LandMapper();

	public Land findLand(String code) {
		return landMapper.findLand(code);
	}

	public int findOppervlakteAlleLanden() {
		return landMapper.findOppervlakteAlleLanden();
	}

	// Setter injection

	public void setLandMapper(ILandMapper landMapper) {
		this.landMapper = landMapper;
	}
}
