package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;
import entities.Funcionario;

public class ArquivoDeGerente {

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
		Path path = Paths.get(props.getProperty("path.arquivo.arquivoGerente"));

		try {
			
			for (Funcionario gerente : listaGerente) {
				if (!file.exists()) {
				file.createNewFile();
				}
				
				String str = gerente.getId() + " - " + gerente.getNome() + " " + gerente.getSobrenome();
				byte[] bs = str.getBytes();
				Files.write(path, bs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}