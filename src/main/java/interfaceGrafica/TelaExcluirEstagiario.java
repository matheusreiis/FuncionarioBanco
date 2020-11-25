package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class TelaExcluirEstagiario extends JPanel {

	public TelaExcluirEstagiario() {

		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		
		JLabel tituloExcluirEstagiario = new JLabel("EXCLUIR ESTAGIARIO");
		tituloExcluirEstagiario.setForeground(SystemColor.text);
		tituloExcluirEstagiario.setHorizontalAlignment(SwingConstants.CENTER);
		tituloExcluirEstagiario.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloExcluirEstagiario.setBounds(60, 13, 304, 89);
		add(tituloExcluirEstagiario);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(429, 0, 21, 300);
		add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Logo_DataCore_Preto.jpg"));
		lblNewLabel.setBounds(-126, -57, 876, 482);
		add(lblNewLabel);
	}

}
