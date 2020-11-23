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
import entities.Auxiliar;
import entities.Estagiario;
import entities.Funcionario;
import entities.Gerente;
import validadores.ValidadorDeAutenticacaoDoSistema;

public class AutenticacaoSistema {

	private Logger logger = Logger.getLogger(AutenticacaoSistema.class);

	SistemaGerente sistemaGerente = new SistemaGerente();
	SistemaAuxiliar sistemaAuxiliar = new SistemaAuxiliar();
	SistemaEstagiario sistemaEstagiario = new SistemaEstagiario();
	ConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDados();
	ValidadorDeAutenticacaoDoSistema validaSistema = new ValidadorDeAutenticacaoDoSistema();
	Gerente gerente;
	Auxiliar auxiliar;
	Estagiario estagiario;
	boolean validaErro = true;
	int id;
	int loginDoSistema;
	int senhaDoSistema;
	String mensagemDeLogin = "Digite seu login: ";
	String mensagemDeSenha = "Digite sua senha: ";

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\FuncionarioBanco\\src\\main\\resources\\dados.properties");
		props.load(file);
		return props;
	}

	public void autenticaSistemaGerente(int loginAutenticacao, int senhaAutenticacao, int acaoLobbyGerente,
			List<Funcionario> listaGerente, Connection connection) throws IOException {

		Properties props = getProp();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaGerente"));

			ResultSet rs = stmt.executeQuery();
			validaErro = true;
			while (validaErro) {
				rs.next();
				id = rs.getInt("id");

				if (acaoLobbyGerente == id) {
					logger.info("---------- AUTENTICANDO SISTEMA GERENTE ----------" + "\n." + "\n." + "\n.");
					logger.info("Bem vindo(a) novamente Sr. " + rs.getString("nome"));

					logger.info(mensagemDeLogin);
					loginAutenticacao = validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin);

					logger.info(mensagemDeSenha);
					senhaAutenticacao = validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha);

					validaErro = false;
				}
			}
			validaErro = true;
			while (validaErro) {
				loginDoSistema = rs.getInt("Login_do_Sistema");
				senhaDoSistema = rs.getInt("Senha_do_Sistema");

				if (loginAutenticacao == loginDoSistema && senhaAutenticacao == senhaDoSistema
						&& acaoLobbyGerente == id) {
					sistemaGerente.sistemaGerente();
					validaErro = false;
				} else {
					logger.error("########## LOGIN INCORRETO ##########");
					logger.error("Desconectando do sistema!" + "\n." + "\n." + "\n.");
					logger.error("Desconectado!" + System.lineSeparator());
					break;
				}
			}
			stmt.close();
		} catch (Exception e) {
			logger.error("#### Id inexistente, por favor insira um id existente para entrar no sistema! ####"
					+ System.lineSeparator());
		}
	}

	public void autenticaSistemaAuxiliar(int loginAutenticacao, int senhaAutenticacao, int acaoLobbyAuxiliar,
			List<Funcionario> listaAuxiliar) throws IOException {

		Properties props = getProp();
		Connection connection = conexaoBancoDeDados.conexaoJDBC();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaAuxiliar"));

			ResultSet rs = stmt.executeQuery();
			validaErro = true;
			while (validaErro) {
				rs.next();
				id = rs.getInt("id");

				if (acaoLobbyAuxiliar == id) {
					logger.info("---------- AUTENTICANDO SISTEMA AUXILIAR ----------" + "\n." + "\n." + "\n.");
					logger.info("Bem vindo(a) novamente Sr. " + rs.getString("nome"));

					logger.info(mensagemDeLogin);
					loginAutenticacao = validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin);

					logger.info(mensagemDeSenha);
					senhaAutenticacao = validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha);

					validaErro = false;
				}
			}
			validaErro = true;
			while (validaErro) {
				loginDoSistema = rs.getInt("Login_do_Sistema");
				senhaDoSistema = rs.getInt("Senha_do_Sistema");

				if (loginAutenticacao == loginDoSistema && senhaAutenticacao == senhaDoSistema
						&& acaoLobbyAuxiliar == id) {
					sistemaAuxiliar.sistemaAuxiliar();
					validaErro = false;
				} else {
					logger.error("########## LOGIN INCORRETO ##########");
					logger.error("Desconectando do sistema!" + "\n." + "\n." + "\n.");
					logger.error("Desconectado!" + System.lineSeparator());
					break;
				}
			}
			stmt.close();
		} catch (Exception e) {
			logger.error("#### Id inexistente, por favor insira um id existente para entrar no sistema! ####"
					+ System.lineSeparator());
		}
	}

	public void autenticaSistemaEstagiario(int loginAutenticacao, int senhaAutenticacao, int acaoLobbyEstagiario,
			List<Funcionario> listaEstagiario) throws IOException {

		Properties props = getProp();
		Connection connection = conexaoBancoDeDados.conexaoJDBC();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaEstagiario"));

			ResultSet rs = stmt.executeQuery();
			validaErro = true;
			while (validaErro) {
				rs.next();
				id = rs.getInt("id");

				if (acaoLobbyEstagiario == id) {
					logger.info("---------- AUTENTICANDO SISTEMA ESTAGIARIO ----------" + "\n." + "\n." + "\n.");
					logger.info("Bem vindo(a) novamente Sr. " + rs.getString("nome"));

					logger.info(mensagemDeLogin);
					loginAutenticacao = validaSistema.validacaoDoLoginDoSistema(loginAutenticacao, mensagemDeLogin);

					logger.info(mensagemDeSenha);
					senhaAutenticacao = validaSistema.validacaoDaSenhaDoSistema(senhaAutenticacao, mensagemDeSenha);

					validaErro = false;
				}
			}
			validaErro = true;
			while (validaErro) {
				loginDoSistema = rs.getInt("Login_do_Sistema");
				senhaDoSistema = rs.getInt("Senha_do_Sistema");

				if (loginAutenticacao == loginDoSistema && senhaAutenticacao == senhaDoSistema
						&& acaoLobbyEstagiario == id) {
					sistemaEstagiario.sistemaEstagiario();
					validaErro = false;
				} else {
					logger.error("########## LOGIN INCORRETO ##########");
					logger.error("Desconectando do sistema!" + "\n." + "\n." + "\n.");
					logger.error("Desconectado!" + System.lineSeparator());
					break;
				}
			}
			stmt.close();
		} catch (Exception e) {
			logger.error("#### Id inexistente, por favor insira um id existente para entrar no sistema! ####"
					+ System.lineSeparator());
		}
	}
}
