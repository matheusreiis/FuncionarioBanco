package entities;

import interfaces.ICalculoDaBonificacao;

public class Estagiario extends Funcionario implements ICalculoDaBonificacao {

	protected String validacaoDoSistema;
	protected String cadastroDoSistema;

	
	public Estagiario() {

	}

	public double calculoDaBonificacao(double salario, double porcentagemDaBonificacao, String mensagem) {
		return 0;
	}

}
