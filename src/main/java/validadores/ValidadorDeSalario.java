package validadores;

import java.util.Scanner;

import interfaces.IValidadorDeSalario;

public class ValidadorDeSalario implements IValidadorDeSalario {

	Scanner sc = new Scanner(System.in);

	public double validaSalario(double salario, String mensagemSalario) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				while (salario <= 0) {
					System.out.println(
							"##### SALARIO INVALIDO ##### Por favor insira um salario de no minimo R$ 1000,00");
					System.out.println();
					System.out.print(mensagemSalario);
					salario = sc.nextDouble();
				}
				validaErroCatch = false;
			} catch (Exception e) {
				System.out.println("\n##### SALARIO INVALIDO ##### Por favor insira somente numeros! ");
				System.out.println();
				sc.nextLine();
				System.out.print(mensagemSalario);
				validaErroCatch = true;
			}
		}
		return salario;
	}
}
