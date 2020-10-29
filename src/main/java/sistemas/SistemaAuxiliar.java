package sistemas;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class SistemaAuxiliar {

	private static final Logger logger = Logger.getLogger(SistemaAuxiliar.class);
	Scanner sc = new Scanner(System.in);

	public void sistemaAuxiliar() {

		logger.info("\n---------- LOGIN REALIZADO COM SUCESSO ----------\n");
		logger.debug(
				"Qual acao deseja realizar?\n 1 - Visualizar Projetos\n 2 - Cronograma\n 3 - Anotacoes\n 4 - Calendario\n 5 - Encerrar Sessao\n");

		int acaoAuxiliar = sc.nextInt();

		for (int i = acaoAuxiliar; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i > 5; i++) {
			if (acaoAuxiliar == 1) {
				logger.info("PROJETOS EM REFORMA");
			} else if (acaoAuxiliar == 2) {
				logger.info("CRONOGRAMA EM REFORMA");
			} else if (acaoAuxiliar == 3) {
				logger.info("ANOTAÇÕES EM REFORMA");
			} else if (acaoAuxiliar == 4) {
				logger.info("CALENDARIO EM REFORMA");
			} else if (acaoAuxiliar == 5) {
				logger.info("Sessao Encerrada!");
				break;
			} else if (acaoAuxiliar > 5) {
				logger.info("## ACAO NAO ENCONTRADA EM NOSSO SISTEMA, POR FAVOR DIGITE UM VALOR VALIDO ##\n");
			}
		}
	}
}
