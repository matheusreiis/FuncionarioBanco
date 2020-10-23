package arquivos;

import java.io.IOException;
import java.util.List;

import bancoDeDados.BancoDeDadosFuncionario;
import entities.Funcionario;

public class SalvaDadosDeArquivo {

	BancoDeDadosFuncionario bancoDeDadosFuncionario = new BancoDeDadosFuncionario();

	public void salvaDados(BancoDeDadosFuncionario bancoEvento) throws IOException {

		List<Funcionario> listaGerente = bancoEvento.listaDeRegistroGerente("ListaContas");
		RepositorioDeContas repositorio = new RepositorioDeContas();
		repositorio.salva(listaGerente);
	}
}
