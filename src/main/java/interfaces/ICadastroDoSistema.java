package interfaces;

import java.io.IOException;

public interface ICadastroDoSistema {

	public int validacaoDoLoginDoCadastroDoSistema(int loginCadastro, String mensagemDeLoginCadastro) throws IOException;
	public int validacaoDaSenhaDoCadastroDoSistema(int senhaCadastro, String mensagemDeSenhaCadastro); 
}
