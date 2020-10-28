package validadores;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import interfaces.IValidadorDeCpf;

public class ValidadorDeCpf implements IValidadorDeCpf {
	
	private static final Logger logger = Logger.getLogger(ValidadorDeCpf.class);
	Scanner sc = new Scanner(System.in);

	public long validaCpf(long cpf, String mensagemCpf) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				String valueOf = "";
				valueOf = extracted(cpf);
				while (valueOf.length() != 11) {
					logger.debug("##### Por favor insira 11 digitos para validar seu cpf #####");
					System.out.println();
					logger.info(mensagemCpf);
					cpf = sc.nextLong();
					valueOf = extracted(cpf);
					logger.info(valueOf);
				}
				validaErroCatch = false;
			} catch (InputMismatchException e) {
				logger.error("##### CPF INVALIDO ##### ");
				System.out.println();
				sc.nextLine();
				logger.info(mensagemCpf);
				validaErroCatch = true;
			}
		}
		return cpf;
	}

	private String extracted(long cpf) {
		String valueOf;
		valueOf = String.valueOf(cpf);
		valueOf.length();
		return valueOf;
	}
}
