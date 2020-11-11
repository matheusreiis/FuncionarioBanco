package entities;

import interfaces.ICalculoDaBonificacao;

public class Gerente extends Funcionario implements ICalculoDaBonificacao {

	@Override
	public String toString() {
		return "Gerente [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", salario="
				+ salario + ", idade=" + idade + ", estadoCivil=" + estadoCivil + ", porcentagemDaBonificacao="
				+ porcentagemDaBonificacao + ", loginDoCadastroDoSistema=" + loginDoCadastroDoSistema
				+ ", senhaDoCadastroDoSistema=" + senhaDoCadastroDoSistema + ", getSalario()=" + getSalario()
				+ ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getSobrenome()=" + getSobrenome()
				+ ", getLoginDoCadastroDoSistema()=" + getLoginDoCadastroDoSistema()
				+ ", getSenhaDoCadastroDoSistema()=" + getSenhaDoCadastroDoSistema() + ", getIdade()=" + getIdade()
				+ ", getEstadoCivil()=" + getEstadoCivil() + ", getId()=" + getId() + ", getPorcentagemDaBonificacao()="
				+ getPorcentagemDaBonificacao() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Gerente() {

	}

	public double calculoDaBonificacao(double salario, double porcentagemDaBonificacao, String mensagem) {
		return porcentagemDaBonificacao * 0.15;
	}
}