package bancoDeDados;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConexaoBancoDeDados {

	private static final Logger logger = Logger.getLogger(ConexaoBancoDeDados.class);

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\TesteJDBC\\src\\main\\resources\\config.properties");
		props.load(file);
		return props;
	}

	public Connection conexaoJDBC() throws IOException {

//		Properties prop = getProp();

		logger.info("---------- CONEXAO JDBC ----------");
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useTimezone=true&serverTimezone=UTC",
					"root", "123456789");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
}
