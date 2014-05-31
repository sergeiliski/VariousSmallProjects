package com.bestpractice.jlist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class FilosofenFrame extends JFrame {
	private static final long serialVersionUID = 1506149452457056234L;
	private JList list;
	private FilosofenListModel filosofenListModel;

	public FilosofenFrame() {
		super("Favorite Philosophers");
		initGui();
	}

	public void initGui() {
		filosofenListModel = new FilosofenListModel();
		list = new JList(filosofenListModel);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton addButton = new JButton("Add philosopher");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String name = JOptionPane.showInputDialog(FilosofenFrame.this, "Enter name");
				filosofenListModel.addFilosoof(name);
			}
		});

		JButton removeButton = new JButton("Remove selected philosopher");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				filosofenListModel.removeFilosoof((String) list.getSelectedValue());
			}
		});
	}
}
