package com.bestpractice.tablemodel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableDemo extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3880680535728261820L;
	private JPanel panel;
	private JTable jTable;
	private MyTableModel myTableModel;

	public TableDemo() {
		initGUI();
	}

	private void initGUI() {
		try {
			getContentPane().setLayout(new BorderLayout());
			// new GridLayout(1, 0));
			{
				panel = new JPanel();
				getContentPane().add(panel, BorderLayout.CENTER);
				myTableModel = new MyTableModel();
				jTable = new JTable();
				jTable.setModel(myTableModel);
				jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
				JScrollPane scrollPane = new JScrollPane(jTable);
				panel.add(scrollPane);
			}

			this.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent event) {
					System.exit(0);
				}
			});

			pack();
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}