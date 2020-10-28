package entities;

public abstract class Funcionario {

	int id;
	String nome;
	String sobrenome;
	long cpf;
	double salario;
	int idade;
	String estadoCivil;
	double porcentagemDaBonificacao;
	int loginDoCadastroDoSistema;
	int senhaDoCadastroDoSistema;
	int loginAutenticacao;
	int senhaAutenticacao;

	public double getSalario() {
		return salario;
	}

	public String getNome() {
		return nome;
	}

	public String setNome(String nome) {
		return this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public int getLoginDoCadastroDoSistema() {
		return loginDoCadastroDoSistema;
	}

	public void setLoginDoCadastroDoSistema(int loginDoCadastroDoSistema) {
		this.loginDoCadastroDoSistema = loginDoCadastroDoSistema;
	}

	public int getSenhaDoCadastroDoSistema() {
		return senhaDoCadastroDoSistema;
	}

	public void setSenhaDoCadastroDoSistema(int senhaDoCadastroDoSistema) {
		this.senhaDoCadastroDoSistema = senhaDoCadastroDoSistema;
	}

	public int getloginAutenticacao() {
		return loginAutenticacao;
	}

	public void setloginAutenticacao(int loginAutenticacao) {
		this.loginAutenticacao = loginAutenticacao;
	}

	public int getsenhaAutenticacao() {
		return senhaAutenticacao;
	}

	public void setsenhaAutenticacao(int senhaAutenticacao) {
		this.senhaAutenticacao = senhaAutenticacao;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPorcentagemDaBonificacao() {
		return porcentagemDaBonificacao;
	}

	public void setPorcentagemDaBonificacao(double porcentagemDaBonificacao) {
		this.porcentagemDaBonificacao = porcentagemDaBonificacao;
	}
}
