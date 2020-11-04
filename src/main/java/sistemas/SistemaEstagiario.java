package sistemas;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class SistemaEstagiario {

	private static final Logger logger = Logger.getLogger(SistemaAuxiliar.class);
	Scanner sc = new Scanner(System.in);

	public void sistemaEstagiario() {

		logger.info("\n---------- LOGIN REALIZADO COM SUCESSO ----------\n");
		logger.debug(
				"Qual acao deseja realizar?\n \n 1 - Visualizar Projetos\n 2 - Visualizar Ponto\n 3 - Dados da conta\n 4 - Banco de horas\n 5 - Calendario\n 6 - Chat Online\n 7 - Encerrar Sessao\n");

		int acaoEstagiario = sc.nextInt();

		for (int i = acaoEstagiario; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i > 8; i++) {
			if (acaoEstagiario == 1) {
				logger.info("PROJETOS EM REFORMA");
			} else if (acaoEstagiario == 2) {
				logger.info("PONTO EM REFORMA");
			} else if (acaoEstagiario == 3) {
				logger.info("DADOS DA CONTA EM REFORMA");
			} else if (acaoEstagiario == 4)  {
				logger.info("BANCO EM REFORMA");
			} else if (acaoEstagiario == 5) {
				logger.info("CALENDARIO EM REFORMA");
			} else if (acaoEstagiario == 6) {
				logger.info("CHAT EM REFORMA");
			} else if (acaoEstagiario == 7) {
				logger.info("Sessao Encerrada!");
				break;
			} else if (acaoEstagiario > 5) {
				logger.info("## ACAO NAO ENCONTRADA EM NOSSO SISTEMA, POR FAVOR DIGITE UM VALOR VALIDO ##\n");
			}
			logger.info(
					"Qual acao deseja realizar?\n \n 1 - Visualizar Projetos\n 2 - Visualizar Ponto\n 3 - Dados da conta\n 4 - Banco de horas\n 5 - Calendario\n 6 - Chat Online\n 7 - Encerrar Sessao\n");
			acaoEstagiario = sc.nextInt();
		}
	}
}
