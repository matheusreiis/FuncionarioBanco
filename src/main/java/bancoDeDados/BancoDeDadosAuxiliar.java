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

import entities.Auxiliar;

public class BancoDeDadosAuxiliar {

	ConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDados();
	Logger logger = Logger.getLogger(BancoDeDadosGerente.class);
	NumberFormat formatter = new DecimalFormat("#0.00");
	Auxiliar auxiliar;
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

	public void listaDeRegistroAuxiliar(Auxiliar auxiliar) {

		logger.info("--------- DADOS DO AUXILIAR ---------" + System.lineSeparator());
		logger.info("ID do Auxiliar: " + auxiliar.getId());
		logger.info("Nome do Auxiliar: " + auxiliar.getNome() + " " + auxiliar.getSobrenome());
		logger.info("cpf do Auxiliar: " + auxiliar.getCpf());
		logger.info("Salario do Auxiliar: R$" + formatter.format(auxiliar.getSalario()));
		logger.info("Idade do Auxiliar: " + auxiliar.getIdade());
		logger.info("Estado Civil do Auxiliar: " + auxiliar.getEstadoCivil());
		logger.info("Login do Auxiliar: " + auxiliar.getLoginDoCadastroDoSistema());
		logger.info("Senha do Auxiliar: **************" + System.lineSeparator());
	}

	public void inserirDadosBancoAuxiliar(Auxiliar auxiliar, Connection connection) throws IOException, SQLException {

		Properties props = getProp();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.inserirDadosListaAuxiliar"));

			stmt.setString(1, auxiliar.getNome() + " " + auxiliar.getSobrenome());
			stmt.setLong(2, auxiliar.getCpf());
			stmt.setDouble(3, auxiliar.getSalario());
			stmt.setInt(4, auxiliar.getIdade());
			stmt.setString(5, auxiliar.getEstadoCivil());
			stmt.setInt(6, auxiliar.getLoginDoCadastroDoSistema());
			stmt.setInt(7, auxiliar.getSenhaDoCadastroDoSistema());
			logger.info(
					"########## Inserindo dados ao banco de dados de funcionarios ##########" + "\n." + "\n." + "\n.");

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			logger.error("Erro ao tentar adicionar dados do Auxiliar no banco de dados, por favor tente novamente!");
			throw new RuntimeException(e);
		}
		connection.close();
	}

	public void pegarDadosBancoAuxiliar(Auxiliar auxiliar, Connection connection) throws IOException, SQLException {

		Properties props = getProp();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaAuxiliar"));

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				auxiliar.setId(rs.getInt("id"));
			}
			logger.info("########## Gerando seu id automatico ##########" + "\n." + "\n." + "\n.");
			logger.info("Seu novo id do Auxiliar (use seu id para se conectar ao sistema): " + auxiliar.getId());
			stmt.close();
		} catch (Exception e) {
			logger.error("Erro ao tentar pegar dados do Auxiliar no banco de dados, por favor tente novamente!");
			throw new RuntimeException(e);
		}
	}

	public void excluirDadosBancoAuxiliar(Connection connection) throws IOException {

		Properties props = getProp();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.excluirDadosListaAuxiliar"));

			PreparedStatement stmt1 = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaAuxiliar"));
			PreparedStatement stmt2 = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaAuxiliar"));

			ResultSet rs2 = stmt2.executeQuery();
			ResultSet rs1 = stmt1.executeQuery();

			while (validaErro) {
				logger.info("Qual conta de Auxiliar deseja excluir?!");
				while (rs1.next()) {
					logger.info(rs1.getInt("id") + " - " + rs1.getString("nome"));
				}
				int acaoId = sc.nextInt();
				while (rs2.next()) {
					acaoExclusao = rs2.getInt("id");

					if (acaoId == acaoExclusao) {
						logger.info("********** AUXILIAR " + rs1.getInt("nome") + "EXCLUIDO COM SUCESSO! **********\n");
						stmt.execute();
						validaErro = false;
					}
				}
			}
			stmt.close();
			stmt1.close();
			stmt2.close();
		} catch (Exception e) {
			logger.error("Erro ao tentar excluir dados do Auxiliar no banco de dados, por favor tente novamente!");
			throw new RuntimeException(e);
		}
	}

	public void mostrarDadosBancoAuxiliar(Connection connection) throws IOException {

		Properties props = getProp();

		try {
			PreparedStatement stmt = connection
					.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaAuxiliar"));

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				logger.info(rs.getInt("id") + " - " + rs.getString("nome"));
			}
			stmt.close();
		} catch (Exception e) {
			logger.error("Erro ao tentar pegar dados do Auxiliar no banco de dados, por favor tente novamente!");
			throw new RuntimeException(e);
		}
	}
}
