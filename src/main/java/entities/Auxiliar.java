package entities;

import interfaces.ICalculoDaBonificacao;

public class Auxiliar extends Funcionario implements ICalculoDaBonificacao {

	protected String validacaoDoSistema;
	protected String cadastroDoSistema;

	
	public Auxiliar() {

	}

	public double calculoDaBonificacao(double salario, double porcentagemDaBonificacao, String mensagem) {
		return 0;
	}
}
