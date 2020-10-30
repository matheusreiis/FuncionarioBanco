package sistemas;

import java.util.List;

import org.apache.log4j.Logger;

import entities.Funcionario;

public class AutenticacaoSistema {

	private Logger logger = Logger.getLogger(AutenticacaoSistema.class);

	SistemaGerente sistemaGerente = new SistemaGerente();
	SistemaAuxiliar sistemaAuxiliar = new SistemaAuxiliar();
	SistemaEstagiario sistemaEstagiario = new SistemaEstagiario();

	public void autenticaSistemaGerente(int loginAutenticacao, int senhaAutenticacao, List<Funcionario> listaGerente) {

			for (Funcionario gerente : listaGerente) {
				if (loginAutenticacao == gerente.getLoginDoCadastroDoSistema()
						&& senhaAutenticacao == gerente.getLoginDoCadastroDoSistema()) {
					sistemaGerente.sistemaGerente();
				} else {
					logger.error("########## LOGIN INCORRETO ##########");
					logger.error("Desconectando do sistema!" +  "\n." + "\n." + "\n.");
					logger.error("Desconectado!" + System.lineSeparator());
				}
			}
		}

	public void autenticaSistemaAuxiliar(int loginAutenticacao, int senhaAutenticacao, List<Funcionario> listaAuxiliar) {

		for (Funcionario auxiliar : listaAuxiliar) {
			if (loginAutenticacao == auxiliar.getLoginDoCadastroDoSistema()
					&& senhaAutenticacao == auxiliar.getLoginDoCadastroDoSistema()) {
				sistemaAuxiliar.sistemaAuxiliar();
			} else {
				logger.error("########## LOGIN INCORRETO ##########");
				logger.error("Desconectando do sistema!" +  "\n." + "\n." + "\n.");
				logger.error("Desconectado!" + System.lineSeparator());
			}
		}
	}

	public void autenticaSistemaEstagiario(int loginAutenticacao, int senhaAutenticacao, List<Funcionario> listaEstagiario) {

		for (Funcionario estagiario : listaEstagiario) {
			if (loginAutenticacao == estagiario.getLoginDoCadastroDoSistema()
					&& senhaAutenticacao == estagiario.getSenhaDoCadastroDoSistema()) {
				sistemaEstagiario.sistemaEstagiario();
			} else {
				logger.error("########## LOGIN INCORRETO ##########");
				logger.error("Desconectando do sistema!" +  "\n." + "\n." + "\n.");
				logger.error("Desconectado!" + System.lineSeparator());
			}
		}
	}
}
