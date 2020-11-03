package bancoDeDados;

import java.util.List;

import org.apache.log4j.Logger;

import arquivos.ArquivoDeAuxiliar;
import arquivos.ArquivoDeEstagiario;
import arquivos.ArquivoDeGerente;
import entities.Auxiliar;
import entities.Estagiario;
import entities.Funcionario;
import entities.Gerente;

public class BancoDeDadosFuncionario {

	private Logger logger = Logger.getLogger(BancoDeDadosFuncionario.class);
	ArquivoDeGerente arquivoDeGerente = new ArquivoDeGerente();
	ArquivoDeAuxiliar arquivoDeAuxiliar = new ArquivoDeAuxiliar();
	ArquivoDeEstagiario arquivoDeEstagiario = new ArquivoDeEstagiario();

	public void listaDeRegistroGerente(List<Funcionario> listaGerente) throws Exception {

		if (listaGerente.size() == 0) {
			logger.info("Nao ha Gerentes cadastrados!");
			logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
		} else {

			for (int i = 0; i < listaGerente.size(); i++) {
				Gerente gerente = (Gerente) listaGerente.get(i);

				logger.info(System.lineSeparator() + "--------- DADOS DO GERENTE ---------" + System.lineSeparator());
				logger.info("ID do Gerente: " + gerente.getId());
				logger.info("Nome do Gerente: " + gerente.getNome() + " " + gerente.getSobrenome());
				logger.info("cpf do Gerente: " + gerente.getCpf());
				logger.info("Salario do Gerente: R$ " + gerente.getSalario());
				logger.info("Idade do Gerente: " + gerente.getIdade());
				logger.info("Estado Civil do Gerente: " + gerente.getEstadoCivil());
				logger.info("Login do Gerente: " + gerente.getLoginDoCadastroDoSistema());
				logger.info("Senha do Gerente: **************" + System.lineSeparator());
			}
		}
		arquivoDeGerente.listaDeGerentesAtivos(listaGerente);
	}

	public void listaDeRegistroAuxiliar(List<Funcionario> listaAuxiliar) {

		if (listaAuxiliar.size() == 0) {
			logger.info("Nao ha funcionarios cadastrados!");
			logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
		} else {
			for (int i = 0; i < listaAuxiliar.size(); i++) {
				Auxiliar auxiliar = (Auxiliar) listaAuxiliar.get(i);

				logger.info(System.lineSeparator() + "--------- DADOS DO AUXILIAR ---------" + System.lineSeparator());
				logger.info("ID do Auxiliar: " + auxiliar.getId());
				logger.info("Nome do Auxiliar: " + auxiliar.getNome() + " " + auxiliar.getSobrenome());
				logger.info("cpf do Auxiliar: " + auxiliar.getCpf());
				logger.info("Salario do Auxiliar: R$ " + auxiliar.getSalario());
				logger.info("Idade do Auxiliar: " + auxiliar.getIdade());
				logger.info("Estado Civil do Auxiliar: " + auxiliar.getEstadoCivil());
				logger.info("Login do Auxiliar: " + auxiliar.getLoginDoCadastroDoSistema());
				logger.info("Senha do Auxiliar: **************" + System.lineSeparator());
			}
		}
	}

	public void listaDeRegistroEstagiario(List<Funcionario> listaEstagiario) {

		if (listaEstagiario.size() == 0) {
			logger.info("Nao ha funcionarios cadastrados!");
			logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
		} else {
			for (int i = 0; i < listaEstagiario.size(); i++) {
				Estagiario estagiario = (Estagiario) listaEstagiario.get(i);

				logger.info(
						System.lineSeparator() + "--------- DADOS DO ESTAGIARIO ---------" + System.lineSeparator());
				logger.info("ID do Estagiario: " + estagiario.getId());
				logger.info("Nome do Estagiario: " + estagiario.getNome() + " " + estagiario.getSobrenome());
				logger.info("cpf do Estagiario: " + estagiario.getCpf());
				logger.info("Salario do Estagiario: R$ " + estagiario.getSalario());
				logger.info("Idade do Estagiario: " + estagiario.getIdade());
				logger.info("Estado Civil do Estagiario: " + estagiario.getEstadoCivil());
				logger.info("Login do Estagiario: " + estagiario.getLoginDoCadastroDoSistema());
				logger.info("Senha do Estagiario: **************" + System.lineSeparator());
			}
		}
	}
}
