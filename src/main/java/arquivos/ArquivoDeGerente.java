package arquivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import bancoDeDados.BancoDeDadosFuncionario;
import entities.Funcionario;
import entities.Gerente;

public class ArquivoDeGerente {

	BancoDeDadosFuncionario bancoDeDadosFuncionario = new BancoDeDadosFuncionario();

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\FuncionarioBanco\\src\\main\\resources\\dados.properties");
		props.load(file);
		return props;
	}

	public void listaDeGerentesAtivos(List<Funcionario> listaGerente, Gerente gerente) throws Exception {

		Properties props = getProp();
		File file = new File(props.getProperty("path.arquivo.arquivoGerente"));
		Path path = Paths.get(props.getProperty("path.arquivo.arquivoGerente"));

		if (!file.exists()) {
			file.createNewFile();
		}
		
		
		
		
		

//		FileWriter fw = new FileWriter(file.getAbsoluteFile());
//		BufferedWriter bw = new BufferedWriter(fw);
//		bw.write(gerente.getId() + " - " + gerente.getNome());

//		bw.flush();
//		bw.close();
	}
}