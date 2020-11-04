package bancoDeDados;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import arquivos.ArquivoDeEstagiario;
import entities.Estagiario;
import entities.Funcionario;
import util.GeradorDeId;
import validadores.ValidadorDeCadastroDoSistema;
import validadores.ValidadorDeCpf;
import validadores.ValidadorDeEstadoCivil;
import validadores.ValidadorDeId;
import validadores.ValidadorDeIdade;
import validadores.ValidadorDeNomeESobrenome;
import validadores.ValidadorDeSalario;

public class CadastroEstagiarioBancoDeDados {

	private static final Logger logger = Logger.getLogger(CadastroEstagiarioBancoDeDados.class);

	Scanner sc = new Scanner(System.in);
	BancoDeDadosFuncionario bancoDeDadosFuncionario = new BancoDeDadosFuncionario();
	ValidadorDeCpf validaCpf = new ValidadorDeCpf();
	ValidadorDeEstadoCivil validaEstadoCivil = new ValidadorDeEstadoCivil();
	ValidadorDeIdade validaIdade = new ValidadorDeIdade();
	ValidadorDeSalario validaSalario = new ValidadorDeSalario();
	ValidadorDeCadastroDoSistema validaCadastro = new ValidadorDeCadastroDoSistema();
	ValidadorDeId validaId = new ValidadorDeId();
	ValidadorDeNomeESobrenome validaNomeESobrenome = new ValidadorDeNomeESobrenome();
	GeradorDeId statusId = new GeradorDeId();
	ArquivoDeEstagiario arquivoEstagiario = new ArquivoDeEstagiario();

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
	String mensagemNome = "Cadastre o nome do Estagiario: ";
	String mensagemSobrenome = "Cadastre o sobrenome do Estagiario: ";
	String mensagemCpf = "Cadastre o cpf do Estagiario: ";
	String mensagemSalario = "Cadastre um salario do Estagiario: ";
	String mensagemIdade = "Cadastre uma idade do Estagiario: ";
	String mensagemEstadoCivil = "Cadastre o Estado Civil do Estagiario: ";
	String mensagemDeLoginCadastro = "Digite seu login (6 numeros): ";
	String mensagemDeSenhaCadastro = "Digite sua senha (6 numeros): ";
	boolean validaErroCatch = true;
	boolean validaErroConfirma = true;

	public void cadastroEstagiario(List<Funcionario> listaEstagiario) throws Exception {

		Estagiario estagiario = new Estagiario();

		logger.info("---------- CADASTRO ESTAGIARIO ---------" + System.lineSeparator());

		estagiario.setId(statusId.gerarId());

		logger.debug(mensagemNome);
		nome = sc.next();
		estagiario.setNome(validaNomeESobrenome.validaNome(nome, mensagemNome));

		logger.debug(mensagemSobrenome);
		sobrenome = sc.next();
		estagiario.setSobrenome(validaNomeESobrenome.validaSobrenome(sobrenome, mensagemSobrenome));

		logger.debug(mensagemCpf);
		estagiario.setCpf(validaCpf.validaCpf(cpf, mensagemCpf));

		logger.debug(mensagemSalario);
		salario = sc.nextDouble();
		estagiario.setSalario(validaSalario.validaSalario(salario, mensagemSalario));

		logger.debug(mensagemIdade);
		idade = sc.nextInt();
		estagiario.setIdade(validaIdade.validaIdade(idade, mensagemIdade));

		logger.debug(mensagemEstadoCivil);
		estadoCivil = sc.next();
		estagiario.setEstadoCivil(validaEstadoCivil.validaEstadoCivil(estadoCivil, mensagemEstadoCivil));

		logger.debug(mensagemDeLoginCadastro);
		loginCadastro = sc.nextInt();
		estagiario.setLoginDoCadastroDoSistema(
				validaCadastro.validacaoDoLoginDoCadastroDoSistema(loginCadastro, mensagemDeLoginCadastro));

		logger.debug(mensagemDeSenhaCadastro);
		senhaCadastro = sc.nextInt();
		estagiario.setSenhaDoCadastroDoSistema(
				validaCadastro.validacaoDaSenhaDoCadastroDoSistema(senhaCadastro, mensagemDeSenhaCadastro));

		listaEstagiario.add(estagiario);
		bancoDeDadosFuncionario.listaDeRegistroEstagiario(listaEstagiario);

		logger.debug("Confirmar dados do Funcionario (y/n)?");
		char confirmaDadosEstagiario = sc.next().charAt(0);

		while (validaErroConfirma) {
			if (confirmaDadosEstagiario == 'n') {
				logger.info("Cadastrando Estagiario novamente!");
				listaEstagiario.remove(estagiario);
				estagiario.setId(statusId.removeId());
				validaErroCatch = true;
			} else if (confirmaDadosEstagiario == 'y') {
				arquivoEstagiario.listaDeEstagiariosAtivos(listaEstagiario);
				validaErroConfirma = false;
				validaErroCatch = false;
			} else if (confirmaDadosEstagiario != 'y' && confirmaDadosEstagiario != 'n') {
				logger.debug("Por favor, insira 'y' ou 'n' para confirmar os dados do Estagiario: "
						+ System.lineSeparator());
				validaErroCatch = true;
			}
		}
		logger.info("********** ESTAGIARIO CADASTRADO COM SUCESSO! **********\n");
	}
}
