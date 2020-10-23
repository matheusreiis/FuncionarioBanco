package bancoDeDados;

import java.util.List;
import java.util.Scanner;

import entities.Funcionario;
import entities.Gerente;
import validadores.ValidadorDeCadastroDoSistema;
import validadores.ValidadorDeCpf;
import validadores.ValidadorDeEstadoCivil;
import validadores.ValidadorDeIdade;
import validadores.ValidadorDeSalario;

public class CadastroGerenteBancoDeDados {

	Scanner sc = new Scanner(System.in);
	Funcionario gerente1 = new Gerente();
	BancoDeDadosFuncionario bancoDeDadosFuncionario = new BancoDeDadosFuncionario();
	ValidadorDeCpf validaCpf = new ValidadorDeCpf();
	ValidadorDeEstadoCivil validaEstadoCivil = new ValidadorDeEstadoCivil();
	ValidadorDeIdade validaIdade = new ValidadorDeIdade();
	ValidadorDeSalario validaSalario = new ValidadorDeSalario();
	ValidadorDeCadastroDoSistema validaCadastro = new ValidadorDeCadastroDoSistema();

	String nome = "";
	String sobrenome = "";
	long cpf = 0;
	double salario = 0;
	int idade = 0;
	String estadoCivil = "";
	int loginCadastro;
	int senhaCadastro;

	public void cadastroGerente(String mensagemNome, String mensagemCpf, String mensagemSalario, String mensagemIdade,
			String mensagemEstadoCivil, String mensagemDeLoginCadastro, String mensagemDeSenhaCadastro,
			List<Funcionario> listaGerente) {

		System.out.print(mensagemNome);
		nome = sc.next();
		sobrenome = sc.next();
		gerente1.setNome(nome);
		gerente1.setSobrenome(sobrenome);

		System.out.print(mensagemCpf);
		cpf = sc.nextLong();
		gerente1.setCpf(validaCpf.validaCpf(cpf, mensagemCpf));

		System.out.print(mensagemSalario);
		salario = sc.nextDouble();
		gerente1.setSalario(validaSalario.validaSalario(salario, mensagemSalario));

		System.out.print(mensagemIdade);
		idade = sc.nextInt();
		gerente1.setIdade(validaIdade.validaIdade(idade, mensagemIdade));

		System.out.print(mensagemEstadoCivil);
		gerente1.setEstadoCivil(validaEstadoCivil.validaEstadoCivil(estadoCivil, mensagemEstadoCivil));

		System.out.print(mensagemDeLoginCadastro);
		loginCadastro = sc.nextInt();
		gerente1.setLoginDoCadastroDoSistema(validaCadastro.validacaoDoLoginDoCadastroDoSistema(loginCadastro, mensagemDeLoginCadastro));
		
		System.out.print(mensagemDeSenhaCadastro);
		senhaCadastro = sc.nextInt();
		gerente1.setSenhaDoCadastroDoSistema(validaCadastro.validacaoDaSenhaDoCadastroDoSistema(senhaCadastro, mensagemDeSenhaCadastro));

		listaGerente.add(gerente1);
		bancoDeDadosFuncionario.listaDeRegistroGerente(listaGerente);
		
	}
}
