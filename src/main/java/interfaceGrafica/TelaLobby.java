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
import javax.swing.border.EtchedBorder;

import interfaceGraficaFrame.TelaDeLoginAuxiliarJFrame;
import interfaceGraficaFrame.TelaDeLoginEstagiarioJFrame;
import interfaceGraficaFrame.TelaDeLoginGerenteJFrame;
import interfaceGraficaFrame.TelaEscolheFuncionarioCadastroJFrame;
import interfaceGraficaFrame.TelaEscolheFuncionarioExclusaoJFrame;

public class TelaLobby extends JPanel {
	

	public TelaLobby() {
		setBackground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setLayout(null);
		
		JLabel tituloLobby = new JLabel("DATACORE SOLUTIONS");
		tituloLobby.setForeground(SystemColor.text);
		tituloLobby.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLobby.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloLobby.setBounds(64, 13, 304, 89);
		add(tituloLobby);
		
		JButton botaoGerenteLobby = new JButton("SISTEMA GERENTE");
		botaoGerenteLobby.setForeground(Color.BLACK);
		botaoGerenteLobby.setBackground(Color.WHITE);
		botaoGerenteLobby.setFont(new Font("Calibri", Font.ITALIC, 15));
		botaoGerenteLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeLoginGerenteJFrame loginGerente = new TelaDeLoginGerenteJFrame();
				loginGerente.setVisible(true);
			}
		});
		botaoGerenteLobby.setBounds(43, 157, 170, 25);
		add(botaoGerenteLobby);
		
		JButton botaoAuxiliarLobby = new JButton("SISTEMA AUXILIAR");
		botaoAuxiliarLobby.setBackground(Color.WHITE);
		botaoAuxiliarLobby.setFont(new Font("Calibri", Font.ITALIC, 15));
		botaoAuxiliarLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeLoginAuxiliarJFrame loginAuxiliar = new TelaDeLoginAuxiliarJFrame();
				loginAuxiliar.setVisible(true);
			}
		});
		botaoAuxiliarLobby.setBounds(43, 203, 170, 25);
		add(botaoAuxiliarLobby);
		
		JButton botaoEstagiarioLobby = new JButton("SISTEMA ESTAGIARIO");
		botaoEstagiarioLobby.setBackground(Color.WHITE);
		botaoEstagiarioLobby.setFont(new Font("Calibri", Font.ITALIC, 15));
		botaoEstagiarioLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeLoginEstagiarioJFrame loginEstagiario = new TelaDeLoginEstagiarioJFrame();
				loginEstagiario.setVisible(true);
			}
		});
		botaoEstagiarioLobby.setBounds(43, 248, 170, 25);
		add(botaoEstagiarioLobby);
		
		JButton botaoCadastroLobby = new JButton("CADASTRAR FUNCIONARIO");
		botaoCadastroLobby.setBackground(Color.WHITE);
		botaoCadastroLobby.setFont(new Font("Calibri", Font.ITALIC, 12));
		botaoCadastroLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscolheFuncionarioCadastroJFrame escolheFuncionarioCadastro = new TelaEscolheFuncionarioCadastroJFrame();
				escolheFuncionarioCadastro.setVisible(true);
			}
		});
		botaoCadastroLobby.setBounds(225, 157, 170, 25);
		add(botaoCadastroLobby);
		
		JButton botaoExclusaoLobby = new JButton("EXCLUIR FUNCIONARIO");
		botaoExclusaoLobby.setBackground(Color.WHITE);
		botaoExclusaoLobby.setFont(new Font("Calibri", Font.ITALIC, 14));
		botaoExclusaoLobby.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscolheFuncionarioExclusaoJFrame escolheFuncionarioExclusao = new TelaEscolheFuncionarioExclusaoJFrame();
				escolheFuncionarioExclusao.setVisible(true);
			}
		});
		botaoExclusaoLobby.setBounds(225, 203, 170, 25);
		add(botaoExclusaoLobby);
		
		JButton btnEncerrarSistema = new JButton("ENCERRAR SISTEMA");
		btnEncerrarSistema.setBackground(Color.WHITE);
		btnEncerrarSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEncerrarSistema.setFont(new Font("Calibri", Font.ITALIC, 15));
		btnEncerrarSistema.setBounds(225, 248, 170, 25);
		add(btnEncerrarSistema);
		
		JLabel imagemFundo = new JLabel("New label");
		imagemFundo.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Logo_DataCore_Preto.jpg"));
		imagemFundo.setBounds(-126, -57, 876, 482);
		add(imagemFundo);
	}
}
