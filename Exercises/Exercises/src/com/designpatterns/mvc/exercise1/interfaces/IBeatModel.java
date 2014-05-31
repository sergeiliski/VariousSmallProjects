package com.designpatterns.mvc.exercise1.interfaces;

public interface IBeatModel
{
	void initialize();

	void on();

	void off();

	void setBPM(int bpm);

	int getBPM();

	void addObserver(BeatObserver o);

	void removeObserver(BeatObserver o);

	void addObserver(BPMObserver o);

	void removeObserver(BPMObserver o);
}
