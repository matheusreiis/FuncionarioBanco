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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class TelaDeLoginEstagiario extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField escreverLogin;
	private JTextField escreverSenha;

	public TelaDeLoginEstagiario() {
		setLayout(null);

		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);

		JLabel tituloLobby = new JLabel("SISTEMA ESTAGIARIO");
		tituloLobby.setForeground(SystemColor.text);
		tituloLobby.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLobby.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloLobby.setBounds(64, 13, 304, 89);
		add(tituloLobby);
		
		JLabel textoLogin = new JLabel("LOGIN:");
		textoLogin.setForeground(Color.WHITE);
		textoLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoLogin.setBounds(64, 151, 67, 16);
		add(textoLogin);
		
		JLabel textoSenha = new JLabel("SENHA:");
		textoSenha.setForeground(Color.WHITE);
		textoSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoSenha.setBounds(64, 201, 67, 16);
		add(textoSenha);
		
		escreverLogin = new JTextField();
		escreverLogin.setBounds(132, 150, 116, 22);
		add(escreverLogin);
		escreverLogin.setColumns(10);
		
		escreverSenha = new JTextField();
		escreverSenha.setColumns(10);
		escreverSenha.setBounds(132, 200, 116, 22);
		add(escreverSenha);
		
		JButton botaoEntrar = new JButton("ENTRAR");
		botaoEntrar.setBackground(Color.WHITE);
		botaoEntrar.setForeground(Color.BLACK);
		botaoEntrar.setBounds(142, 246, 97, 25);
		add(botaoEntrar);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Calibri", Font.PLAIN, 10));
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
		
		JLabel imagemFundo;
		imagemFundo = new JLabel("New label");
		imagemFundo.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Logo_DataCore_Preto.jpg"));
		imagemFundo.setBounds(-126, -57, 876, 482);
		add(imagemFundo);		
	}

}
