package bancoDeDados;

import java.util.List;  
import java.util.Scanner;

import org.apache.log4j.Logger;

import arquivos.ArquivoDeEstagiario;
import entities.Estagiario;
import entities.Funcionario;
import validadores.ValidadorDeCadastroDoSistema;
import validadores.ValidadorDeCpf;
import validadores.ValidadorDeEstadoCivil;
import validadores.ValidadorDeIdade;
import validadores.ValidadorDeNomeESobrenome;
import validadores.ValidadorDeSalario;

public class CadastroEstagiarioBancoDeDados {

	private static final Logger logger = Logger.getLogger(CadastroEstagiarioBancoDeDados.class);

	Scanner sc = new Scanner(System.in);
	BancoDeDadosEstagiario bancoDeDadosEstagiario = new BancoDeDadosEstagiario();
	ValidadorDeCpf validaCpf = new ValidadorDeCpf();
	ValidadorDeEstadoCivil validaEstadoCivil = new ValidadorDeEstadoCivil();
	ValidadorDeIdade validaIdade = new ValidadorDeIdade();
	ValidadorDeSalario validaSalario = new ValidadorDeSalario();
	ValidadorDeCadastroDoSistema validaCadastro = new ValidadorDeCadastroDoSistema();
	ValidadorDeNomeESobrenome validaNomeESobrenome = new ValidadorDeNomeESobrenome();
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
	
	public void cadastroEstagiario(List<Funcionario> listaEstagiario) throws Exception {

		boolean validaErroCatch = true;
		while (validaErroCatch) {
			Estagiario estagiario = new Estagiario();
			boolean validaErroConfirma = true;

			logger.info("---------- CADASTRO ESTAGIARIO ---------" + System.lineSeparator());

			logger.debug(mensagemNome);
			estagiario.setNome(validaNomeESobrenome.validaNome(nome, mensagemNome));

			logger.debug(mensagemSobrenome);
			estagiario.setSobrenome(validaNomeESobrenome.validaSobrenome(sobrenome, mensagemSobrenome));

			logger.debug(mensagemCpf);
			estagiario.setCpf(validaCpf.validaCpf(cpf, mensagemCpf));

			logger.debug(mensagemSalario);
			estagiario.setSalario(validaSalario.validaSalario(salario, mensagemSalario));

			logger.debug(mensagemIdade);
			estagiario.setIdade(validaIdade.validaIdade(idade, mensagemIdade));

			logger.debug(mensagemEstadoCivil);
			estagiario.setEstadoCivil(validaEstadoCivil.validaEstadoCivil(estadoCivil, mensagemEstadoCivil));

			logger.debug(mensagemDeLoginCadastro);
			estagiario.setLoginDoCadastroDoSistema(
					validaCadastro.validacaoDoLoginDoCadastroDoSistema(loginCadastro, mensagemDeLoginCadastro));

			logger.debug(mensagemDeSenhaCadastro);
			estagiario.setSenhaDoCadastroDoSistema(
					validaCadastro.validacaoDaSenhaDoCadastroDoSistema(senhaCadastro, mensagemDeSenhaCadastro));

			listaEstagiario.add(estagiario);
			bancoDeDadosEstagiario.listaDeRegistroEstagiario(listaEstagiario, estagiario);

			while (validaErroConfirma) {
			logger.debug("Confirmar dados do Funcionario (y/n)?");
			char confirmaDadosEstagiario = sc.next().charAt(0);
			
				if (confirmaDadosEstagiario == 'n') {
					logger.info("Cadastrando Estagiario novamente!");
					listaEstagiario.remove(estagiario);
					validaErroConfirma = false;
					validaErroCatch = true;
				} else if (confirmaDadosEstagiario == 'y') {
					arquivoEstagiario.listaDeEstagiariosAtivos(listaEstagiario);
					bancoDeDadosEstagiario.inserirDadosBancoEstagiario(estagiario);
					bancoDeDadosEstagiario.pegarDadosBancoEstagiario(estagiario);
					validaErroConfirma = false;
					validaErroCatch = false;
				} else if (confirmaDadosEstagiario != 'y' && confirmaDadosEstagiario != 'n') {
					logger.debug("Por favor, insira 'y' ou 'n' para confirmar os dados do Estagiario: "
							+ System.lineSeparator());
					validaErroConfirma = true;
				}
			}
		}
		logger.info("********** ESTAGIARIO CADASTRADO COM SUCESSO! **********\n");
	}
}
