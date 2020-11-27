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
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import interfaceGraficaFrame.TelaEscolheFuncionarioExclusaoJFrame;

public class TelaExcluirEstagiario extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaExcluirEstagiario() throws Exception {
		
		TelaEscolheFuncionarioExclusaoJFrame escolheFuncionarioExclusao = new TelaEscolheFuncionarioExclusaoJFrame();

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
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Calibri", Font.PLAIN, 10));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escolheFuncionarioExclusao.setVisible(true);
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
