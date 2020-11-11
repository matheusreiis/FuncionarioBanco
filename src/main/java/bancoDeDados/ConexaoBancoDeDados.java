package bancoDeDados;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConexaoBancoDeDados {

	private static final Logger logger = Logger.getLogger(ConexaoBancoDeDados.class);
	String dbNome = "jdbc:mysql://localhost:3306/BancoDeDadosFuncionarios?useTimezone=true&serverTimezone=UTC";
	String root = "root";
	String senha = "123456789";

	public Connection conexaoJDBC() throws IOException {

		logger.info("---------- CONECTANDO AO BANCO DE DADOS ----------");
		try {
			return DriverManager.getConnection(dbNome, root, senha);
		} catch (SQLException e) {
			logger.fatal("Erro ao tentar se conectar ao Banco de Dados!");
			throw new RuntimeException(e);
		}
	}
}
