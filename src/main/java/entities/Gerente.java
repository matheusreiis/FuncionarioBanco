package entities;

import interfaces.ICalculoDaBonificacao;

public class Gerente extends Funcionario implements ICalculoDaBonificacao {

	@Override
	public String toString() {
		return "Gerente id = " + id + "\n" + "Nome do Gerente = " + nome + " " + sobrenome + "\n" + "cpf = " + cpf
				+ "\n" + "salario = " + salario + "\n" + "idade = " + idade + "\n" + "estadoCivil = " + estadoCivil
				+ "\n" + "porcentagemDaBonificacao = " + porcentagemDaBonificacao + "\n" + "loginDoCadastroDoSistema = "
				+ loginDoCadastroDoSistema + "\n" + "senhaDoCadastroDoSistema = " + senhaDoCadastroDoSistema;
	}

	public Gerente() {

	}

	public double calculoDaBonificacao(double salario, double porcentagemDaBonificacao, String mensagem) {
		return porcentagemDaBonificacao * 0.15;
	}
}