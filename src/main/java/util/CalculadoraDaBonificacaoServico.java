package util;

import interfaces.ICalculoDaBonificacao;

public class CalculadoraDaBonificacaoServico implements ICalculoDaBonificacao {

	public double calculoDaBonificacao(double salario, double porcentagemDaBonificacao, String mensagem) {
		return salario * porcentagemDaBonificacao;
	}
}
