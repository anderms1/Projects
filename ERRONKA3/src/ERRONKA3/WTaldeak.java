package ERRONKA3;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class WTaldeak extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textIzena;
	private JTextField textHerria;
	private JTextField textZuzendaria;
	DefaultTableModel model;
	//private ArrayList<Taldea> taldeaList = new ArrayList<Taldea>();
	private JTable table;

	/**
	 * Create the panel.
	 */
	public WTaldeak() {
		
		setLayout(null);
		setBounds(100, 100, 650, 450);
		
		JLabel lblNewLabel = new JLabel("TALDEAK KUDEATU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 11, 572, 22);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 44, 572, 98);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Taldearen Izena");
		lblNewLabel_2.setBounds(40, 5, 126, 18);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		
		textIzena = new JTextField();
		textIzena.setBounds(40, 22, 126, 29);
		panel.add(textIzena);
		textIzena.setFont(new Font("Arial", Font.PLAIN, 15));
		textIzena.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Herria");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setBounds(220, 7, 98, 14);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		textHerria = new JTextField();
		textHerria.setBounds(220, 22, 126, 29);
		panel.add(textHerria);
		textHerria.setFont(new Font("Arial", Font.PLAIN, 15));
		textHerria.setColumns(10);
		
		textZuzendaria = new JTextField();
		textZuzendaria.setBounds(404, 22, 126, 29);
		panel.add(textZuzendaria);
		textZuzendaria.setFont(new Font("Arial", Font.PLAIN, 15));
		textZuzendaria.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Zuzendaria");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(404, 7, 104, 14);
		panel.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 15));
		
		table = new JTable();
		
		Object[] zutabeIzenak = {"Taldea", "Herria", "Zuzendaria"};
		
		model = new DefaultTableModel(null, zutabeIzenak);
		
		table.setModel(model);
		
		
		table.setDefaultEditor(Object.class, null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		scrollPane.setBounds(26, 153, 572, 219);
		add(scrollPane);
		
		JButton btnGorde = new JButton("Gorde");
		btnGorde.setBounds(168, 62, 98, 29);
		panel.add(btnGorde);
		btnGorde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGorde.setFont(new Font("Arial", Font.BOLD, 13));
		
		JButton btnEzabatu = new JButton("Ezabatu");
		btnEzabatu.setBounds(304, 62, 98, 29);
		panel.add(btnEzabatu);
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnEzabatu.setFont(new Font("Arial", Font.BOLD, 13));
		
	}
	public void refreshTable() {
		
	}
}