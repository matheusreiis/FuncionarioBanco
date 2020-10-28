package validadores;

import java.util.Scanner;

import org.apache.log4j.Logger;

import interfaces.IValidadorDeSalario;

public class ValidadorDeSalario implements IValidadorDeSalario {
	
	private static final Logger logger = Logger.getLogger(ValidadorDeSalario.class);
	Scanner sc = new Scanner(System.in);

	public double validaSalario(double salario, String mensagemSalario) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				while (salario <= 0) {
					logger.error(
							"##### SALARIO INVALIDO ##### Por favor insira um salario de no minimo R$ 1000,00");
					System.out.println();
					logger.info(mensagemSalario);
					salario = sc.nextDouble();
				}
				validaErroCatch = false;
			} catch (Exception e) {
				logger.error("##### SALARIO INVALIDO ##### Por favor insira somente numeros! ");
				System.out.println();
				sc.nextLine();
				logger.info(mensagemSalario);
				validaErroCatch = true;
			}
		}
		return salario;
	}
}
