package bancoDeDados;

import java.util.List; 
import java.util.Scanner;

import org.apache.log4j.Logger;

import arquivos.ArquivoDeGerente;
import entities.Funcionario;
import entities.Gerente;
import validadores.ValidadorDeCadastroDoSistema;
import validadores.ValidadorDeCpf;
import validadores.ValidadorDeEstadoCivil;
import validadores.ValidadorDeIdade;
import validadores.ValidadorDeNomeESobrenome;
import validadores.ValidadorDeSalario;

public class CadastroGerenteBancoDeDados {

	private static final Logger logger = Logger.getLogger(CadastroGerenteBancoDeDados.class);

	Scanner sc = new Scanner(System.in);
	BancoDeDadosGerente bancoDeDadosGerente = new BancoDeDadosGerente();
	ValidadorDeCpf validaCpf = new ValidadorDeCpf();
	ValidadorDeEstadoCivil validaEstadoCivil = new ValidadorDeEstadoCivil();
	ValidadorDeIdade validaIdade = new ValidadorDeIdade();
	ValidadorDeSalario validaSalario = new ValidadorDeSalario();
	ValidadorDeCadastroDoSistema validaCadastro = new ValidadorDeCadastroDoSistema();
	ValidadorDeNomeESobrenome validaNomeESobrenome = new ValidadorDeNomeESobrenome();
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

	public void cadastroGerente(List<Funcionario> listaGerente) throws Exception {
		
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			Gerente gerente = new Gerente();
			boolean validaErroConfirma = true;

			logger.info("---------- CADASTRO GERENTE ---------" + System.lineSeparator());
			
			logger.debug(mensagemNome);
			gerente.setNome(validaNomeESobrenome.validaNome(nome, mensagemNome));

			logger.debug(mensagemSobrenome);
			gerente.setSobrenome(validaNomeESobrenome.validaSobrenome(sobrenome, mensagemSobrenome));

			logger.debug(mensagemCpf);
			gerente.setCpf(validaCpf.validaCpf(cpf, mensagemCpf));

			logger.debug(mensagemSalario);
			gerente.setSalario(validaSalario.validaSalario(salario, mensagemSalario));

			logger.debug(mensagemIdade);
			gerente.setIdade(validaIdade.validaIdade(idade, mensagemIdade));

			logger.debug(mensagemEstadoCivil);
			gerente.setEstadoCivil(validaEstadoCivil.validaEstadoCivil(estadoCivil, mensagemEstadoCivil));

			logger.debug(mensagemDeLoginCadastro);
			gerente.setLoginDoCadastroDoSistema(
					validaCadastro.validacaoDoLoginDoCadastroDoSistema(loginCadastro, mensagemDeLoginCadastro));

			logger.debug(mensagemDeSenhaCadastro);
			gerente.setSenhaDoCadastroDoSistema(
					validaCadastro.validacaoDaSenhaDoCadastroDoSistema(senhaCadastro, mensagemDeSenhaCadastro));

			listaGerente.add(gerente);
			bancoDeDadosGerente.listaDeRegistroGerente(listaGerente, gerente);

			while (validaErroConfirma) {
				logger.debug("Confirmar dados do Funcionario (y/n)?");
				char confirmaDadosGerente = sc.next().charAt(0);

				if (confirmaDadosGerente == 'n') {
					logger.info("Cadastrando Gerente novamente!");
					listaGerente.remove(gerente);
					validaErroConfirma = false;
					validaErroCatch = true;
				} else if (confirmaDadosGerente == 'y') {
					arquivoGerente.listaDeGerentesAtivos(listaGerente, gerente);
					logger.info("---------- CONECTANDO AO BANCO DE DADOS ----------");
					bancoDeDadosGerente.inserirDadosBancoGerente(gerente);
					bancoDeDadosGerente.pegarDadosBancoGerente(gerente);
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
