package com.exams.frontend.test20102011;

public class Klantenkantoor {

	private int postcode;
	private String gemeente, adres;

	public Klantenkantoor(int postcode, String gemeente, String adres) {
		setPostcode(postcode);
		setGemeente(gemeente);
		setAdres(adres);
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Override
	public String toString() {
		return "Klantenkantoor [adres= " + adres + ", gemeente= " + gemeente + ",postcode=" + postcode + "]";
	}
}
