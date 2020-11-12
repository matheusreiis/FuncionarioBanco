package bancoDeDados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import entities.Auxiliar;
import entities.Funcionario;

public class BancoDeDadosAuxiliar {

	Logger logger = Logger.getLogger(BancoDeDadosGerente.class);
	NumberFormat formatter = new DecimalFormat("#0.00");
	Auxiliar auxiliar;

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\FuncionarioBanco\\src\\main\\resources\\dados.properties");
		props.load(file);
		return props;
	}

	public void listaDeRegistroAuxiliar(List<Funcionario> listaAuxiliar, Auxiliar auxiliar) {

		if (listaAuxiliar.size() == 0) {
			logger.info("Nao ha Auxiliares cadastrados!");
			logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
		} else {
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
	}

	public void inserirDadosBancoAuxiliar(List<Funcionario> listaAuxiliar, Auxiliar auxiliar) throws IOException, SQLException {

		Properties props = getProp();

		Connection connection = new ConexaoBancoDeDados().conexaoJDBC();

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
}
