package com.bestpractice.mocking.domain;

public class Land {

	private String code;
	private int oppervlakte;

	public Land(String code, int oppervlakte) {
		this.code = code;
		this.oppervlakte = oppervlakte;
	}

	public String getCode() {
		return code;
	}

	public int getOppervlakte() {
		return oppervlakte;
	}

}
