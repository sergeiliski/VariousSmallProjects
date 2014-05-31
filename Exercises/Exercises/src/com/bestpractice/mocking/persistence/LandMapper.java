package com.bestpractice.mocking.persistence;

import com.bestpractice.mocking.domain.Land;

public class LandMapper implements ILandMapper {

	@Override
	public int findOppervlakteAlleLanden() {
		// Naar de database
		return 0;
	}

	@Override
	public Land findLand(String code) {
		// Naar de database
		return null;
	}
}
