package bancoDeDados;

import java.util.List;
import java.util.Scanner;

import entities.Auxiliar;
import entities.Funcionario;
import validadores.ValidadorDeCpf;
import validadores.ValidadorDeEstadoCivil;
import validadores.ValidadorDeIdade;
import validadores.ValidadorDeSalario;

public class CadastroAuxiliarBancoDeDados {

	Scanner sc = new Scanner(System.in);
	Funcionario auxiliar1 = new Auxiliar();
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

	public void cadastroAuxiliar(String mensagemNome, String mensagemCpf, String mensagemSalario,
			String mensagemIdade, String mensagemEstadoCivil, List<Funcionario> listaAuxiliar) {

		System.out.print(mensagemNome);
		nome = sc.next();
		sobrenome = sc.next();
		auxiliar1.setNome(nome);
		auxiliar1.setSobrenome(sobrenome);

		System.out.print(mensagemCpf);
		auxiliar1.setCpf(validaCpf.validaCpf(cpf, mensagemCpf));

		System.out.print(mensagemSalario);
		auxiliar1.setSalario(validaSalario.validaSalario(salario, mensagemSalario));

		System.out.print(mensagemIdade);
		auxiliar1.setIdade(validaIdade.validaIdade(idade, mensagemIdade));

		System.out.print(mensagemEstadoCivil);
		auxiliar1.setEstadoCivil(validaEstadoCivil.validaEstadoCivil(estadoCivil, mensagemEstadoCivil));

		System.out.print("Cadastre um login com ate 6 digitos: ");
		//auxiliar1.setCadastroDoSistema(sc.nextInt());

		System.out.print("Cadastre uma senha com ate 6 digitos: ");
		//auxiliar1.setCadastroDoSistema(sc.nextInt());

		listaAuxiliar.add(auxiliar1);
		bancoDeDadosFuncionario.listaDeRegistroAuxiliar(listaAuxiliar);
	}
}
