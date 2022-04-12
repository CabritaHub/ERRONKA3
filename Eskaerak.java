package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class Eskaerak extends JFrame implements ActionListener {
	private Statement st, st2;
	private ResultSet rs, rs2;
	private Connection konexioa;
	private Vector<String> Titulo;
	private Vector<Vector<String>> Datuak;
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dlmTabla = new DefaultTableModel();
	private JTable TablaV2 = new JTable(dlmTabla);
	private JScrollPane scrollPane;
	private int filas;
	private JPanel contentPane;
	private JButton Borrarbtn, Actualizarbtn, Insertarbtn, Atzerabtn;
	private JTextPane TxtEskaera;
	private JComboBox<String> MatrikulaCombo;
	private JLabel Eskaeralbl, Langilelbl, Orduaklbl, Piezakllbl, Idlbl;
	private JTextField TF_Orduak, TF_Langilea, TF_Piezak, TF_Id;
	private JSpinner PiezaSpinner;
	
	private ArrayList<EskaeraClass> ESK = new ArrayList<EskaeraClass>();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eskaerak frame = new Eskaerak();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Eskaerak() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1098, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		TxtEskaera = new JTextPane();
		TxtEskaera.setBounds(418, 27, 581, 124);
		contentPane.add(TxtEskaera);

		MatrikulaCombo = new JComboBox<String>();
		MatrikulaCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ST1();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		MatrikulaCombo.setBounds(257, 85, 151, 21);
		contentPane.add(MatrikulaCombo);

		Eskaeralbl = new JLabel("ESKAERA: ");
		Eskaeralbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Eskaeralbl.setBounds(293, 27, 83, 35);
		contentPane.add(Eskaeralbl);

		Borrarbtn = new JButton("Borrar");
		Borrarbtn.addActionListener(this);
		Borrarbtn.setBounds(418, 171, 104, 21);
		contentPane.add(Borrarbtn);

		Actualizarbtn = new JButton("Actualizar");
		Actualizarbtn.addActionListener(this);
		Actualizarbtn.setBounds(573, 171, 104, 21);
		contentPane.add(Actualizarbtn);
		
		Insertarbtn = new JButton("Insertar");
		Insertarbtn.addActionListener(this);
		Insertarbtn.setBounds(719, 171, 104, 21);
		contentPane.add(Insertarbtn);
		
		Atzerabtn = new JButton("Atzera");
		Atzerabtn.addActionListener(this);
		Atzerabtn.setBounds(860, 171, 104, 21);
		contentPane.add(Atzerabtn);

		Langilelbl = new JLabel("Langilea");
		Langilelbl.setBounds(10, 84, 83, 22);
		contentPane.add(Langilelbl);

		TF_Langilea = new JTextField();
		TF_Langilea.setBounds(103, 86, 96, 19);
		contentPane.add(TF_Langilea);
		TF_Langilea.setColumns(10);

		Orduaklbl = new JLabel("Orduak");
		Orduaklbl.setBounds(10, 131, 45, 21);
		contentPane.add(Orduaklbl);

		TF_Orduak = new JTextField();
		TF_Orduak.setBounds(103, 132, 96, 19);
		contentPane.add(TF_Orduak);
		TF_Orduak.setColumns(10);

		Piezakllbl = new JLabel("Piezak");
		Piezakllbl.setBounds(10, 171, 45, 21);
		contentPane.add(Piezakllbl);

		TF_Piezak = new JTextField();
		TF_Piezak.setBounds(103, 172, 96, 19);
		contentPane.add(TF_Piezak);
		TF_Piezak.setColumns(10);

//		CONECTA A LA BASE DE DATOS	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			konexioa = DriverManager.getConnection("jdbc:mysql://localhost/rekordauto", "root", "");
			// Statement instantzi berri bat ireki
			st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM lana");
			st2 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ST2();
			
			
			System.out.println("Se puede acceder a la base de datos");

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("No se puede acceder a la BD");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			crearTabla();
		} catch (SQLException e) {
			// e.printStackTrace();
//				javax.swing.JOptionPane.showMessageDialog(null, "No se puede Conectar", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void crearTabla() throws SQLException {
		Titulo = new Vector<String>();

		Titulo.add("Lana ID");
		Titulo.add("Langilea");
		Titulo.add("Matrikula");
		Titulo.add("Deskribapena");
		Titulo.add("Piezak");
		Titulo.add("Kant");
		Titulo.add("Prezioa");
		Titulo.add("Orduak");

		dlmTabla = new DefaultTableModel(Datuak, Titulo);
		TablaV2 = new JTable(dlmTabla);

		TablaV2.setEnabled(false);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 260, 972, 170);
		scrollPane.setViewportView(TablaV2);
		contentPane.add(scrollPane);
		
		Idlbl = new JLabel("Lana ID");
		Idlbl.setBounds(10, 40, 83, 22);
		contentPane.add(Idlbl);
		
		TF_Id = new JTextField();
		TF_Id.setColumns(10);
		TF_Id.setBounds(101, 43, 96, 19);
		contentPane.add(TF_Id);
		
		PiezaSpinner = new JSpinner();
		PiezaSpinner.setBounds(209, 172, 36, 20);
		contentPane.add(PiezaSpinner);
		
		ST1();
	}

	public void ST1() throws SQLException {
		
		rs2.absolute(MatrikulaCombo.getSelectedIndex()+1);
		String Matrikulak = (String) rs2.getObject("Matrikula");

		rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM lana l, autoa a WHERE a.Matrikula = '"+Matrikulak+"' ");

		rs.first();

		

		for (int i = 0; filas > i; i++) {
			
			dlmTabla.removeRow(0);
		}

		rs.absolute(0);

		while (rs.next()) {
			Vector<String> lerroa = new Vector<String>();

			lerroa.add((String) rs.getObject("Lana_id"));
			lerroa.add((String) rs.getObject("Langilea"));
			lerroa.add((String) rs.getObject("Matrikula"));
			lerroa.add((String) rs.getObject("Deskribapena"));
			lerroa.add((String) rs.getObject("Piezak"));
			lerroa.add("" + rs.getObject("Kantitatea"));
			lerroa.add("" + rs.getObject("Prezioa"));
			lerroa.add("" + rs.getObject("Orduak"));

			// lerroa.add("\n\n\n\n\n\n\n");
			dlmTabla.addRow(lerroa);
		}

		filas = TablaV2.getRowCount();

	}

	public void ST2() throws SQLException {
		st2 = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs2 = (ResultSet) st2.executeQuery("SELECT Matrikula FROM autoa");

		while (rs2.next()) {
			MatrikulaCombo.addItem("" + rs2.getObject("Matrikula"));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		EskaeraClass Eskaera;
		// Eraikitzaile si contiene todos los campos
		Eskaera = new EskaeraClass(TF_Langilea.getText(), MatrikulaCombo.getSelectedItem().toString(),TxtEskaera.getText(), TF_Orduak.getText(), TF_Piezak.getText());

		// Añadir "Bezero" al ArrayList
		ESK.add(Eskaera);
		
		if (source == Atzerabtn) {

			Menua MenuaP;
			MenuaP = new Menua();
			MenuaP.setVisible(true);
			setVisible(false);
			
			}
			
		if (source == Actualizarbtn) {
	
			}
		
		if (source == Insertarbtn) {

			
			}
		
		if (source == Borrarbtn) {
			try {
				st.executeUpdate("DELETE FROM lana WHERE Lana_id='" + TF_Id.getText() + "'");
				ST1();
			} catch (SQLException i) {
				i.printStackTrace();
			}
			
			}
		
	}
}
