package sistemas;

import java.util.List;

import org.apache.log4j.Logger;

import entities.Funcionario;

public class AutenticacaoSistema {

	private Logger logger = Logger.getLogger(AutenticacaoSistema.class);

	SistemaGerente sistemaGerente = new SistemaGerente();

	public void autenticaSistemaGerente(int loginAutenticacao, int senhaAutenticacao, List<Funcionario> listaGerente) {

		for (Funcionario gerente : listaGerente) {

			if (loginAutenticacao == gerente.getLoginDoCadastroDoSistema()
					&& senhaAutenticacao == gerente.getLoginDoCadastroDoSistema()) {
				sistemaGerente.sistemaGerente();
			} else {
				logger.error("########## LOGIN INCORRETO ##########");
			}
		}
	}
}
