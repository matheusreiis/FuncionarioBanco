package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import interfaceGraficaFrame.TelaLobbyJFrame;

public class TelaEscolheIdAuxiliar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	TelaLobbyJFrame lobby = new TelaLobbyJFrame();

	public TelaEscolheIdAuxiliar() throws Exception {
		setLayout(null);
		
		JLabel tituloAuxiliar = new JLabel("SISTEMA AUXILIAR");
		tituloAuxiliar.setForeground(SystemColor.text);
		tituloAuxiliar.setHorizontalAlignment(SwingConstants.CENTER);
		tituloAuxiliar.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloAuxiliar.setBounds(64, 13, 304, 89);
		add(tituloAuxiliar);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Calibri", Font.PLAIN, 10));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lobby.setVisible(true);
			}
		});
		botaoVoltar.setBounds(12, 13, 58, 19);
		add(botaoVoltar);
		
		JButton btnEncerrarSistema = new JButton("ENCERRAR SISTEMA");
		btnEncerrarSistema.setBackground(Color.WHITE);
		btnEncerrarSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEncerrarSistema.setFont(new Font("Calibri", Font.ITALIC, 10));
		btnEncerrarSistema.setBounds(322, 13, 116, 16);
		add(btnEncerrarSistema);
		
		JLabel imagemFundo = new JLabel("New label");
		imagemFundo.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Matheus\\Logo_DataCore_Preto.jpg"));
		imagemFundo.setBounds(-126, -57, 876, 482);
		add(imagemFundo);

	}

}
