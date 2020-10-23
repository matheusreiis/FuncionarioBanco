package validadores;

import java.util.Scanner;

import entities.Funcionario;
import entities.Gerente;
import interfaces.IValidadorDoBancoDeDados;

public class ValidadorDeBancoDeDados implements IValidadorDoBancoDeDados{

	Scanner sc = new Scanner(System.in);
	Funcionario gerente1 = new Gerente();
	ValidadorDeAutenticacaoDoSistema validaSistema = new ValidadorDeAutenticacaoDoSistema();
	
	int loginAutenticacao;
	int senhaAutenticacao;
	
	public void validaBancoGerente(String mensagemDeLogin, String mensagemDeSenha) {
		
		System.out.print(mensagemDeLogin);
		loginAutenticacao = sc.nextInt();
		gerente1.setloginAutenticacao(validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin));
		
		System.out.print(mensagemDeSenha);
		senhaAutenticacao = sc.nextInt();
		gerente1.setsenhaAutenticacao(validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha));
	
	}	
}
