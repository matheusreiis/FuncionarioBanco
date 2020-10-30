package validadores;

import java.util.Scanner;

import org.apache.log4j.Logger;

import interfaces.IValidadorDeEstadoCivil;

public class ValidadorDeEstadoCivil implements IValidadorDeEstadoCivil {

	private static final Logger logger = Logger.getLogger(ValidadorDeEstadoCivil.class);
	Scanner sc = new Scanner(System.in);

	String Solteiro, Solteira, Casado, Casada, Viuvo, Viuva;

	public String validaEstadoCivil(String estadoCivil, String mensagemEstadoCivil) {

		boolean validaErroCatch = true;
		while (validaErroCatch) {
			estadoCivil = estadoCivil.substring(0, 1).toUpperCase().concat(estadoCivil.substring(1));
			while (!estadoCivil.matches("Solteiro") && !estadoCivil.matches("Casado") && !estadoCivil.matches("Viuvo")
					&& !estadoCivil.matches("Solteira") && !estadoCivil.matches("Casada")
					&& !estadoCivil.matches("Viuva")) {
				logger.error("#### ESTADO CIVIL INVALIDO, POR FAVOR INSIRA UM ESTADO VALIDO ####"
						+ System.lineSeparator() + "Solteiro(a)" + "\n" + "Casado(a)" + "\n" + "Viuvo(a)");
				logger.info(mensagemEstadoCivil);
				estadoCivil = sc.next();
				estadoCivil = estadoCivil.substring(0, 1).toUpperCase().concat(estadoCivil.substring(1));
			}
			validaErroCatch = false;
		}
		return estadoCivil;
	}
}
