package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;

public class Interfaz {

	private JFrame frame;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//erfe
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.ORANGE);
		frame.getContentPane().setLayout(null);
		
		JPanel ingresarPersonas = new JPanel();
		ingresarPersonas.setBackground(new Color(102, 205, 170));
		ingresarPersonas.setBounds(0, 0, 434, 304);
		frame.getContentPane().add(ingresarPersonas);
		
		JPanel verLista = new JPanel();
		ingresarPersonas.setBackground(new Color(102, 205, 170));
		verLista.setVisible(false);
		
		
		ingresarPersonas.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Ingresar nombre");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(25, 51, 104, 21);
		ingresarPersonas.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 50, 104, 20);
		ingresarPersonas.add(textField_1);
		
		JSpinner spinner1 = new JSpinner();
		spinner1.setBounds(183, 120, 30, 17);
		ingresarPersonas.add(spinner1);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setBounds(183, 155, 30, 17);
		ingresarPersonas.add(spinner_1_2);
		
		JSpinner spinner_1_3 = new JSpinner();
		spinner_1_3.setBounds(183, 190, 30, 17);
		ingresarPersonas.add(spinner_1_3);
		
		JSpinner spinner_1_4 = new JSpinner();
		spinner_1_4.setBounds(183, 225, 30, 17);
		ingresarPersonas.add(spinner_1_4);
		
		JLabel label1_1 = new JLabel("Inter\u00E9s por la m\u00FAsica");
		label1_1.setBounds(25, 119, 131, 21);
		ingresarPersonas.add(label1_1);
		
		JLabel label2_1 = new JLabel("Inter\u00E9s por los deportes");
		label2_1.setBounds(25, 154, 141, 21);
		ingresarPersonas.add(label2_1);
		
		JLabel label3_1 = new JLabel("Inter\u00E9s por la ciencia");
		label3_1.setBounds(25, 189, 131, 21);
		ingresarPersonas.add(label3_1);
		
		JLabel label1_4_1 = new JLabel("Inter\u00E9s por la m\u00FAsica");
		label1_4_1.setBounds(25, 224, 131, 21);
		ingresarPersonas.add(label1_4_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese el interes del 1 al 5 por los siguientes temas:");
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(22, 83, 379, 14);
		ingresarPersonas.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Clustering Humano");
		lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(129, 25, 200, 14);
		ingresarPersonas.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(110, 255, 89, 23);
		ingresarPersonas.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver lista");
		btnNewButton_1.setBounds(257, 255, 89, 23);
		ingresarPersonas.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		panel.setBounds(0, 0, 434, 304);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBackground(new Color(255, 255, 255));
		table.setToolTipText("");
		panel.add(table);
		ingresarPersonas.setVisible(true);
		 // Action boton VerLista
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarPersonas.setVisible(false);
				panel.setVisible(true);
			}});
		
		 // Action boton Guardar
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarPersonas.setVisible(true);
				panel.setVisible(false);
			}});
	
		frame.setBounds(100, 100, 450, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @param spinner
	 */
	public void spinner_Configuracion(JSpinner spinner) {
	}

	/**
	 * @param label1_1
	 */
	public void fuente(JLabel label) {
	}
}