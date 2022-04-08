package eb2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Menua extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menua frame = new Menua();
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
	public Menua() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JButton btnLaguntza = new JButton("Laguntza");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLaguntza, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLaguntza, 32, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnLaguntza, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnLaguntza, -598, SpringLayout.EAST, contentPane);
		contentPane.add(btnLaguntza);
		
		JLabel lblIzenAbizenak = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblIzenAbizenak, 16, SpringLayout.NORTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblIzenAbizenak, -113, SpringLayout.EAST, contentPane);
		contentPane.add(lblIzenAbizenak);
		
		JButton btnBezero = new JButton("Bezero");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnBezero, 49, SpringLayout.SOUTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnBezero, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnBezero, -483, SpringLayout.EAST, contentPane);
		contentPane.add(btnBezero);
		
		JButton btnAuto = new JButton("Auto");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAuto, 206, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnBezero, -29, SpringLayout.NORTH, btnAuto);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAuto, 41, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAuto, -175, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAuto, 0, SpringLayout.EAST, btnBezero);
		contentPane.add(btnAuto);
		
		JButton btnPiezak = new JButton("Piezak");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnPiezak, 28, SpringLayout.SOUTH, btnAuto);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnPiezak, 0, SpringLayout.WEST, btnBezero);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnPiezak, -78, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnPiezak, -483, SpringLayout.EAST, contentPane);
		contentPane.add(btnPiezak);
		
		JButton btnHornitzaile = new JButton("Hornitzaile");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnHornitzaile, 108, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnHornitzaile, 27, SpringLayout.EAST, btnBezero);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnHornitzaile, 240, SpringLayout.EAST, btnBezero);
		contentPane.add(btnHornitzaile);
		
		JButton btnEskaerak = new JButton("Eskaerak");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnHornitzaile, -30, SpringLayout.NORTH, btnEskaerak);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEskaerak, -176, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEskaerak, 1, SpringLayout.NORTH, btnAuto);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEskaerak, 0, SpringLayout.WEST, btnHornitzaile);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEskaerak, 240, SpringLayout.EAST, btnAuto);
		contentPane.add(btnEskaerak);
		
		JButton btnFakturak = new JButton("Fakturak");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnFakturak, 0, SpringLayout.NORTH, btnPiezak);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnFakturak, 0, SpringLayout.WEST, btnHornitzaile);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnFakturak, 98, SpringLayout.SOUTH, btnEskaerak);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnFakturak, 240, SpringLayout.EAST, btnPiezak);
		contentPane.add(btnFakturak);
		
		JButton btnLog = new JButton("Log");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLog, 0, SpringLayout.NORTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLog, 25, SpringLayout.EAST, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnLog, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnLog, 132, SpringLayout.EAST, btnLaguntza);
		contentPane.add(btnLog);
		
		JButton btnTaulak = new JButton("Taulak");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTaulak, 0, SpringLayout.NORTH, btnLaguntza);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTaulak, 25, SpringLayout.EAST, btnLog);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnTaulak, 59, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTaulak, 132, SpringLayout.EAST, btnLog);
		contentPane.add(btnTaulak);
	}
}
