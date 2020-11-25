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

public class TelaExcluirAuxiliar extends JPanel {

	public TelaExcluirAuxiliar() {

		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		
		JLabel tituloExcluirAuxiliar = new JLabel("EXCLUIR AUXILIAR");
		tituloExcluirAuxiliar.setForeground(SystemColor.text);
		tituloExcluirAuxiliar.setHorizontalAlignment(SwingConstants.CENTER);
		tituloExcluirAuxiliar.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloExcluirAuxiliar.setBounds(60, 13, 304, 89);
		add(tituloExcluirAuxiliar);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(429, 0, 21, 300);
		add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Logo_DataCore_Preto.jpg"));
		lblNewLabel.setBounds(-126, -57, 876, 482);
		add(lblNewLabel);
		
	}

}
