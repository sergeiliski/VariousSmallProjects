package com.bestpractice.mocking.persistence;

import com.bestpractice.mocking.domain.Land;

public interface ILandMapper {

	public int findOppervlakteAlleLanden();

	public Land findLand(String code);

}
