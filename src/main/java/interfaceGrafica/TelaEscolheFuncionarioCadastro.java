package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import interfaceGraficaFrame.TelaCadastroAuxiliarJFrame;
import interfaceGraficaFrame.TelaCadastroEstagiarioJFrame;
import interfaceGraficaFrame.TelaCadastroGerenteJFrame;
import interfaceGraficaFrame.TelaLobbyJFrame;

public class TelaEscolheFuncionarioCadastro extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaEscolheFuncionarioCadastro() throws IOException {
		setLayout(null);
		
		TelaLobbyJFrame lobby = new TelaLobbyJFrame();

		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		
		JLabel tituloEscolherFuncionarioCadastro = new JLabel("CADASTRAR FUNCIONARIO");
		tituloEscolherFuncionarioCadastro.setForeground(SystemColor.text);
		tituloEscolherFuncionarioCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		tituloEscolherFuncionarioCadastro.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloEscolherFuncionarioCadastro.setBounds(52, 13, 351, 89);
		add(tituloEscolherFuncionarioCadastro);
		
		
		JButton botao1Gerente = new JButton("1 - GERENTE");
		botao1Gerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroGerenteJFrame cadastroGerente = null;
				try {
					cadastroGerente = new TelaCadastroGerenteJFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				cadastroGerente.setVisible(true);
			}
		});
		botao1Gerente.setBounds(32, 172, 120, 25);
		add(botao1Gerente);
		
		
		JButton botao2Auxiliar = new JButton("2 - AUXILIAR");
		botao2Auxiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroAuxiliarJFrame cadastroAuxiliar = null;
				try {
					cadastroAuxiliar = new TelaCadastroAuxiliarJFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				cadastroAuxiliar.setVisible(true);
			}
		});
		botao2Auxiliar.setBounds(164, 172, 120, 25);
		add(botao2Auxiliar);
		
		JButton botao3Estagiario = new JButton("3 - ESTAGIARIO");
		botao3Estagiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEstagiarioJFrame cadastroEstagiario = null;
				try {
					cadastroEstagiario = new TelaCadastroEstagiarioJFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				cadastroEstagiario.setVisible(true);
			}
		});
		botao3Estagiario.setBounds(296, 172, 125, 25);
		add(botao3Estagiario);
		
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
