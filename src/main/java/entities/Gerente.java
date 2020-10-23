package entities;

import interfaces.ICalculoDaBonificacao;

public class Gerente extends Funcionario implements ICalculoDaBonificacao {

	public Gerente() {

	}

	public double calculoDaBonificacao(double salario, double porcentagemDaBonificacao, String mensagem) {
		return porcentagemDaBonificacao * 0.15;
	}
}