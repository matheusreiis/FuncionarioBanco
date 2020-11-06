package bancoDeDados;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import entities.Auxiliar;
import entities.Estagiario;
import entities.Funcionario;
import entities.Gerente;

public class BancoDeDadosFuncionario {

	private Logger logger = Logger.getLogger(BancoDeDadosFuncionario.class);
	Scanner sc = new Scanner(System.in);
	NumberFormat formatter = new DecimalFormat("#0.00");
	
	Gerente gerente;
	Auxiliar auxiliar;
	Estagiario estagiario;
	
	public void listaDeRegistroGerente(List<Funcionario> listaGerente, Gerente gerente) {

		if (listaGerente.size() == 0) {
			logger.info("Nao ha Gerentes cadastrados!");
			logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
		} else {		
				logger.info("--------- DADOS DO GERENTE ---------" + System.lineSeparator());
				logger.info("ID do Gerente: " + gerente.getId());
				logger.info("Nome do Gerente: " + gerente.getNome() + " " + gerente.getSobrenome());
				logger.info("cpf do Gerente: " + gerente.getCpf());
				logger.info("Salario do Gerente: R$" + formatter.format(gerente.getSalario()));
				logger.info("Idade do Gerente: " + gerente.getIdade());
				logger.info("Estado Civil do Gerente: " + gerente.getEstadoCivil());
				logger.info("Login do Gerente: " + gerente.getLoginDoCadastroDoSistema());
				logger.info("Senha do Gerente: **************" + System.lineSeparator());
		}
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

	public void listaDeRegistroEstagiario(List<Funcionario> listaEstagiario, Estagiario estagiario) {

		if (listaEstagiario.size() == 0) {
			logger.info("Nao ha Estagiarios cadastrados!");
			logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
		} else {
			logger.info("--------- DADOS DO ESTAGIARIO ---------" + System.lineSeparator());
			logger.info("ID do Estagiario: " + estagiario.getId());
			logger.info("Nome do Estagiario: " + estagiario.getNome() + " " + estagiario.getSobrenome());
			logger.info("cpf do Estagiario: " + estagiario.getCpf());
			logger.info("Salario do Estagiario: R$" + formatter.format(estagiario.getSalario()));
			logger.info("Idade do Estagiario: " + estagiario.getIdade());
			logger.info("Estado Civil do Estagiario: " + estagiario.getEstadoCivil());
			logger.info("Login do Estagiario: " + estagiario.getLoginDoCadastroDoSistema());
			logger.info("Senha do Estagiario: **************" + System.lineSeparator());
		}
	}
}
