package validadores;

import java.util.Scanner;

import org.apache.log4j.Logger;

import interfaces.ICadastroDoSistema;

public class ValidadorDeCadastroDoSistema implements ICadastroDoSistema {
	
	private static final Logger logger = Logger.getLogger(ValidadorDeCadastroDoSistema.class);
	Scanner sc = new Scanner(System.in);

	public int validacaoDoLoginDoCadastroDoSistema(int loginCadastro, String mensagemDeLoginCadastro) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				String valueOf = "";
				valueOf = extracted(loginCadastro, loginCadastro);
				while (valueOf.length() != 6) {
					logger.debug("##### Por favor insira 6 digitos para seu login. #####");
					System.out.println();
					logger.info(mensagemDeLoginCadastro);
					loginCadastro = sc.nextInt();
					valueOf = extracted(loginCadastro, loginCadastro);
				}
				validaErroCatch = false;
			} catch (Exception e) {
				logger.error("##### LOGIN INVALIDO ##### Por favor insira um login valido! ");
				System.out.println();
				sc.nextLine();
				logger.info(mensagemDeLoginCadastro);
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
					logger.debug("\n##### Por favor insira 6 digitos para sua nova senha. #####");
					System.out.println();
					logger.info(mensagemDeSenhaCadastro);
					senhaCadastro = sc.nextInt();
					valueOf = extracted(senhaCadastro, senhaCadastro);
				}
				validaErroCatch = false;
			} catch (Exception e) {
				logger.debug("##### SENHA INVALIDA ##### Por favor insira uma senha valida! ");
				System.out.println();
				sc.nextLine();
				logger.info(mensagemDeSenhaCadastro);
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
