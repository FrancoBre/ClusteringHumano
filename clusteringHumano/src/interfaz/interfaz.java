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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.table.DefaultTableModel;

import grafo.JFrameGraphics;
import logica.Cluster;
import logica.Grafo;
import logica.Persona;
import logica.Vertice;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorListener;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;

public class interfaz {
	private JFrame frame;
	private JTextField txt_nombre;
	Aplicacion juego = new Aplicacion();
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
	private JTable lista1;
	private JTable lista2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaz window = new interfaz();
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
	public interfaz() {
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
		ingresarPersonas.setBounds(0, 0, 390, 300);
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
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(144, 238, 144));
		panel.setBounds(0, 0, 390, 300);
		frame.getContentPane().add(panel);
		panel.setVisible(false);
		
		JPanel listas = new JPanel();
		listas.setBackground(new Color(70, 130, 180));
		listas.setBounds(0, 0, 390, 300);
		frame.getContentPane().add(listas);
		listas.setLayout(null);
		listas.setVisible(false);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Grafo");
		lblNewLabel_2_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		lblNewLabel_2_1_1_1.setBounds(174, 11, 48, 28);
		listas.add(lblNewLabel_2_1_1_1);
		
		JScrollPane scrollPane_lista1 = new JScrollPane();
		scrollPane_lista1.setBounds(18, 40, 350, 100);
		listas.add(scrollPane_lista1);
		
		lista1 = new JTable();
		scrollPane_lista1.setViewportView(lista1);
		
		JScrollPane scrollPane_lista2 = new JScrollPane();
		scrollPane_lista2.setBounds(18, 150, 350, 100);
		listas.add(scrollPane_lista2);
		
		lista2 = new JTable();
		scrollPane_lista2.setViewportView(lista2);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btn_volver = new JButton("Volver");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				ingresarPersonas.setVisible(true);
			}
		});
		
		JPanel acerca = new JPanel();
		acerca.setLayout(null);
		acerca.setBackground(new Color(51, 204, 204));
		acerca.setBounds(0, 0, 390, 300);
		frame.getContentPane().add(acerca);
		acerca.setVisible(false);
		
		JButton btnNewButton = new JButton("volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarPersonas.setVisible(true);
				panel.setVisible(false);
				acerca.setVisible(false);
				listas.setVisible(false);
				((DefaultTableModel)lista1.getModel()).setNumRows(0);
				((DefaultTableModel)lista2.getModel()).setNumRows(0);
			}

		});
		btnNewButton.setBounds(149, 261, 89, 23);
		listas.add(btnNewButton);
		
		
		JButton btn_info = new JButton("");
		btn_info.setBackground(new Color(64, 224, 208));
//		Image img_info = new ImageIcon(this.getClass().getResource("/informacion.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
//		btn_info.setIcon(new ImageIcon(img_info));
		btn_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarPersonas.setVisible(false);
				panel.setVisible(false);
				acerca.setVisible(true);
			}
		});
		btn_info.setBounds(352, 0, 30, 23);
		ingresarPersonas.add(btn_info);
		//saca el focus del boton de info
		btn_info.setFocusable(false);
		
		JButton btn_grafo = new JButton("Grafo");
		btn_grafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarPersonas.setVisible(false);
				panel.setVisible(false);
				acerca.setVisible(false);
				listas.setVisible(true);
				this.cargarListas();
			}

			private void cargarListas() {
				Grafo g = juego.getGrafo();
				Cluster cluster = new Cluster(g); 
					
				ArrayList<Vertice> c1 = cluster.getGrupo1();
				ArrayList<Vertice> c2 = cluster.getGrupo2();
				for (int i=0;i<c1.size();i++) {
					Persona p = c1.get(i).getPersona();
					int numCols = lista1.getModel().getColumnCount();
					Object [] fila = new Object[numCols]; 
					 fila[0] = p.getNombre();
					 fila[1] = p.getD();
					 fila[2] = p.getM();
					 fila[3] = p.getE();
					 fila[4] = p.getC();
					 
					 ((DefaultTableModel) lista1.getModel()).addRow(fila);
					
				}
				for (int i=0;i<c2.size();i++) {
					Persona p = c2.get(i).getPersona();
					int numCols = lista2.getModel().getColumnCount();
					Object [] fila = new Object[numCols]; 
					fila[0] = p.getNombre();
					fila[1] = p.getD();
					fila[2] = p.getM();
					fila[3] = p.getE();
					fila[4] = p.getC();
					
					((DefaultTableModel) lista2.getModel()).addRow(fila);
				}
				
			}
		});
		btn_grafo.setBounds(271, 255, 89, 23);
		ingresarPersonas.add(btn_grafo);
		
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Lista");
		lblNewLabel_2_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(182)
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(143, Short.MAX_VALUE)
					.addComponent(btn_volver, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(161))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btn_volver)
					.addGap(30))
		);
		table.setCellSelectionEnabled(true);
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Deporte", "Música", "Espectáculo", "Ciencia"
			}
		));
		
		lista1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nombre", "Deporte", "Música", "Espectáculo", "Ciencia"
				}
				));
		lista2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Nombre", "Deporte", "Música", "Espectáculo", "Ciencia"
				}
				));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		
		JLabel lblNewLabel_2 = new JLabel("Sobre nosotros");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(124, 41, 176, 42);
		acerca.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("C- -: ");
		lblNewLabel_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel_3_1.setBounds(30, 70, 59, 66);
		acerca.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("Nicol\u00E1s Wendler");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(30, 219, 154, 28);
		acerca.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Franco Br\u00E9goli");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(30, 141, 153, 28);
		acerca.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sabrina Ar\u00E9valo");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(30, 180, 148, 28);
		acerca.add(lblNewLabel_6);
		
		JButton btn_volver_1 = new JButton("Volver");
		btn_volver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(false);
				acerca.setVisible(false);
				ingresarPersonas.setVisible(true);
			}
		});
		btn_volver_1.setForeground(Color.BLACK);
		btn_volver_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_volver_1.setBounds(153, 252, 89, 23);
		acerca.add(btn_volver_1);
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
				//Agrego la persona si hay un nombre para ingresar
				if(validar()) {
					agregarPersona();
					agregarDatosLista();
					limpioDatos();
				}
				
			}});
		
		
		frame.setBounds(100, 100, 400, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @param spinner
	 */
	public void spinner_Configuracion(JSpinner spinner) {
	}
	
	public void agregarPersona() {
		//guardo los datos en variables locales
		this.deporte = (int) itm_deporte.getValue();
		this.musica = (int) itm_musica.getValue();
		this.espectaculo = (int) itm_espectaculo.getValue();
		this.ciencia = (int) itm_ciencia.getValue();
		this.nombre = (String) txt_nombre.getText();
		
		//Agrego la persona con sus datos
		Persona p = new Persona(musica, deporte, espectaculo, ciencia, nombre);
		//creo la persona
		juego.crearPersona(p);
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
	
	 //Funcion validar, si hay algun error, devuelve false
	 public boolean validar() {
		 if(txt_nombre.getText().equals("")) {
			 JOptionPane.showMessageDialog(txt_nombre, "No se ingreso nombre");
			 txt_nombre.grabFocus();
			 return false;
		 }
		 return true;
	 }
	 
}