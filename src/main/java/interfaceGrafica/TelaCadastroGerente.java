package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class TelaCadastroGerente extends JPanel {
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldSalario;
	private JTextField textFielIdade;
	private JTextField textFieldEstadoCivil;
	private JTextField textFieldLoginGerente;
	private JTextField textFieldSenhaGerente;
	private JTextField textFieldSobrenome;
	
	
	public TelaCadastroGerente() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		
		JLabel tituloCadastroGerente = new JLabel("CADASTRO GERENTE");
		tituloCadastroGerente.setForeground(SystemColor.text);
		tituloCadastroGerente.setHorizontalAlignment(SwingConstants.CENTER);
		tituloCadastroGerente.setFont(new Font("Calibri", Font.BOLD, 30));
		tituloCadastroGerente.setBounds(60, 13, 304, 89);
		add(tituloCadastroGerente);
		
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
		salarioTexto.setBounds(12, 147, 72, 16);
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
		
		JLabel loginCadastroTexto = new JLabel("LOGIN DO GERENTE:");
		loginCadastroTexto.setForeground(Color.WHITE);
		loginCadastroTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginCadastroTexto.setBounds(12, 234, 122, 16);
		add(loginCadastroTexto);
		
		JLabel senhaCadastroTexto = new JLabel("SENHA DO GERENTE:");
		senhaCadastroTexto.setForeground(Color.WHITE);
		senhaCadastroTexto.setFont(new Font("Tahoma", Font.BOLD, 13));
		senhaCadastroTexto.setBounds(12, 263, 134, 16);
		add(senhaCadastroTexto);
		
		textFieldNome = new JTextField();
		textFieldNome.setBackground(Color.WHITE);
		textFieldNome.setForeground(Color.BLACK);
		textFieldNome.setBounds(56, 86, 116, 22);
		add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setForeground(Color.BLACK);
		textFieldCPF.setBackground(Color.WHITE);
		textFieldCPF.setBounds(44, 115, 116, 22);
		add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setBackground(Color.WHITE);
		textFieldSalario.setForeground(Color.BLACK);
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(83, 144, 116, 22);
		add(textFieldSalario);
		
		textFielIdade = new JTextField();
		textFielIdade.setBackground(Color.WHITE);
		textFielIdade.setForeground(Color.BLACK);
		textFielIdade.setColumns(10);
		textFielIdade.setBounds(63, 172, 116, 22);
		add(textFielIdade);
		
		textFieldEstadoCivil = new JTextField();
		textFieldEstadoCivil.setBackground(Color.WHITE);
		textFieldEstadoCivil.setForeground(Color.BLACK);
		textFieldEstadoCivil.setColumns(10);
		textFieldEstadoCivil.setBounds(112, 202, 116, 22);
		add(textFieldEstadoCivil);
		
		textFieldLoginGerente = new JTextField();
		textFieldLoginGerente.setBackground(Color.WHITE);
		textFieldLoginGerente.setForeground(Color.BLACK);
		textFieldLoginGerente.setColumns(10);
		textFieldLoginGerente.setBounds(134, 231, 116, 22);
		add(textFieldLoginGerente);
		
		textFieldSenhaGerente = new JTextField();
		textFieldSenhaGerente.setBackground(Color.WHITE);
		textFieldSenhaGerente.setForeground(Color.BLACK);
		textFieldSenhaGerente.setColumns(10);
		textFieldSenhaGerente.setBounds(144, 260, 116, 22);
		add(textFieldSenhaGerente);
		
		textFieldSobrenome = new JTextField();
		textFieldSobrenome.setBackground(Color.WHITE);
		textFieldSobrenome.setForeground(Color.BLACK);
		textFieldSobrenome.setColumns(10);
		textFieldSobrenome.setBounds(289, 86, 116, 22);
		add(textFieldSobrenome);
		
		JButton btnConfirmaCadastrarGerente = new JButton("Cadastrar Gerente");
		btnConfirmaCadastrarGerente.setBackground(Color.WHITE);
		btnConfirmaCadastrarGerente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConfirmaCadastrarGerente.setBounds(258, 132, 168, 25);
		add(btnConfirmaCadastrarGerente);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DataCore\\Desktop\\Logo_DataCore_Preto.jpg"));
		lblNewLabel.setBounds(-126, -57, 876, 482);
		add(lblNewLabel);
	}
}
