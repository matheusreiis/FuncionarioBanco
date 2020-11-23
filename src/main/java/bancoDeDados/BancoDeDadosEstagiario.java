package bancoDeDados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import entities.Estagiario;

public class BancoDeDadosEstagiario {

	Logger logger = Logger.getLogger(BancoDeDadosGerente.class);
	ConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDados();
	NumberFormat formatter = new DecimalFormat("#0.00");
	Estagiario estagiario;
	Scanner sc = new Scanner(System.in);
	boolean validaErro = true;
	int acaoExclusao;

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\FuncionarioBanco\\src\\main\\resources\\dados.properties");
		props.load(file);
		return props;
	}

	public void listaDeRegistroEstagiario(Estagiario estagiario) {

		logger.info("--------- DADOS DO ESTAGIARIO ---------" + System.lineSeparator());
		logger.info("ID do Estagiario: " + estagiario.getId());
		logger.info("Nome do Estagiario: " + estagiario.getNome() + " " + estagiario.getSobrenome());
		logger.info("cpf do Estagiario: " + estagiario.getCpf());
		logger.info("Salario do Estagiario: R$" + formatter.format(estagiario.getSalario()));
		logger.info("Idade do Estagiario: " + estagiario.getIdade());
		logger.info("Estado Civil do Estagiario: " + estagiario.getEstadoCivil());
		logger.info("Login do Estagiario: " + estagiario.getLoginDoCadastroDoSistema());
	}

	public void inserirDadosBancoEstagiario(Estagiario estagiario, Connection connection)
			throws IOException, SQLException {

		Properties props = getProp();

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

	public void pegarDadosBancoEstagiario(Estagiario estagiario, Connection connection)
			throws IOException, SQLException {

		Properties props = getProp();

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

	public void excluirDadosBancoEstagiario(Connection connection) throws IOException {

		Properties props = getProp();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.excluirDadosListaEstagiario"));

			PreparedStatement stmt1 = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaEstagiario"));
			PreparedStatement stmt2 = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaEstagiario"));

			ResultSet rs2 = stmt2.executeQuery();
			ResultSet rs1 = stmt1.executeQuery();

			while (validaErro) {
				logger.info("Qual conta de Estagiario deseja excluir?!");
				while (rs1.next()) {
					logger.info(rs1.getInt("id") + " - " + rs1.getString("nome"));
				}
				int acaoId = sc.nextInt();
				while (rs2.next()) {
					acaoExclusao = rs2.getInt("id");

					if (acaoId == acaoExclusao) {
						stmt.setInt(1, rs2.getInt("int"));
						logger.info("********** ESTAGIARIO " + rs1.getString("nome").toString().toUpperCase()
								+ "EXCLUIDO(A) COM SUCESSO! **********\n");
						stmt.execute();
						validaErro = false;
					}
				}
			}
			stmt.close();
			stmt1.close();
			stmt2.close();
		} catch (Exception e) {
			logger.error("Erro ao tentar excluir dados do Estagiario no banco de dados, por favor tente novamente!");
			throw new RuntimeException(e);
		}
	}

	public void mostrarDadosBancoEstagiario(Connection connection) throws IOException {

		Properties props = getProp();

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
