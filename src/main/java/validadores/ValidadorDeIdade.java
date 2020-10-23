package validadores;

import java.util.Scanner;

import interfaces.IValidadorDeIdade;

public class ValidadorDeIdade implements IValidadorDeIdade {

	Scanner sc = new Scanner(System.in);

	public int validaIdade(int idade, String mensagemIdade) {
		boolean validaErroCatch = true;
		while (validaErroCatch) {
			try {
				if (idade < 18 || idade > 70) {
					System.out.println("##### IDADE INVALIDA ##### Por favor insira uma idade entre 18 e 70 anos!");
					System.out.println();
					System.out.print(mensagemIdade);
					idade = sc.nextInt();
				}
				validaErroCatch = false;
			} catch (Exception e) {
				System.out.println("##### IDADE INVALIDA ##### Por favor insira somente numeros!");
				System.out.println();
				sc.nextLine();
				System.out.print(mensagemIdade);
				validaErroCatch = true;
			}

		}
		return idade;
	}
}
