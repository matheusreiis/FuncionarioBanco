package bancoDeDados;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import entities.Estagiario;
import entities.Funcionario;
import validadores.ValidadorDeCadastroDoSistema;
import validadores.ValidadorDeCpf;
import validadores.ValidadorDeEstadoCivil;
import validadores.ValidadorDeId;
import validadores.ValidadorDeIdade;
import validadores.ValidadorDeSalario;

public class CadastroEstagiarioBancoDeDados {
	
	private static final Logger logger = Logger.getLogger(CadastroEstagiarioBancoDeDados.class);

	Scanner sc = new Scanner(System.in);
	Estagiario estagiario = new Estagiario();
	BancoDeDadosFuncionario bancoDeDadosFuncionario = new BancoDeDadosFuncionario();
	ValidadorDeCpf validaCpf = new ValidadorDeCpf();
	ValidadorDeEstadoCivil validaEstadoCivil = new ValidadorDeEstadoCivil();
	ValidadorDeIdade validaIdade = new ValidadorDeIdade();
	ValidadorDeSalario validaSalario = new ValidadorDeSalario();
	ValidadorDeCadastroDoSistema validaCadastro = new ValidadorDeCadastroDoSistema();
	ValidadorDeId validaId = new ValidadorDeId();
	
	int id;
	String nome;
	String sobrenome;
	long cpf;
	String mensagem;
	double salario;
	int idade;
	int loginCadastro;
	int senhaCadastro;
	String estadoCivil;
	String mensagemId = "Cadastre o Id do Estagiario: ";
	String mensagemNome = "Cadastre o nome e sobrenome do Estagiario: ";
	String mensagemCpf = "Cadastre o cpf do Estagiario: ";
	String mensagemSalario = "Cadastre um salario do Estagiario: ";
	String mensagemIdade = "Cadastre uma idade do Estagiario: ";
	String mensagemEstadoCivil = "Cadastre o Estado Civil do Estagiario: ";
	String mensagemDeLoginCadastro = "Digite seu login (6 digitos): ";
	String mensagemDeSenhaCadastro = "Digite sua senha (6 digitos): ";

	public void cadastroEstagiario(List<Funcionario> listaEstagiario) {
		
		logger.info("\n---------- CADASTRO ESTAGIARIO ---------" + System.lineSeparator());
		
		logger.debug(mensagemId);
		id = sc.nextInt();
		estagiario.setId(id);
		estagiario.setId(validaId.validacaoDeId(id, mensagemId));

		logger.debug(mensagemNome);
		nome = sc.next();
		sobrenome = sc.next();
		estagiario.setNome(nome);
		estagiario.setSobrenome(sobrenome);

		logger.debug(mensagemCpf);
		estagiario.setCpf(validaCpf.validaCpf(cpf, mensagemCpf));

		logger.debug(mensagemSalario);
		estagiario.setSalario(validaSalario.validaSalario(salario, mensagemSalario));

		logger.debug(mensagemIdade);
		estagiario.setIdade(validaIdade.validaIdade(idade, mensagemIdade));

		logger.debug(mensagemEstadoCivil);
		estagiario.setEstadoCivil(validaEstadoCivil.validaEstadoCivil(estadoCivil, mensagemEstadoCivil));

		logger.debug("Cadastre um login com ate 6 digitos: ");
		loginCadastro = sc.nextInt();
		estagiario.setLoginDoCadastroDoSistema(
				validaCadastro.validacaoDoLoginDoCadastroDoSistema(loginCadastro, mensagemDeLoginCadastro));

		logger.debug("Cadastre uma senha com ate 6 digitos: ");
		senhaCadastro = sc.nextInt();
		estagiario.setSenhaDoCadastroDoSistema(
				validaCadastro.validacaoDaSenhaDoCadastroDoSistema(senhaCadastro, mensagemDeSenhaCadastro));

		listaEstagiario.add(estagiario);
		
		bancoDeDadosFuncionario.listaDeRegistroEstagiario(listaEstagiario);
		
		logger.info("\n********** ESTAGIARIO CADASTRADO COM SUCESSO! **********\n");
	}
}
