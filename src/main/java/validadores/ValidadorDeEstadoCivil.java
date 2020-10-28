package validadores;

import java.util.Scanner;

import org.apache.log4j.Logger;

import interfaces.IValidadorDeEstadoCivil;

public class ValidadorDeEstadoCivil implements IValidadorDeEstadoCivil {
	
	private static final Logger logger = Logger.getLogger(ValidadorDeEstadoCivil.class);
	Scanner sc = new Scanner(System.in);

	public String validaEstadoCivil(String estadoCivil, String mensagemEstadoCivil) {

		estadoCivil = sc.next();
		if (estadoCivil.matches("Solteiro")) {
			logger.error("##### ESTADO CIVIL INVALIDO ##### ");
			System.out.println();
			estadoCivil = sc.next();
			sc.nextLine();
		}
		return estadoCivil;
	}

}
