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

public class TelaExcluirAuxiliar extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaExcluirAuxiliar() throws Exception {
		
		TelaEscolheFuncionarioExclusaoJFrame escolheFuncionarioExclusao = new TelaEscolheFuncionarioExclusaoJFrame();

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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Logo_DataCore_Preto.jpg"));
		lblNewLabel.setBounds(-126, -57, 876, 482);
		add(lblNewLabel);
		
	}

}
