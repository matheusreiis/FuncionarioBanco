package validadores;

import java.util.Scanner;

import org.apache.log4j.Logger;

import interfaces.IAutenticacaoDoSistema;

public class ValidadorDeAutenticacaoDoSistema implements IAutenticacaoDoSistema {
	
	private static final Logger logger = Logger.getLogger(ValidadorDeAutenticacaoDoSistema.class);
	Scanner sc = new Scanner(System.in);

	public int validacaoDoLoginDoSistema(int loginAutenticacao, String mensagemDeLogin) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				String valueOf = "";
				valueOf = extracted(loginAutenticacao, loginAutenticacao);
				while (valueOf.length() != 6) {
					logger.debug("##### Por favor insira 6 digitos para validar seu login. #####");
					System.out.println();
					logger.info(mensagemDeLogin);
					loginAutenticacao = sc.nextInt();
					valueOf = extracted(loginAutenticacao, loginAutenticacao);
				}
				validaErroCatch = false;
			} catch (Exception e) {
				logger.error("##### LOGIN INVALIDO ##### Por favor insira um login valido! ");
				System.out.println();
				sc.nextLine();
				logger.info(mensagemDeLogin);
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
					logger.debug("\n##### Por favor insira 6 digitos para validar sua nova senha. #####");
					System.out.println();
					logger.info(mensagemDeSenha);
					senhaAutenticacao = sc.nextInt();
					valueOf = extracted(senhaAutenticacao, senhaAutenticacao);
				}
				validaErroCatch = false;
			} catch (Exception e) {
				logger.error("##### SENHA INVALIDA ##### Por favor insira uma senha valida! ");
				System.out.println();
				sc.nextLine();
				logger.info(mensagemDeSenha);
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