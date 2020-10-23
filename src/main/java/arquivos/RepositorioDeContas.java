package arquivos;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import entities.Funcionario;

public class RepositorioDeContas {

	public void salva(List<Funcionario> listaGerente) throws FileNotFoundException {
		 PrintStream stream = new PrintStream("contas.txt");
	      for (Funcionario gerente1 : listaGerente) {
	          stream.println(gerente1.getNome() + " " + gerente1.getSobrenome());
	      }
	      stream.close();
	  }
}
