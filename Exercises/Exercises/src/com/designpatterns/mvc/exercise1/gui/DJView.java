package com.designpatterns.mvc.exercise1.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.designpatterns.mvc.exercise1.interfaces.BPMObserver;
import com.designpatterns.mvc.exercise1.interfaces.BeatObserver;
import com.designpatterns.mvc.exercise1.interfaces.IController;
import com.designpatterns.mvc.exercise1.interfaces.IGuiController;

public class DJView implements ActionListener, BeatObserver, BPMObserver {
	private JFrame viewFrame;
	private JPanel viewPanel;
	private BeatBar beatBar;
	private JLabel bpmOutputLabel;
	private JFrame controlFrame;
	private JPanel controlPanel;
	private JLabel bpmLabel;
	private JTextField bpmTextField;
	private JButton setBPMButton;
	private JButton increaseBPMButton;
	private JButton decreaseBPMButton;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem startMenuItem;
	private JMenuItem stopMenuItem;
	private IGuiController guiController;
	private IController domeinController;

	public DJView(IGuiController guiController, IController domeinController) {
		this.guiController = guiController;
		this.domeinController = domeinController;
		domeinController.addObserver((BeatObserver) this);
		domeinController.addObserver((BPMObserver) this);
	}

	public void createView() {
		// Create all Swing components here
		viewPanel = new JPanel(new GridLayout(1, 2));
		viewFrame = new JFrame("View");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setSize(new Dimension(100, 80));
		bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
		JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		bpmPanel.add(beatBar);
		bpmPanel.add(bpmOutputLabel);
		viewPanel.add(bpmPanel);
		viewFrame.getContentPane().add(viewPanel, BorderLayout.CENTER);
		viewFrame.pack();
		viewFrame.setVisible(true);
	}

	public void createControls() {
		// Create all Swing components here
		JFrame.setDefaultLookAndFeelDecorated(true);
		controlFrame = new JFrame("Control");
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setSize(new Dimension(100, 80));

		controlPanel = new JPanel(new GridLayout(1, 2));

		menuBar = new JMenuBar();
		menu = new JMenu("DJ Control");
		startMenuItem = new JMenuItem("Start");
		menu.add(startMenuItem);
		startMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				domeinController.start();
				guiController.start();
			}
		});
		stopMenuItem = new JMenuItem("Stop");
		menu.add(stopMenuItem);
		stopMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				domeinController.stop();
				guiController.stop();
			}
		});
		JMenuItem exit = new JMenuItem("Quit");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		menu.add(exit);
		menuBar.add(menu);
		controlFrame.setJMenuBar(menuBar);

		bpmTextField = new JTextField(2);
		bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
		setBPMButton = new JButton("Set");
		setBPMButton.setSize(new Dimension(10, 40));
		increaseBPMButton = new JButton(">>");
		decreaseBPMButton = new JButton("<<");
		setBPMButton.addActionListener(this);
		increaseBPMButton.addActionListener(this);
		decreaseBPMButton.addActionListener(this);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

		buttonPanel.add(decreaseBPMButton);
		buttonPanel.add(increaseBPMButton);

		JPanel enterPanel = new JPanel(new GridLayout(1, 2));
		enterPanel.add(bpmLabel);
		enterPanel.add(bpmTextField);
		JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
		insideControlPanel.add(enterPanel);
		insideControlPanel.add(setBPMButton);
		insideControlPanel.add(buttonPanel);
		controlPanel.add(insideControlPanel);

		bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		controlFrame.getRootPane().setDefaultButton(setBPMButton);
		controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);

		controlFrame.pack();
		controlFrame.setVisible(true);
	}

	public void enableStopMenuItem() {
		stopMenuItem.setEnabled(true);
	}

	public void disableStopMenuItem() {
		stopMenuItem.setEnabled(false);
	}

	public void enableStartMenuItem() {
		startMenuItem.setEnabled(true);
	}

	public void disableStartMenuItem() {
		startMenuItem.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == setBPMButton) {
			if (!(bpmTextField.getText().equals("")))
			{
				int bpm = Integer.parseInt(bpmTextField.getText());
				domeinController.setBPM(bpm);
			}
		} else if (event.getSource() == increaseBPMButton) {
			domeinController.increaseBPM();
		} else if (event.getSource() == decreaseBPMButton) {
			domeinController.decreaseBPM();
		}
	}

	@Override
	public void updateBPM() {
		// if (model != null) {
		int bpm = domeinController.getBPM();
		if (bpm == 0) {
			if (bpmOutputLabel != null) {
				bpmOutputLabel.setText("offline");
			}
		} else {
			if (bpmOutputLabel != null) {
				bpmOutputLabel.setText("Current BPM: " + domeinController.getBPM());
			}
		}
	}

	@Override
	public void updateBeat() {
		if (beatBar != null) {
			beatBar.setValue(100);
		}
	}

	public void setVisible(boolean visible)
	{
		this.controlFrame.setVisible(visible);
	}
}
