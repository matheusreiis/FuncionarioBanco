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

import interfaceGraficaFrame.TelaExcluirAuxiliarJFrame;
import interfaceGraficaFrame.TelaExcluirEstagiarioJFrame;
import interfaceGraficaFrame.TelaExcluirGerenteJFrame;
import interfaceGraficaFrame.TelaLobbyJFrame;

public class TelaEscolheFuncionarioExclusao extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaEscolheFuncionarioExclusao() throws IOException {
		
		TelaLobbyJFrame lobby = new TelaLobbyJFrame();

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
		
		JButton botao1Gerente = new JButton("1 - GERENTE");
		botao1Gerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExcluirGerenteJFrame excluirGerente = null;
				try {
					excluirGerente = new TelaExcluirGerenteJFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				excluirGerente.setVisible(true);
			}
		});
		botao1Gerente.setBounds(32, 172, 120, 25);
		add(botao1Gerente);
		
		
		JButton botao2Auxiliar = new JButton("2 - AUXILIAR");
		botao2Auxiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExcluirAuxiliarJFrame excluirAuxiliar = null;
				try {
					excluirAuxiliar = new TelaExcluirAuxiliarJFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				excluirAuxiliar.setVisible(true);
			}
		});
		botao2Auxiliar.setBounds(164, 172, 120, 25);
		add(botao2Auxiliar);
		
		JButton botao3Estagiario = new JButton("3 - ESTAGIARIO");
		botao3Estagiario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaExcluirEstagiarioJFrame excluirEstagiario = null;
				try {
					excluirEstagiario = new TelaExcluirEstagiarioJFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				excluirEstagiario.setVisible(true);
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
