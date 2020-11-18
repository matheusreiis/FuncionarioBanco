package bancoDeDados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import entities.Estagiario;
import entities.Funcionario;

public class BancoDeDadosEstagiario {

	Logger logger = Logger.getLogger(BancoDeDadosGerente.class);
	ConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDados();
	NumberFormat formatter = new DecimalFormat("#0.00");
	Estagiario estagiario;

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\FuncionarioBanco\\src\\main\\resources\\dados.properties");
		props.load(file);
		return props;
	}

	public void listaDeRegistroEstagiario(List<Funcionario> listaEstagiario, Estagiario estagiario) {

		if (listaEstagiario.size() == 0) {
			logger.info("Nao ha Estagiarios cadastrados!");
			logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
		} else {
			logger.info("--------- DADOS DO ESTAGIARIO ---------" + System.lineSeparator());
			logger.info("ID do Estagiario: " + estagiario.getId());
			logger.info("Nome do Estagiario: " + estagiario.getNome() + " " + estagiario.getSobrenome());
			logger.info("cpf do Estagiario: " + estagiario.getCpf());
			logger.info("Salario do Estagiario: R$" + formatter.format(estagiario.getSalario()));
			logger.info("Idade do Estagiario: " + estagiario.getIdade());
			logger.info("Estado Civil do Estagiario: " + estagiario.getEstadoCivil());
			logger.info("Login do Estagiario: " + estagiario.getLoginDoCadastroDoSistema());
			logger.info("Senha do Estagiario: **************" + System.lineSeparator());
		}
	}

	public void inserirDadosBancoEstagiario(Estagiario estagiario) throws IOException, SQLException {

		Properties props = getProp();

		Connection connection = new ConexaoBancoDeDados().conexaoJDBC();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.inserirDadosListaEstagiario"));

			stmt.setString(1, estagiario.getNome() + " " + estagiario.getSobrenome());
			stmt.setLong(2, estagiario.getCpf());
			stmt.setDouble(3, estagiario.getSalario());
			stmt.setInt(4, estagiario.getIdade());
			stmt.setString(5, estagiario.getEstadoCivil());
			stmt.setInt(6, estagiario.getLoginDoCadastroDoSistema());
			stmt.setInt(7, estagiario.getSenhaDoCadastroDoSistema());
			logger.info(
					"########## Inserindo dados ao banco de dados de funcionarios ##########" + "\n." + "\n." + "\n.");

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			logger.error("Erro ao tentar adicionar dados do Estagiario no banco de dados, por favor tente novamente!");
			throw new RuntimeException(e);
		}
		connection.close();
	}

	public void pegarDadosBancoEstagiario(Estagiario estagiario) throws IOException, SQLException {

		Properties props = getProp();
		Connection connection = conexaoBancoDeDados.conexaoJDBC();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaEstagiario"));

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				estagiario.setId(rs.getInt("id"));
			}
			logger.info("########## Gerando seu id automatico ##########" + "\n." + "\n." + "\n.");
			logger.info("Seu novo id do Estagiario (use seu id para se conectar ao sistema): " + estagiario.getId());
			stmt.close();
		} catch (Exception e) {
			logger.error("Erro ao tentar pegar dados do Estagiario no banco de dados, por favor tente novamente!");
			throw new RuntimeException(e);
		}
	}

	public void excluirDadosBancoEstagiario() throws IOException {

		Properties props = getProp();
		Connection connection = conexaoBancoDeDados.conexaoJDBC();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.excluirDadosListaEstagiario"));
			
			ResultSet rs = stmt.executeQuery();
			
			

		} catch (Exception e) {

		}
	}

	public void mostrarDadosBancoEstagiario() throws IOException {

		Properties props = getProp();
		Connection connection = conexaoBancoDeDados.conexaoJDBC();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaEstagiario"));

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				logger.info(rs.getInt("id") + " - " + rs.getString("nome"));
			}
			stmt.close();
		} catch (Exception e) {
			logger.error("Erro ao tentar pegar dados do Estagiario no banco de dados, por favor tente novamente!");
			throw new RuntimeException(e);
		}
	}

}
