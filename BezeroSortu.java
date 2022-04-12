package ERRONKA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;


public class BezeroSortu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField TF_Izena, TF_Abizena, TF_Jaiotzedata, TF_Mugikor, TF_Herrialdea, TF_Mail, TF_Postakode, TF_Dni, TF_Alta;
	private JButton Gordebtn, Itxibtn;
	private JLabel Dnilbl, Izenalbl, Abizenalbl, Jaiotzelbl, Telefonolbl, Correolbl, Postalbl, Autonomolbl, Herrialdelbl, Altalb;
	private JTextField TF_Autonomo;
	
	
	private ArrayList<BezeroClass> BEZS = new ArrayList<BezeroClass>();
	
	private Statement st;
	private ResultSet rs;
	private Connection konexioa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BezeroSortu frame = new BezeroSortu();
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
	public BezeroSortu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Gordebtn = new JButton("Gorde");
		Gordebtn.addActionListener(this);
		Gordebtn.setBounds(510, 396, 85, 21);
		contentPane.add(Gordebtn);

		Itxibtn = new JButton("Itxi");
		Itxibtn.addActionListener(this);
		Itxibtn.setBounds(10, 396, 85, 21);
		contentPane.add(Itxibtn);

		Izenalbl = new JLabel("Izena");
		Izenalbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Izenalbl.setBounds(10, 105, 52, 26);
		contentPane.add(Izenalbl);

		TF_Izena = new JTextField();
		TF_Izena.setBounds(86, 110, 96, 19);
		contentPane.add(TF_Izena);
		TF_Izena.setColumns(10);

		Abizenalbl = new JLabel("Abizena");
		Abizenalbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Abizenalbl.setBounds(10, 174, 52, 26);
		contentPane.add(Abizenalbl);

		Jaiotzelbl = new JLabel("Jaiotze Data");
		Jaiotzelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Jaiotzelbl.setBounds(10, 248, 85, 26);
		contentPane.add(Jaiotzelbl);

		Telefonolbl = new JLabel("Mugikorra");
		Telefonolbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Telefonolbl.setBounds(10, 325, 52, 26);
		contentPane.add(Telefonolbl);

		Correolbl = new JLabel("Mail");
		Correolbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Correolbl.setBounds(353, 37, 52, 26);
		contentPane.add(Correolbl);

		Postalbl = new JLabel("PostaKodea");
		Postalbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Postalbl.setBounds(353, 105, 85, 26);
		contentPane.add(Postalbl);

		Herrialdelbl = new JLabel("Herrialdea");
		Herrialdelbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Herrialdelbl.setBounds(353, 174, 63, 26);
		contentPane.add(Herrialdelbl);

		TF_Abizena = new JTextField();
		TF_Abizena.setColumns(10);
		TF_Abizena.setBounds(86, 179, 96, 19);
		contentPane.add(TF_Abizena);

		TF_Jaiotzedata = new JTextField();
		TF_Jaiotzedata.setColumns(10);
		TF_Jaiotzedata.setBounds(86, 253, 96, 19);
		contentPane.add(TF_Jaiotzedata);

		TF_Mugikor = new JTextField();
		TF_Mugikor.setColumns(10);
		TF_Mugikor.setBounds(86, 330, 96, 19);
		contentPane.add(TF_Mugikor);

		TF_Herrialdea = new JTextField();
		TF_Herrialdea.setColumns(10);
		TF_Herrialdea.setBounds(439, 179, 96, 19);
		contentPane.add(TF_Herrialdea);

		TF_Postakode = new JTextField();
		TF_Postakode.setColumns(10);
		TF_Postakode.setBounds(439, 110, 96, 19);
		contentPane.add(TF_Postakode);

		TF_Mail = new JTextField();
		TF_Mail.setColumns(10);
		TF_Mail.setBounds(439, 42, 96, 19);
		contentPane.add(TF_Mail);

		Autonomolbl = new JLabel("Autonomo");
		Autonomolbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Autonomolbl.setBounds(353, 325, 70, 26);
		contentPane.add(Autonomolbl);

		TF_Autonomo = new JTextField();
		TF_Autonomo.setColumns(10);
		TF_Autonomo.setBounds(439, 330, 96, 19);
		contentPane.add(TF_Autonomo);
		
		Dnilbl = new JLabel("Nan");
		Dnilbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Dnilbl.setBounds(10, 37, 52, 26);
		contentPane.add(Dnilbl);
		
		TF_Dni = new JTextField();
		TF_Dni.setColumns(10);
		TF_Dni.setBounds(86, 42, 96, 19);
		contentPane.add(TF_Dni);
		
		Altalb = new JLabel("Alta");
		Altalb.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Altalb.setBounds(353, 248, 70, 26);
		contentPane.add(Altalb);
		
		TF_Alta = new JTextField();
		TF_Alta.setColumns(10);
		TF_Alta.setBounds(439, 253, 96, 19);
		contentPane.add(TF_Alta);

//		CONECTA A LA BASE DE DATOS	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			konexioa = DriverManager.getConnection("jdbc:mysql://localhost/rekordauto", "root", "");
			// Statement instantzi berri bat ireki
			st = konexioa.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ((java.sql.Statement) st).executeQuery("SELECT * FROM bezeroa");

			System.out.println("Se puede acceder a la base de datos");

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("No se puede acceder a la BD");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == Gordebtn) {

			BezeroClass Bezeroak;

			//Eraikitzaile si contiene todos los campos
			try {
				Bezeroak = new BezeroClass(rs.getObject("Nan").toString(),rs.getObject("Izena").toString(), 
						rs.getObject("Abizena").toString(), rs.getObject("Jaiotze Data").toString(), rs.getObject("Telefonoa").toString(), 
						rs.getObject("Posta").toString(), rs.getObject("Posta Kodea").toString(), rs.getObject("Herrialdea").toString(),
						rs.getObject("AltaData").toString(), rs.getObject("Autonomoa").toString());
			
				//Añadir "Bezero" al ArrayList
				BEZS.add(Bezeroak);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
			try {
				st.executeUpdate("INSERT INTO bezeroa VALUES (Nan = '"+ BEZS.get(0).getNan() +"', Izena ='"+ BEZS.get(0).getIzena() +
						"', Abizena ='"+ BEZS.get(0).getAbizena()+"', Jaiotze Data ='"+ BEZS.get(0).getJaiotzeData()+
						"', Telefonoa  ='"+ BEZS.get(0).getMugikor()+ "', Posta ='"+ BEZS.get(0).getMail()+
						"', Posta Kodea ='"+ BEZS.get(0).getPostaKode()+"', AltaData ='"+ BEZS.get(0).getAlta()+
						"', Autonomoa ='"+ BEZS.get(0).getAutonomo()+  "' WHERE Nan='" + BEZS.get(0).getNan() + "')");
			} catch (SQLException i) {
				i.printStackTrace();
				// System.out.println("Errorea. Ezin izan da erregistroa txertatu");
			}			
			
		}

		if (source == Itxibtn) {
			
			Menua clasec;
			clasec = new Menua();
			clasec.setVisible(true);
			setVisible(false);
		
		}
		
	}
}
