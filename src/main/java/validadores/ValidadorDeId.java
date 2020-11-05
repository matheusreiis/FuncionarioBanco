package validadores;

import java.util.Scanner;

import org.apache.log4j.Logger;

import interfaces.IValidadorDeId;

public class ValidadorDeId implements IValidadorDeId {
	
	private static final Logger logger = Logger.getLogger(ValidadorDeId.class);
	Scanner sc = new Scanner(System.in);

	public int validacaoDeId(int id, String mensagemId) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				String valueOf = "";
				valueOf = extracted(id);
				while (valueOf.length() != 1 && valueOf.length() != 2 && valueOf.length() != 3) {
					logger.error("##### Por favor insira uma id valido #####");
					System.out.println();
					logger.info(mensagemId);
					id = sc.nextInt();
					valueOf = extracted(id);
					logger.info(valueOf);
				}
				validaErroCatch = false;
			} catch (Exception e) {
				logger.error("##### ID INVALIDO ##### " + System.lineSeparator());
				sc.nextLine();
				logger.info(mensagemId);
				validaErroCatch = true;
			}
		}
		return id;
	}

	private String extracted(int id) {
		String valueOf;
		valueOf = String.valueOf(id);
		valueOf.length();
		return valueOf;
	}		
}