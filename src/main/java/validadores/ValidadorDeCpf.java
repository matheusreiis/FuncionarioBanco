package validadores;

import java.util.InputMismatchException;
import java.util.Scanner;

import interfaces.IValidadorDeCpf;

public class ValidadorDeCpf implements IValidadorDeCpf {

	Scanner sc = new Scanner(System.in);

	public long validaCpf(long cpf, String mensagemCpf) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				String valueOf = "";
				valueOf = extracted(cpf);
				while (valueOf.length() != 11) {
					System.out.println("\n##### Por favor insira 11 digitos para validar seu cpf #####");
					System.out.println();
					System.out.print(mensagemCpf);
					cpf = sc.nextLong();
					valueOf = extracted(cpf);
					System.out.println(valueOf);
				}
				validaErroCatch = false;
			} catch (InputMismatchException e) {
				System.out.println("\n##### CPF INVALIDO ##### ");
				System.out.println();
				sc.nextLine();
				System.out.print(mensagemCpf);
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
