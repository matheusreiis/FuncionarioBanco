package validadores;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import entities.Funcionario;
import interfaces.IValidadorDoBancoDeDados;

public class ValidadorDeBancoDeDados implements IValidadorDoBancoDeDados {

	private static final Logger logger = Logger.getLogger(ValidadorDeBancoDeDados.class);
	Scanner sc = new Scanner(System.in);
	ValidadorDeAutenticacaoDoSistema validaSistema = new ValidadorDeAutenticacaoDoSistema();

	String mensagemDeLogin = "Digite seu login: ";
	String mensagemDeSenha = "Digite sua senha: ";

	public void validaBancoGerente(int loginAutenticacao, int senhaAutenticacao, int acaoLobbyGerente,
			List<Funcionario> listaGerente) {

		logger.info(mensagemDeLogin);
		loginAutenticacao = validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin);

		logger.info(mensagemDeSenha);
		senhaAutenticacao = validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha);
	}

	public void validaBancoAuxiliar(int loginAutenticacao, int senhaAutenticacao, List<Funcionario> listaAuxiliar) {

		logger.info(mensagemDeLogin);
		loginAutenticacao = validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin);

		logger.info(mensagemDeSenha);
		senhaAutenticacao = validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha);

	}

	public void validaBancoEstagiario(int loginAutenticacao, int senhaAutenticacao, List<Funcionario> listaEstagiario) {

		logger.info(mensagemDeLogin);
		loginAutenticacao = validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin);

		logger.info(mensagemDeSenha);
		senhaAutenticacao = validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha);

	}
}