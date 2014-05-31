package com.designpatterns.mvc.exercise1.interfaces;

public interface IController {
	void start();
	void stop();
	void increaseBPM();
	void decreaseBPM();
	void setBPM(int bpm);
	int getBPM();
	void addObserver(BPMObserver bpmObserver);
	void addObserver(BeatObserver beatObserver);
}
