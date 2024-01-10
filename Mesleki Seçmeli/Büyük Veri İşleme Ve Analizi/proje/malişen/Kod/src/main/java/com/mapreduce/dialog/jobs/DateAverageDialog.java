package com.mapreduce.dialog.jobs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mapreduce.ReadWrite;
import com.mapreduce.dialog.TableDialog;
import com.mapreduce.jobs.dateaverage.DateAverageDriver;
import com.mapreduce.jobs.dateaverage.DateAverageMapper;
import com.mapreduce.util.MultiRenderer;
import com.mapreduce.util.SelectionManager;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class DateAverageDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel_1;
	private JComboBox<String> comboBox;
	private JTextField textField;
	private JDatePickerImpl datePicker;
	private JDatePickerImpl datePicker_1;

	/**
	 * Create the dialog.
	 */
	public DateAverageDialog() {
		setTitle("Date Average");
		setBounds(100, 100, 554, 199);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{15, 146, 0};
		gbl_contentPanel.rowHeights = new int[]{39, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			lblNewLabel_1 = new JLabel("Inputs: ");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 0;
			gbc_lblNewLabel_1.gridy = 0;
			contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		try {
			comboBox.setModel(new DefaultComboBoxModel<String>(ReadWrite.getFiles("/")));
		} catch (IllegalArgumentException | IOException e1) {
			e1.printStackTrace();
		}
		final SelectionManager manager = new SelectionManager();
		MultiRenderer renderer = new MultiRenderer(manager);
		comboBox.addActionListener(manager);
		comboBox.setRenderer(renderer);

		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		contentPanel.add(comboBox, gbc_comboBox);
		{
			JLabel lblNewLabel = new JLabel("Output: ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("From: ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 2;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			UtilDateModel model = new UtilDateModel();
			JDatePanelImpl datePanel = new JDatePanelImpl(model);
			datePicker = new JDatePickerImpl(datePanel);
			datePicker.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 2;
			contentPanel.add(datePicker, gbc_textField_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("To: ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 3;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			UtilDateModel model = new UtilDateModel();
			JDatePanelImpl datePanel = new JDatePanelImpl(model);
			datePicker_1 = new JDatePickerImpl(datePanel);
			datePicker_1.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 18));
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 3;
			contentPanel.add(datePicker_1, gbc_textField_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String[] selected = manager.selectedItems.stream().map(i -> ReadWrite.root.toString() + i).toArray(String[]::new);
						if (selected == null || selected.length == 0) return;
						String output = textField.getText();
						if (output == null || output.trim().isEmpty()) return;
						DateAverageMapper.from = (Date) datePicker.getModel().getValue();
						if (DateAverageMapper.from == null) return;
						DateAverageMapper.to = (Date) datePicker.getModel().getValue();
						if (DateAverageMapper.to == null) return;
						long start = System.nanoTime();
						DateAverageDriver.run(selected, output);
						long end = System.nanoTime();
						System.out.printf("%.2fs elapsed\n", ((end - start) * Math.pow(10, -9)));
						try {
							String[] results = ReadWrite.getFiles(output);
							for (String res : results) {
								if (res.contains("part"))
									new TableDialog(new String[] {"Movie", "Average"}, ReadWrite.readTabular(res));
							}
						} catch (IllegalArgumentException | IOException e1) {
							e1.printStackTrace();
							new TableDialog(new String[] {"ERROR"}, new Object[0][0]);
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

}
