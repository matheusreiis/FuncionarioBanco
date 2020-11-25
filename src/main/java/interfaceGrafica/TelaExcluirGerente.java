package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class TelaExcluirGerente extends JPanel {
	private JTable table;

	public TelaExcluirGerente() {

		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		
		JLabel tituloExcluirGerente = new JLabel("EXCLUIR GERENTE");
		tituloExcluirGerente.setForeground(SystemColor.text);
		tituloExcluirGerente.setHorizontalAlignment(SwingConstants.CENTER);
		tituloExcluirGerente.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloExcluirGerente.setBounds(60, 13, 304, 89);
		add(tituloExcluirGerente);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(429, 0, 21, 300);
		add(scrollBar);
		
		table = new JTable();
		table.setBounds(47, 101, 317, 186);
		add(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Logo_DataCore_Preto.jpg"));
		lblNewLabel.setBounds(-126, -57, 876, 482);
		add(lblNewLabel);
		
		
		
	}
}
