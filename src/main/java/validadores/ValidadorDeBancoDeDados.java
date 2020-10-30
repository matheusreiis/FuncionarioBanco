package validadores;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import entities.Funcionario;
import interfaces.IValidadorDoBancoDeDados;
import sistemas.AutenticacaoSistema;

public class ValidadorDeBancoDeDados implements IValidadorDoBancoDeDados {

	private static final Logger logger = Logger.getLogger(ValidadorDeBancoDeDados.class);
	Scanner sc = new Scanner(System.in);
	ValidadorDeAutenticacaoDoSistema validaSistema = new ValidadorDeAutenticacaoDoSistema();
	AutenticacaoSistema autenticaSistema = new AutenticacaoSistema();

	String mensagemDeLogin = "Digite seu login: ";
	String mensagemDeSenha = "Digite sua senha: ";

	public void validaBancoGerente(int loginAutenticacao, int senhaAutenticacao, List<Funcionario> listaGerente) {

		logger.info(mensagemDeLogin);
		loginAutenticacao = sc.nextInt();
		validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin);

		logger.info(mensagemDeSenha);
		senhaAutenticacao = sc.nextInt();
		validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha);

		autenticaSistema.autenticaSistemaGerente(loginAutenticacao, senhaAutenticacao, listaGerente);
	}
	
	public void validaBancoAuxiliar(int loginAutenticacao, int senhaAutenticacao, List<Funcionario> listaAuxiliar) {
		
		logger.info(mensagemDeLogin);
		loginAutenticacao = sc.nextInt();
		validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin);
		
		logger.info(mensagemDeSenha);
		senhaAutenticacao = sc.nextInt();
		validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha);
		
		autenticaSistema.autenticaSistemaAuxiliar(loginAutenticacao, senhaAutenticacao, listaAuxiliar);
		
	}
	
	public void validaBancoEstagiario(int loginAutenticacao, int senhaAutenticacao, List<Funcionario> listaEstagiario) {
		
		logger.info(mensagemDeLogin);
		loginAutenticacao = sc.nextInt();
		validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin);
		
		logger.info(mensagemDeSenha);
		senhaAutenticacao = sc.nextInt();
		validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha);
		
		autenticaSistema.autenticaSistemaEstagiario(loginAutenticacao, senhaAutenticacao, listaEstagiario);
	}
}
