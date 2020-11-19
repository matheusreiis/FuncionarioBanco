package interfaces;

import java.io.IOException;
import java.sql.Connection;

public interface ICadastroDoSistema {

	public int validacaoDoLoginDoCadastroDoSistema(int loginCadastro, String mensagemDeLoginCadastro, Connection connection) throws IOException;
	public int validacaoDaSenhaDoCadastroDoSistema(int senhaCadastro, String mensagemDeSenhaCadastro); 
}
