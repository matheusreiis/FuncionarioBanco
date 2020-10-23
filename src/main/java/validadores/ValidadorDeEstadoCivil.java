package validadores;

import java.util.Scanner;

import interfaces.IValidadorDeEstadoCivil;

public class ValidadorDeEstadoCivil implements IValidadorDeEstadoCivil {

	Scanner sc = new Scanner(System.in);

	public String validaEstadoCivil(String estadoCivil, String mensagemEstadoCivil) {

		estadoCivil = sc.next();
		if (estadoCivil.matches("Solteiro")) {
			System.out.println("##### ESTADO CIVIL INVALIDO ##### ");
			System.out.println();
			estadoCivil = sc.next();
			sc.nextLine();
		}
		return estadoCivil;
	}

}
