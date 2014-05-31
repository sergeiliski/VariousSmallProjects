package com.designpatterns.mvc.exercise1.domein;

import com.designpatterns.mvc.exercise1.interfaces.BPMObserver;
import com.designpatterns.mvc.exercise1.interfaces.BeatObserver;
import com.designpatterns.mvc.exercise1.interfaces.IBeatModel;
import com.designpatterns.mvc.exercise1.interfaces.IController;

public class BeatController implements IController
{
	private IBeatModel model;

	public BeatController()
	{
		this.model = new BeatModel();
		model.initialize();
	}

	@Override
	public void start() {
		model.on();
	}

	@Override
	public void stop() {
		model.off();
	}

	@Override
	public void increaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm + 1);
	}

	@Override
	public void decreaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm - 1);
	}

	@Override
	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}

	@Override
	public int getBPM()
	{
		return model.getBPM();
	}

	@Override
	public void addObserver(BeatObserver beatObserver)
	{
		model.addObserver(beatObserver);
	}

	@Override
	public void addObserver(BPMObserver beatObserver)
	{
		model.addObserver(beatObserver);
	}
}
