package com.designpatterns.mvc.exercise1.gui;

import com.designpatterns.mvc.exercise1.interfaces.IController;
import com.designpatterns.mvc.exercise1.interfaces.IGuiController;

public class GuiBeatController implements IGuiController {

	private DJView view;

	public GuiBeatController(IController domeinController)
	{
		view = new DJView(this, domeinController);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}

	@Override
	public void start() {
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}

	@Override
	public void stop() {
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}
}