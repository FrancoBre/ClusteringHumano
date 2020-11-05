package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;

import Grafo.JFrameGraphics;
import juego.Persona;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Interfaz {

	private JFrame frame;
	private JTextField txt_nombre;
	
	//Declaro las variables aca para tenerlas para las funciones
	JSpinner itm_musica = new JSpinner();
	JSpinner itm_deporte = new JSpinner();
	JSpinner itm_espectaculo = new JSpinner();
	JSpinner itm_ciencia = new JSpinner();
//	private JTable table;
	DefaultTableModel modelo = new DefaultTableModel();
	JTable table = new JTable(modelo);
	String nombre = "";
	int musica = 0;
	int deporte =0;
	int espectaculo = 0;
	int ciencia = 0;
	
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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		ingresarPersonas.setBounds(0, 0, 392, 304);
		frame.getContentPane().add(ingresarPersonas);
		
		JPanel verLista = new JPanel();
		ingresarPersonas.setBackground(new Color(102, 205, 170));
		verLista.setVisible(false);
		
		
		ingresarPersonas.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Ingresar nombre");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(25, 51, 104, 21);
		ingresarPersonas.add(lblNewLabel_3);
		
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(139, 50, 111, 20);
		ingresarPersonas.add(txt_nombre);
		
		
		itm_musica.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		itm_musica.setBounds(220, 148, 30, 25);
		ingresarPersonas.add(itm_musica);
		
		
		itm_deporte.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		itm_deporte.setBounds(220, 113, 30, 25);
		ingresarPersonas.add(itm_deporte);
		
		
		itm_ciencia.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		itm_ciencia.setBounds(220, 218, 30, 25);
		ingresarPersonas.add(itm_ciencia);
		
		
		itm_espectaculo.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		itm_espectaculo.setBounds(220, 184, 30, 25);
		ingresarPersonas.add(itm_espectaculo);
		
		JLabel label1 = new JLabel("Inter\u00E9s por la m\u00FAsica");
		label1.setBounds(25, 150, 131, 21);
		ingresarPersonas.add(label1);
		
		JLabel label2 = new JLabel("Inter\u00E9s por los deportes");
		label2.setBounds(25, 115, 141, 21);
		ingresarPersonas.add(label2);
		
		JLabel label3 = new JLabel("Inter\u00E9s por la ciencia");
		label3.setBounds(25, 220, 131, 21);
		ingresarPersonas.add(label3);
		
		JLabel label14 = new JLabel("Inter\u00E9s por las noticias del espect\u00E1culo");
		label14.setBounds(25, 186, 202, 21);
		ingresarPersonas.add(label14);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese el interes del 1 al 5 por los siguientes temas:");
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(25, 88, 357, 14);
		ingresarPersonas.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Clustering Humano");
		lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(129, 11, 200, 28);
		ingresarPersonas.add(lblNewLabel_2_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(31, 255, 89, 23);
		ingresarPersonas.add(btnGuardar);
		
		JButton btnVerLista = new JButton("Ver lista");
		btnVerLista.setBounds(151, 255, 89, 23);
		ingresarPersonas.add(btnVerLista);
		
		JButton btn_grafo = new JButton("Grafo");
		btn_grafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame= new JFrame("JavaTutorial.net");    
		        frame.getContentPane().add(new JFrameGraphics());
		        frame.setSize(300, 300);
		        frame.setTitle("Grafo");
		        frame.setVisible(true);
		        frame.setResizable(false); 
			}
		});
		btn_grafo.setBounds(271, 255, 89, 23);
		ingresarPersonas.add(btn_grafo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		panel.setBounds(389, 0, 410, 304);
		frame.getContentPane().add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btn_volver = new JButton("Volver");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Lista");
		lblNewLabel_2_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(182)
							.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(27)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(163, Short.MAX_VALUE)
					.addComponent(btn_volver, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(161))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btn_volver)
					.addGap(30))
		);
		table.setCellSelectionEnabled(true);
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Deporte", "M\u00FAsica", "Espectáculo", "Ciencia"
			}
		));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		ingresarPersonas.setVisible(true);
		 // Action boton VerLista
		btnVerLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarPersonas.setVisible(false);
				panel.setVisible(true);
			}});
		
		 // Action boton Guardar
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//me parece que no hace falta, ya se esta parado en ese tablero
				ingresarPersonas.setVisible(true);
				//Agrego la persona
				if(validar()) {
					agregarPersona();
					agregarDatosLista();
					limpioDatos();
				}
				//panel.setVisible(false);
				
			}});
	
		frame.setBounds(100, 100, 809, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @param spinner
	 */
	public void spinner_Configuracion(JSpinner spinner) {
	}
	
	public void agregarPersona() {
		this.deporte = (int) itm_deporte.getValue();
		this.musica = (int) itm_musica.getValue();
		this.espectaculo = (int) itm_espectaculo.getValue();
		this.ciencia = (int) itm_ciencia.getValue();
		//Agrego la persona con sus datos
		Persona p = new Persona(musica, deporte, espectaculo, ciencia);
		this.nombre = txt_nombre.getText();
		p.setNombre(nombre);
		System.out.println(p);
	}
	
	public void limpioDatos() {
		itm_deporte.setValue(1);
		itm_musica.setValue(1);
		itm_espectaculo.setValue(1);
		itm_ciencia.setValue(1);
		txt_nombre.setText("");
		//Hace focus en el texto para volver a agregar
		txt_nombre.grabFocus();
	}

	public void agregarDatosLista() {
		int numCols = table.getModel().getColumnCount();

		Object [] fila = new Object[numCols]; 
		        
		 fila[0] = this.nombre;
		 fila[1] = this.deporte;
		 fila[2] = this.musica;
		 fila[3] = this.espectaculo;
		 fila[4] = this.ciencia;
		 
		 ((DefaultTableModel) table.getModel()).addRow(fila);
	}
	
	 public void paint(Graphics g){
	        //Valores del grafo
		 	int xValues[] = {25, 145, 25, 145, 25};
	        int yValues[] = {25, 25, 145, 145, 25};
	        int points = 5;        
	        g.drawPolygon(xValues, yValues, points);
	 }
	 
	 //Funcion validar, si hay algun error, devuleve false
	 public boolean validar() {
		 if(txt_nombre.getText().equals("")) {
			 JOptionPane.showMessageDialog(txt_nombre, "No se ingreso nombre");
			 txt_nombre.grabFocus();
			 return false;
		 }
		 return true;
	 }
	/**
	 * @param label1_1
	 */
	public void fuente(JLabel label) {
	}
}