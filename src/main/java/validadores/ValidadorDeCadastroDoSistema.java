package validadores;

import java.util.Scanner;

import interfaces.ICadastroDoSistema;

public class ValidadorDeCadastroDoSistema implements ICadastroDoSistema {

	Scanner sc = new Scanner(System.in);

	public int validacaoDoLoginDoCadastroDoSistema(int loginCadastro, String mensagemDeLoginCadastro) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				String valueOf = "";
				valueOf = extracted(loginCadastro, loginCadastro);
				while (valueOf.length() != 6) {
					System.out.println("\n##### Por favor insira 6 digitos para seu login. #####");
					System.out.println();
					System.out.print(mensagemDeLoginCadastro);
					loginCadastro = sc.nextInt();
					valueOf = extracted(loginCadastro, loginCadastro);
				}
				validaErroCatch = false;
			} catch (Exception e) {
				System.out.println("##### LOGIN INVALIDO ##### Por favor insira um login valido! ");
				System.out.println();
				sc.nextLine();
				System.out.print(mensagemDeLoginCadastro);
				validaErroCatch = true;
			} 
		}
		return loginCadastro;
	}
	
	public int validacaoDaSenhaDoCadastroDoSistema(int senhaCadastro, String mensagemDeSenhaCadastro) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				String valueOf = "";
				valueOf = extracted(senhaCadastro, senhaCadastro);
				while (valueOf.length() != 6) {
					System.out.println("\n##### Por favor insira 6 digitos para sua nova senha. #####");
					System.out.println();
					System.out.print(mensagemDeSenhaCadastro);
					senhaCadastro = sc.nextInt();
					valueOf = extracted(senhaCadastro, senhaCadastro);
				}
				validaErroCatch = false;
			} catch (Exception e) {
				System.out.println("##### SENHA INVALIDA ##### Por favor insira uma senha valida! ");
				System.out.println();
				sc.nextLine();
				System.out.print(mensagemDeSenhaCadastro);
				validaErroCatch = true;
			} 
		}
		return senhaCadastro;
	}


	private String extracted(int loginCadastro, int senhaCadastro) {
		String valueOf;
		valueOf = String.valueOf(loginCadastro);
		valueOf = String.valueOf(senhaCadastro);
		valueOf.length();
		return valueOf;
	}

}
