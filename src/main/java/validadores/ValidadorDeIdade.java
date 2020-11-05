package validadores;

import java.util.Scanner;

import org.apache.log4j.Logger;

import interfaces.IValidadorDeIdade;

public class ValidadorDeIdade implements IValidadorDeIdade {

	private static final Logger logger = Logger.getLogger(ValidadorDeIdade.class);
	Scanner sc = new Scanner(System.in);

	public int validaIdade(int idade, String mensagemIdade) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				idade = sc.nextInt();
				if (idade < 18 || idade > 70) {
					logger.error("##### IDADE INVALIDA ##### Por favor insira uma idade entre 18 e 70 anos!"
							+ System.lineSeparator());
					logger.info(mensagemIdade);
					idade = sc.nextInt();
				}
				validaErroCatch = false;
			} catch (Exception e) {
				logger.error("##### IDADE INVALIDA ##### Por favor insira somente numeros!" + System.lineSeparator());
				sc.nextLine();
				logger.info(mensagemIdade);
				validaErroCatch = true;
			}
		}
		return idade;
	}
}
