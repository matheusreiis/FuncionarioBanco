package interfaces;

public interface IAutenticacaoDoSistema {

	public int validacaoDoLoginDoSistema(int loginAutenticacao, String mensagemDeLogin);
	public int validacaoDaSenhaDoSistema(int senhaAutenticacao, String mensagemDeSenha);
}
