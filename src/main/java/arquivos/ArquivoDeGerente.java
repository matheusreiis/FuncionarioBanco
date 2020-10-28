package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import entities.Funcionario;

public class ArquivoDeGerente {

	private static final Logger logger = Logger.getLogger(ArquivoDeGerente.class);

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\FuncionarioBanco\\src\\main\\resources\\dados.properties");
		props.load(file);
		return props;
	}

	public void listaDeGerentesAtivos(List<Funcionario> listaGerente) throws Exception {

		Properties props = getProp();
		File file = new File(props.getProperty("path.arquivo.arquivoGerente"));

		try {
			for (Funcionario arquivos : listaGerente) {
				if (!file.exists()) {
					file.createNewFile();
				} else {
					Files.move(listaGerente, file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
