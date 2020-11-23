package interfaceGrafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

public class TelaLobby extends JPanel {

	public TelaLobby() {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setLayout(null);
		
		JLabel tituloLobby = new JLabel("DATACORE SOLUTIONS");
		tituloLobby.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLobby.setFont(new Font("Calibri", Font.ITALIC, 23));
		tituloLobby.setBounds(85, 13, 255, 61);
		add(tituloLobby);
		
		JButton botaoGerenteLobby = new JButton("SISTEMA GERENTE");
		botaoGerenteLobby.setFont(new Font("Calibri", Font.ITALIC, 15));
		botaoGerenteLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoGerenteLobby.setBounds(37, 157, 170, 25);
		add(botaoGerenteLobby);
		
		JButton botaoAuxiliarLobby = new JButton("SISTEMA AUXILIAR");
		botaoAuxiliarLobby.setFont(new Font("Calibri", Font.ITALIC, 15));
		botaoAuxiliarLobby.setBounds(37, 203, 170, 25);
		add(botaoAuxiliarLobby);
		
		JButton botaoEstagiarioLobby = new JButton("SISTEMA ESTAGIARIO");
		botaoEstagiarioLobby.setFont(new Font("Calibri", Font.ITALIC, 15));
		botaoEstagiarioLobby.setBounds(37, 248, 170, 25);
		add(botaoEstagiarioLobby);
		
		JButton botaoCadastroLobby = new JButton("CADASTRAR FUNCIONARIO");
		botaoCadastroLobby.setFont(new Font("Calibri", Font.ITALIC, 12));
		botaoCadastroLobby.setBounds(219, 157, 170, 25);
		add(botaoCadastroLobby);
		
		JButton botaoExclusaoLobby = new JButton("EXCLUIR FUNCIONARIO");
		botaoExclusaoLobby.setFont(new Font("Calibri", Font.ITALIC, 14));
		botaoExclusaoLobby.setBounds(219, 203, 170, 25);
		add(botaoExclusaoLobby);
		
		JButton btnEncerrarSistema = new JButton("ENCERRAR SISTEMA");
		btnEncerrarSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEncerrarSistema.setFont(new Font("Calibri", Font.ITALIC, 15));
		btnEncerrarSistema.setBounds(219, 248, 170, 25);
		add(btnEncerrarSistema);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Imagem_DataCore.png"));
		lblNewLabel.setBounds(95, 13, 244, 252);
		add(lblNewLabel);
		
	}
}
