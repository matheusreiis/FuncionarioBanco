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

import interfaceGraficaFrame.TelaEscolheFuncionarioCadastroJFrame;

public class TelaCadastroAuxiliar extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldSalario;
	private JTextField textFielIdade;
	private JTextField textFieldEstadoCivil;
	private JTextField textFieldLoginGerente;
	private JTextField textFieldSenhaGerente;
	private JTextField textFieldSobrenome;

	TelaEscolheFuncionarioCadastroJFrame escolheFuncionarioCadastro = new TelaEscolheFuncionarioCadastroJFrame();

	public TelaCadastroAuxiliar() throws Exception {

		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);

		JLabel tituloCadastroAuxiliar = new JLabel("CADASTRO AUXILIAR");
		tituloCadastroAuxiliar.setForeground(SystemColor.text);
		tituloCadastroAuxiliar.setHorizontalAlignment(SwingConstants.CENTER);
		tituloCadastroAuxiliar.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloCadastroAuxiliar.setBounds(60, 13, 304, 89);
		add(tituloCadastroAuxiliar);

		JLabel nomeTexto = new JLabel("NOME:");
		nomeTexto.setForeground(Color.WHITE);
		nomeTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		nomeTexto.setBounds(12, 89, 56, 16);
		add(nomeTexto);

		JLabel sobrenomeTexto = new JLabel("SOBRENOME:");
		sobrenomeTexto.setForeground(Color.WHITE);
		sobrenomeTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		sobrenomeTexto.setBounds(206, 89, 83, 16);
		add(sobrenomeTexto);

		JLabel cpfTexto = new JLabel("CPF:");
		cpfTexto.setForeground(Color.WHITE);
		cpfTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		cpfTexto.setBounds(12, 118, 56, 16);
		add(cpfTexto);

		JLabel salarioTexto = new JLabel("SALARIO:");
		salarioTexto.setForeground(Color.WHITE);
		salarioTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		salarioTexto.setBounds(12, 147, 68, 16);
		add(salarioTexto);

		JLabel idadeTexto = new JLabel("IDADE:");
		idadeTexto.setForeground(Color.WHITE);
		idadeTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		idadeTexto.setBounds(12, 176, 56, 16);
		add(idadeTexto);

		JLabel estadoCivilTexto = new JLabel("ESTADO CIVIL:");
		estadoCivilTexto.setForeground(Color.WHITE);
		estadoCivilTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		estadoCivilTexto.setBounds(12, 205, 95, 16);
		add(estadoCivilTexto);

		JLabel loginCadastroTexto = new JLabel("LOGIN DO AUXILIAR:");
		loginCadastroTexto.setForeground(Color.WHITE);
		loginCadastroTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginCadastroTexto.setBounds(12, 234, 133, 16);
		add(loginCadastroTexto);

		JLabel senhaCadastroTexto = new JLabel("SENHA DO AUXILIAR:");
		senhaCadastroTexto.setForeground(Color.WHITE);
		senhaCadastroTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		senhaCadastroTexto.setBounds(12, 263, 160, 16);
		add(senhaCadastroTexto);

		textFieldNome = new JTextField();
		textFieldNome.setBackground(Color.WHITE);
		textFieldNome.setForeground(Color.BLACK);
		textFieldNome.setBounds(56, 86, 116, 22);
		add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldCPF = new JTextField();
		textFieldCPF.setBackground(Color.WHITE);
		textFieldCPF.setBounds(44, 115, 116, 22);
		add(textFieldCPF);
		textFieldCPF.setColumns(10);

		textFieldSalario = new JTextField();
		textFieldSalario.setBackground(Color.WHITE);
		textFieldSalario.setForeground(Color.BLACK);
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(80, 144, 116, 22);
		add(textFieldSalario);

		textFielIdade = new JTextField();
		textFielIdade.setBackground(Color.WHITE);
		textFielIdade.setForeground(Color.BLACK);
		textFielIdade.setColumns(10);
		textFielIdade.setBounds(68, 176, 116, 22);
		add(textFielIdade);

		textFieldEstadoCivil = new JTextField();
		textFieldEstadoCivil.setBackground(Color.WHITE);
		textFieldEstadoCivil.setForeground(Color.BLACK);
		textFieldEstadoCivil.setColumns(10);
		textFieldEstadoCivil.setBounds(109, 202, 116, 22);
		add(textFieldEstadoCivil);

		textFieldLoginGerente = new JTextField();
		textFieldLoginGerente.setBackground(Color.WHITE);
		textFieldLoginGerente.setForeground(Color.BLACK);
		textFieldLoginGerente.setColumns(10);
		textFieldLoginGerente.setBounds(154, 231, 116, 22);
		add(textFieldLoginGerente);

		textFieldSenhaGerente = new JTextField();
		textFieldSenhaGerente.setBackground(Color.WHITE);
		textFieldSenhaGerente.setForeground(Color.BLACK);
		textFieldSenhaGerente.setColumns(10);
		textFieldSenhaGerente.setBounds(154, 260, 116, 22);
		add(textFieldSenhaGerente);

		textFieldSobrenome = new JTextField();
		textFieldSobrenome.setBackground(Color.WHITE);
		textFieldSobrenome.setForeground(Color.BLACK);
		textFieldSobrenome.setColumns(10);
		textFieldSobrenome.setBounds(289, 86, 116, 22);
		add(textFieldSobrenome);

		JButton btnConfirmaCadastrarAuxiliar = new JButton("Cadastrar Auxiliar");
		btnConfirmaCadastrarAuxiliar.setBackground(new Color(255, 255, 255));
		btnConfirmaCadastrarAuxiliar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConfirmaCadastrarAuxiliar.setBounds(258, 132, 168, 25);
		add(btnConfirmaCadastrarAuxiliar);

		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Calibri", Font.PLAIN, 10));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				escolheFuncionarioCadastro.setVisible(true);
			}
		});
		botaoVoltar.setBounds(10, 13, 58, 19);
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
