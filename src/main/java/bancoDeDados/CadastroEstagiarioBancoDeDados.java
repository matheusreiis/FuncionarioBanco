package bancoDeDados;

import java.util.List;
import java.util.Scanner;

import entities.Estagiario;
import entities.Funcionario;
import validadores.ValidadorDeCpf;
import validadores.ValidadorDeEstadoCivil;
import validadores.ValidadorDeIdade;
import validadores.ValidadorDeSalario;

public class CadastroEstagiarioBancoDeDados {

	Scanner sc = new Scanner(System.in);
	Funcionario estagiario1 = new Estagiario();
	BancoDeDadosFuncionario bancoDeDadosFuncionario = new BancoDeDadosFuncionario();
	ValidadorDeCpf validaCpf = new ValidadorDeCpf();
	ValidadorDeEstadoCivil validaEstadoCivil = new ValidadorDeEstadoCivil();
	ValidadorDeIdade validaIdade = new ValidadorDeIdade();
	ValidadorDeSalario validaSalario = new ValidadorDeSalario();

	String nome = "";
	String sobrenome = "";
	long cpf = 0;
	String mensagem = "";
	double salario = 0;
	int idade = 0;
	String estadoCivil = "";

	public void cadastroEstagiario(String mensagemNome, String mensagemCpf, String mensagemSalario,
			String mensagemIdade, String mensagemEstadoCivil, List<Funcionario> listaEstagiario) {

		System.out.print(mensagemNome);
		nome = sc.next();
		sobrenome = sc.next();
		estagiario1.setNome(nome);
		estagiario1.setSobrenome(sobrenome);

		System.out.print(mensagemCpf);
		estagiario1.setCpf(validaCpf.validaCpf(cpf, mensagemCpf));

		System.out.print(mensagemSalario);

		estagiario1.setSalario(validaSalario.validaSalario(salario, mensagemSalario));

		System.out.print(mensagemIdade);
		estagiario1.setIdade(validaIdade.validaIdade(idade, mensagemIdade));

		System.out.print(mensagemEstadoCivil);
		estagiario1.setEstadoCivil(validaEstadoCivil.validaEstadoCivil(estadoCivil, mensagemEstadoCivil));

		System.out.print("Cadastre um login com ate 6 digitos: ");
		//estagiario1.setCadastroDoSistema(sc.nextInt());

		System.out.print("Cadastre uma senha com ate 6 digitos: ");
		//estagiario1.setCadastroDoSistema(sc.nextInt());

		listaEstagiario.add(estagiario1);
		bancoDeDadosFuncionario.listaDeRegistroEstagiario(listaEstagiario);
	}
}
