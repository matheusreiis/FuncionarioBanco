package sistemas;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import bancoDeDados.ConexaoBancoDeDados;
import entities.Funcionario;
import entities.Gerente;
import validadores.ValidadorDeBancoDeDados;

public class AutenticacaoSistema {

	private Logger logger = Logger.getLogger(AutenticacaoSistema.class);

	SistemaGerente sistemaGerente = new SistemaGerente();
	SistemaAuxiliar sistemaAuxiliar = new SistemaAuxiliar();
	SistemaEstagiario sistemaEstagiario = new SistemaEstagiario();
	ConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDados();
	ValidadorDeBancoDeDados validaBanco = new ValidadorDeBancoDeDados();
	Gerente gerente;
	boolean validaErroIdGerente = true;
	int id;
	int loginDoSistema;
	int senhaDoSistema;

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\FuncionarioBanco\\src\\main\\resources\\dados.properties");
		props.load(file);
		return props;
	}

	public void autenticaSistemaGerente(int loginAutenticacao, int senhaAutenticacao, int acaoLobbyGerente,
			List<Funcionario> listaGerente) throws IOException {

		Properties props = getProp();
		Connection connection = conexaoBancoDeDados.conexaoJDBC();
		ValidadorDeBancoDeDados validaBanco = new ValidadorDeBancoDeDados();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaGerente"));

			ResultSet rs = stmt.executeQuery();
			while (validaErroIdGerente) {
					rs.next(); 
					id = rs.getInt("id");
					rs.getString("nome");

					if (acaoLobbyGerente == id) {
						logger.info("---------- AUTENTICANDO SISTEMA GERENTE ----------" + "\n." + "\n." + "\n.");
						logger.info("Bem vindo(a) novamente Sr. " + rs.getString("nome"));
						validaBanco.validaBancoGerente(loginAutenticacao, senhaAutenticacao, acaoLobbyGerente, listaGerente);
						validaErroIdGerente = false;
					} 
				}
			loginDoSistema = rs.getInt("Login_do_Sistema");
			senhaDoSistema = rs.getInt("Senha_do_Sistema");
			
			if (loginAutenticacao == loginDoSistema
					&& senhaAutenticacao == senhaDoSistema) {
				sistemaGerente.sistemaGerente();
			} else {
				logger.error("########## LOGIN INCORRETO ##########");
				logger.error("Desconectando do sistema!" + "\n." + "\n." + "\n.");
				logger.error("Desconectado!" + System.lineSeparator());
			}
			stmt.close();
		} catch (Exception e) {
			logger.error("#### Id inexistente, por favor insira um id existente para entrar no sistema! ####"
					+ System.lineSeparator());
		}
	}

	public void autenticaSistemaAuxiliar(int loginAutenticacao, int senhaAutenticacao,
			List<Funcionario> listaAuxiliar) {

		for (Funcionario auxiliar : listaAuxiliar) {
			if (loginAutenticacao == auxiliar.getLoginDoCadastroDoSistema()
					&& senhaAutenticacao == auxiliar.getLoginDoCadastroDoSistema()) {
				sistemaAuxiliar.sistemaAuxiliar();
				break;
			} else {
				logger.error("########## LOGIN INCORRETO ##########");
				logger.error("Desconectando do sistema!" + "\n." + "\n." + "\n.");
				logger.error("Desconectado!" + System.lineSeparator());
				break;
			}
		}
	}

	public void autenticaSistemaEstagiario(int loginAutenticacao, int senhaAutenticacao,
			List<Funcionario> listaEstagiario) {

		for (Funcionario estagiario : listaEstagiario) {
			if (loginAutenticacao == estagiario.getLoginDoCadastroDoSistema()
					&& senhaAutenticacao == estagiario.getSenhaDoCadastroDoSistema()) {
				sistemaEstagiario.sistemaEstagiario();
				break;
			} else {
				logger.error("########## LOGIN INCORRETO ##########");
				logger.error("Desconectando do sistema!" + "\n." + "\n." + "\n.");
				logger.error("Desconectado!" + System.lineSeparator());
				break;
			}
		}
	}
}
