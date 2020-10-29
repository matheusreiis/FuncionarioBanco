package sistemas;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class SistemaGerente {

	private static final Logger logger = Logger.getLogger(SistemaGerente.class);
	Scanner sc = new Scanner(System.in);

	public void sistemaGerente() {

		logger.info("\n---------- LOGIN REALIZADO COM SUCESSO ----------\n");
		logger.debug(
				"Qual acao deseja realizar?\n \n1 - Visualizar Projetos\n 2 - Visualizar Ponto\n 3 - Banco de horas\n 4 - Calendario\n 5 - Chat Online\n 6 - Encerrar Sessao\n");
		int acaoGerente = sc.nextInt();

		for (int i = acaoGerente; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i > 5; i++) {
			if (acaoGerente == 1) {
				logger.info("PROJETOS EM REFORMA");
			} else if (acaoGerente == 2) {
				logger.info("PONTO DE REFORMA");
			} else if (acaoGerente == 3) {
				logger.info("BANCO DE DADOS EM REFORMA");
			} else if (acaoGerente == 4) {
				logger.info("CALENDARIO EM REFORMA");
			} else if (acaoGerente == 5) {
				logger.info("CHAT EM REFORMA");
			} else if (acaoGerente == 6) {
				logger.info("Sessao Finalizada!");
				break;
			} else if (acaoGerente > 6) {
				logger.info("## ACAO NAO ENCONTRADA EM NOSSO SISTEMA, POR FAVOR DIGITE UM VALOR VALIDO ##\n");
			}

			logger.info(
					"Qual acao deseja realizar?\n 1 - Visualizar Projetos\n 2 - Visualizar Ponto\n 3 - Banco de horas\n 4 - Calendario\n 5 - Chat Online\n 6 - Encerrar Sessao\n");
			acaoGerente = sc.nextInt();
		}
	}
}
