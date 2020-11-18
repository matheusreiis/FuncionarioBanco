package validadores;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import bancoDeDados.ConexaoBancoDeDados;
import interfaces.IValidadorDeCpf;

public class ValidadorDeCpf implements IValidadorDeCpf {

	ConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDados();
	private static final Logger logger = Logger.getLogger(ValidadorDeCpf.class);
	Scanner sc = new Scanner(System.in);
	Long cpfBanco = (long) 0;

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\FuncionarioBanco\\src\\main\\resources\\dados.properties");
		props.load(file);
		return props;
	}

	public long validaCpf(long cpf, String mensagemCpf) throws IOException, SQLException {

		Properties props = getProp();
		Connection connection = conexaoBancoDeDados.conexaoJDBC();

		boolean validaErroCatch = true;
		while (validaErroCatch) {
			validaErroCatch = false;
			try {
				PreparedStatement stmt = connection
						.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaGerente"));

				cpf = sc.nextLong();
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					cpfBanco = rs.getLong("CPF");
				} 
					if (cpf != cpfBanco) {
						String valueOf = "";
						valueOf = extracted(cpf);
						while (valueOf.length() != 11) {
							logger.debug("##### Por favor insira 11 digitos para validar seu cpf #####"
									+ System.lineSeparator());
							logger.info(mensagemCpf);
							valueOf = extracted(cpf);
							validaErroCatch = true;
							break;
						}
					} else {
						logger.error("##### CPF JÁ EXISTENTE ##### Por favor utilize outro CPF para cadastro! "
								+ System.lineSeparator());
						sc.nextLine();
						logger.info(mensagemCpf);
						validaErroCatch = true;
					}
				stmt.close();
			} catch (InputMismatchException e) {
				logger.error("##### CPF INVALIDO ##### " + System.lineSeparator());
				sc.nextLine();
				logger.info(mensagemCpf);
				validaErroCatch = true;
			}
		}
		return cpf;
	}

	private String extracted(long cpf) {
		String valueOf;
		valueOf = String.valueOf(cpf);
		valueOf.length();
		return valueOf;
	}
}
