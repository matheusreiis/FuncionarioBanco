package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class TelaEscolheFuncionarioExclusao extends JPanel {

	public TelaEscolheFuncionarioExclusao() {

		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		
		JLabel tituloEscolherFuncionarioExcluir = new JLabel("EXCLUIR FUNCIONARIO");
		tituloEscolherFuncionarioExcluir.setForeground(SystemColor.text);
		tituloEscolherFuncionarioExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		tituloEscolherFuncionarioExcluir.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloEscolherFuncionarioExcluir.setBounds(52, 13, 351, 89);
		add(tituloEscolherFuncionarioExcluir);
		
		JButton btnNewButton = new JButton("1 - GERENTE");
		btnNewButton.setBounds(32, 172, 120, 25);
		add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("2 - AUXILIAR");
		btnNewButton_1.setBounds(164, 172, 120, 25);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3 - ESTAGIARIO");
		btnNewButton_2.setBounds(296, 172, 125, 25);
		add(btnNewButton_2);
		
		JLabel imagemFundo = new JLabel("New label");
		imagemFundo.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Logo_DataCore_Preto.jpg"));
		imagemFundo.setBounds(-126, -57, 876, 482);
		add(imagemFundo);
	}

}
