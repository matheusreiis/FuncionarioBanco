package validadores;

import java.util.Scanner;

import org.apache.log4j.Logger;

import entities.Funcionario;
import entities.Gerente;
import interfaces.IValidadorDoBancoDeDados;

public class ValidadorDeBancoDeDados implements IValidadorDoBancoDeDados{
	
	private static final Logger logger = Logger.getLogger(ValidadorDeBancoDeDados.class);
	Scanner sc = new Scanner(System.in);
	Funcionario gerente1 = new Gerente();
	ValidadorDeAutenticacaoDoSistema validaSistema = new ValidadorDeAutenticacaoDoSistema();
	
	int loginAutenticacao;
	int senhaAutenticacao;
	
	public void validaBancoGerente(String mensagemDeLogin, String mensagemDeSenha) {
		
		logger.info(mensagemDeLogin);
		loginAutenticacao = sc.nextInt();
		gerente1.setloginAutenticacao(validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin));
		
		logger.info(mensagemDeSenha);
		senhaAutenticacao = sc.nextInt();
		gerente1.setsenhaAutenticacao(validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha));
	
	}	
}
