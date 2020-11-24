package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class TelaDeLoginAuxiliar extends JPanel {

	private JTextField escreverLogin;
	private JTextField escreverSenha;
	private JLabel imagemFundo;
	
	public TelaDeLoginAuxiliar() {
		setLayout(null);
		
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);

		JLabel tituloLobby = new JLabel("SISTEMA AUXILIAR");
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
		
		JLabel imagemFundo;
		imagemFundo = new JLabel("New label");
		imagemFundo.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Logo_DataCore_Preto.jpg"));
		imagemFundo.setBounds(-126, -57, 876, 482);
		add(imagemFundo);
	}

}
