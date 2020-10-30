package validadores;

import java.util.Scanner;

import org.apache.log4j.Logger;

import interfaces.IValidadorDeNomeESobrenome;

public class ValidadorDeNomeESobrenome implements IValidadorDeNomeESobrenome {

	boolean validaErroCatch = true;
	private static final Logger logger = Logger.getLogger(ValidadorDeNomeESobrenome.class);
	Scanner sc = new Scanner(System.in);

	public String validaNome(String nome, String mensagemNome) {

		while (validaErroCatch) {
			while (nome.matches("[a-z]*") == false && nome.matches("[A-Z]*") == false) {
				logger.error("#### Nome invalido, por favor insira apenas letras ####" + System.lineSeparator());
				logger.info(mensagemNome);
				nome = sc.next();
			}
//			sobrenome.matches("[a-z]*");
			nome = nome.substring(0, 1).toUpperCase().concat(nome.substring(1));
			validaErroCatch = false;
		}
		validaErroCatch = true;
		return nome;
	}

	public String validaSobrenome(String sobrenome, String mensagemSobrenome) {

		while (validaErroCatch) {
			while (sobrenome.matches("[a-z]*") == false && sobrenome.matches("[A-Z]*") == false) {
				logger.error("#### Sobrenome invalido, por favor insira apenas letras ####" + System.lineSeparator());
				logger.info(mensagemSobrenome);
				sobrenome = sc.next();
			}
			sobrenome = sobrenome.substring(0, 1).toUpperCase().concat(sobrenome.substring(1));
			validaErroCatch = false;
		}
		validaErroCatch = true;
		return sobrenome;
	}
}
