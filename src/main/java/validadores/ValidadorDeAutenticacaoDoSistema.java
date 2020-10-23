package validadores;

import java.util.Scanner;

import interfaces.IAutenticacaoDoSistema;

public class ValidadorDeAutenticacaoDoSistema implements IAutenticacaoDoSistema {

	Scanner sc = new Scanner(System.in);

	public int validacaoDoLoginDoSistema(int loginAutenticacao, String mensagemDeLogin) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				String valueOf = "";
				valueOf = extracted(loginAutenticacao, loginAutenticacao);
				while (valueOf.length() != 6) {
					System.out.println("\n##### Por favor insira 6 digitos para validar seu login. #####");
					System.out.println();
					System.out.print(mensagemDeLogin);
					loginAutenticacao = sc.nextInt();
					valueOf = extracted(loginAutenticacao, loginAutenticacao);
				}
				validaErroCatch = false;
			} catch (Exception e) {
				System.out.println("##### LOGIN INVALIDO ##### Por favor insira um login valido! ");
				System.out.println();
				sc.nextLine();
				System.out.print(mensagemDeLogin);
				validaErroCatch = true;
			}
		}
		return loginAutenticacao;
	}

	public int validacaoDaSenhaDoSistema(int senhaAutenticacao, String mensagemDeSenha) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				String valueOf = "";
				valueOf = extracted(senhaAutenticacao, senhaAutenticacao);
				while (valueOf.length() != 6) {
					System.out.println("\n##### Por favor insira 6 digitos para validar sua nova senha. #####");
					System.out.println();
					System.out.print(mensagemDeSenha);
					senhaAutenticacao = sc.nextInt();
					valueOf = extracted(senhaAutenticacao, senhaAutenticacao);
				}
				validaErroCatch = false;
			} catch (Exception e) {
				System.out.println("##### SENHA INVALIDA ##### Por favor insira uma senha valida! ");
				System.out.println();
				sc.nextLine();
				System.out.print(mensagemDeSenha);
				validaErroCatch = true;
			}
		}

		return senhaAutenticacao;
	}
	
	private String extracted(int validarAutenticacao, int senhaAutenticacao) {
		String valueOf;
		valueOf = String.valueOf(validarAutenticacao);
		valueOf = String.valueOf(senhaAutenticacao);
		valueOf.length();
		return valueOf;
	}
}
