package com.exams.frontend.exam2009.question1;

import java.io.Serializable;

public class PartijUitslag implements Serializable {
	private static final long serialVersionUID = -4232013145616256646L;
	private String partijNaam;
	private int behaaldAantalStemmen;
	private String provincie;

	public PartijUitslag(String partijNaam, int behaaldAantalStemmen, String provincie) {
		setPartijNaam(partijNaam);
		setBehaaldAantalStemmen(behaaldAantalStemmen);
		setProvincie(provincie);
	}

	public String getPartijNaam() {
		return partijNaam;
	}

	public void setPartijNaam(String partijNaam) {
		this.partijNaam = partijNaam;
	}

	public int getBehaaldAantalStemmen() {
		return behaaldAantalStemmen;
	}

	public void setBehaaldAantalStemmen(int behaaldAantalStemmen) {
		this.behaaldAantalStemmen = behaaldAantalStemmen;
	}

	public String getProvincie() {
		return provincie;
	}

	public void setProvincie(String provincie) {
		this.provincie = provincie;
	}
}
