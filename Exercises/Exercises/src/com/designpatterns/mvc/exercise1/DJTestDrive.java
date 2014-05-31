package com.designpatterns.mvc.exercise1;

import com.designpatterns.mvc.exercise1.domein.BeatController;
import com.designpatterns.mvc.exercise1.gui.GuiBeatController;
import com.designpatterns.mvc.exercise1.interfaces.IController;

public class DJTestDrive {
	public static void main(String[] args) {
		IController domeinController = new BeatController();
		new GuiBeatController(domeinController);
	}
}
