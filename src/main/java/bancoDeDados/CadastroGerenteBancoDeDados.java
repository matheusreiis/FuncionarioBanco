package bancoDeDados;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import arquivos.ArquivoDeGerente;
import entities.Funcionario;
import entities.Gerente;
import util.GeradorDeId;
import validadores.ValidadorDeCadastroDoSistema;
import validadores.ValidadorDeCpf;
import validadores.ValidadorDeEstadoCivil;
import validadores.ValidadorDeId;
import validadores.ValidadorDeIdade;
import validadores.ValidadorDeNomeESobrenome;
import validadores.ValidadorDeSalario;

public class CadastroGerenteBancoDeDados {

	private static final Logger logger = Logger.getLogger(CadastroGerenteBancoDeDados.class);

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
	ArquivoDeGerente arquivoGerente = new ArquivoDeGerente();

	int id;
	String nome;
	String sobrenome;
	long cpf;
	double salario;
	int idade;
	String estadoCivil;
	int loginCadastro;
	int senhaCadastro;
	String mensagemNome = "Cadastre o nome do Gerente: ";
	String mensagemSobrenome = "Cadastre o sobrenome do Gerente: ";
	String mensagemCpf = "Cadastre o cpf do Gerente: ";
	String mensagemSalario = "Cadastre um salario do Gerente: ";
	String mensagemIdade = "Cadastre uma idade do Gerente: ";
	String mensagemEstadoCivil = "Cadastre o Estado Civil do Gerente: ";
	String mensagemDeLoginCadastro = "Digite seu login (6 digitos): ";
	String mensagemDeSenhaCadastro = "Digite sua senha (6 digitos): ";
	boolean validaErroCatch = true;
	boolean validaErroConfirma = true;

	public void cadastroGerente(List<Funcionario> listaGerente) throws Exception {

		while (validaErroCatch) {
			Gerente gerente = new Gerente();

			logger.info("---------- CADASTRO GERENTE ---------" + System.lineSeparator());

			gerente.setId(statusId.gerarId());

			logger.debug(mensagemNome);
			nome = sc.next();
			gerente.setNome(validaNomeESobrenome.validaNome(nome, mensagemNome));

			logger.debug(mensagemSobrenome);
			sobrenome = sc.next();
			gerente.setSobrenome(validaNomeESobrenome.validaSobrenome(sobrenome, mensagemSobrenome));

			logger.debug(mensagemCpf);
			gerente.setCpf(validaCpf.validaCpf(cpf, mensagemCpf));

			logger.debug(mensagemSalario);
			salario = sc.nextDouble();
			gerente.setSalario(validaSalario.validaSalario(salario, mensagemSalario));

			logger.debug(mensagemIdade);
			idade = sc.nextInt();
			gerente.setIdade(validaIdade.validaIdade(idade, mensagemIdade));

			logger.debug(mensagemEstadoCivil);
			estadoCivil = sc.next();
			gerente.setEstadoCivil(validaEstadoCivil.validaEstadoCivil(estadoCivil, mensagemEstadoCivil));

			logger.debug(mensagemDeLoginCadastro);
			loginCadastro = sc.nextInt();
			gerente.setLoginDoCadastroDoSistema(
					validaCadastro.validacaoDoLoginDoCadastroDoSistema(loginCadastro, mensagemDeLoginCadastro));

			logger.debug(mensagemDeSenhaCadastro);
			senhaCadastro = sc.nextInt();
			gerente.setSenhaDoCadastroDoSistema(
					validaCadastro.validacaoDaSenhaDoCadastroDoSistema(senhaCadastro, mensagemDeSenhaCadastro));

			listaGerente.add(gerente);
			bancoDeDadosFuncionario.listaDeRegistroGerente(listaGerente);

			while (validaErroConfirma) {
				logger.debug("Confirmar dados do Funcionario (y/n)?");
				char confirmaDadosGerente = sc.next().charAt(0);

				if (confirmaDadosGerente == 'n') {
					logger.info("Cadastrando Gerente novamente!");
					listaGerente.remove(gerente);
					gerente.setId(statusId.removeId());
					validaErroCatch = true;
				} else if (confirmaDadosGerente == 'y') {
					arquivoGerente.listaDeGerentesAtivos(listaGerente);
					validaErroConfirma = false;
					validaErroCatch = false;
				} else if (confirmaDadosGerente != 'y' && confirmaDadosGerente != 'n') {
					logger.debug("Por favor, insira 'y' ou 'n' para confirmar os dados do Gerente: "
							+ System.lineSeparator());
					validaErroConfirma = true;
				}
			}
		}
		logger.info("********** GERENTE CADASTRADO COM SUCESSO! **********\n");
	}
}
