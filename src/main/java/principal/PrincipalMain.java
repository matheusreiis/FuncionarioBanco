package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import bancoDeDados.BancoDeDadosFuncionario;
import bancoDeDados.CadastroAuxiliarBancoDeDados;
import bancoDeDados.CadastroEstagiarioBancoDeDados;
import bancoDeDados.CadastroGerenteBancoDeDados;
import entities.Auxiliar;
import entities.Estagiario;
import entities.Funcionario;
import entities.Gerente;

import util.CalculadoraDaBonificacaoServico;
import validadores.ValidadorDeBancoDeDados;

public class PrincipalMain {

	private final static Logger logger = Logger.getLogger(PrincipalMain.class);

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		CalculadoraDaBonificacaoServico calculadoraDaBonificacao = new CalculadoraDaBonificacaoServico();
		BancoDeDadosFuncionario bancoDeDadosFuncionario = new BancoDeDadosFuncionario();
		ValidadorDeBancoDeDados validaBanco = new ValidadorDeBancoDeDados();
		CadastroGerenteBancoDeDados cadastrarGerente = new CadastroGerenteBancoDeDados();
		CadastroAuxiliarBancoDeDados cadastrarAuxiliar = new CadastroAuxiliarBancoDeDados();
		CadastroEstagiarioBancoDeDados cadastrarEstagiario = new CadastroEstagiarioBancoDeDados();
		List<Funcionario> listaGerente = new ArrayList<>();
		List<Funcionario> listaAuxiliar = new ArrayList<>();
		List<Funcionario> listaEstagiario = new ArrayList<>();

		int loginAutenticacao = 0;
		int senhaAutenticacao = 0;

		logger.info("BEM VINDO AO SISTEMA DA EMPRESA DATACORE SOLUTIONS!" + System.lineSeparator());

		logger.debug(
				"---------- Digite o Seu Cargo ----------\n \n 1 - Gerente\n 2 - Auxiliar\n 3 - Estagiario\n 4 - Cadastrar Funcionario\n 5 - Encerrar Sessao!");

		int acaoLobby = sc.nextInt();

		for (int i = acaoLobby; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i > 5; i++) {

			if (acaoLobby == 1) {
				logger.info("---------- CONTA GERENTE ----------" + System.lineSeparator());
				logger.info(" Contas Gerente ativas:\n ");

				if (listaGerente.size() == 0) {
					bancoDeDadosFuncionario.listaDeRegistroGerente(listaGerente);
				} else {
					for (i = 0; i < listaGerente.size(); i++) {
						Gerente gerente = (Gerente) listaGerente.get(i);
						logger.info(gerente.getId() + " - " + gerente.getNome() + " " + gerente.getSobrenome());
					}
				} 		
				logger.info("Solicite um sistema Gerente para entrar: ");

				int acaoLobby2 = sc.nextInt();

				if (acaoLobby2 > 0) {
					validaBanco.validaBancoGerente(loginAutenticacao, senhaAutenticacao, listaGerente);
				}

			} else if (acaoLobby == 2) {
				logger.info("---------- CONTA AUXILIAR ----------" + System.lineSeparator());
				logger.info(" Contas Auxiliar ativas:\n ");

				if (listaAuxiliar.size() == 0) {
					bancoDeDadosFuncionario.listaDeRegistroAuxiliar(listaAuxiliar);
				} else {
					for (i = 0; i < listaAuxiliar.size(); i++) {
						Auxiliar auxiliar = (Auxiliar) listaAuxiliar.get(i);
						logger.info(auxiliar.getNome() + " " + auxiliar.getSobrenome());
					}
				}
				logger.info("Solicite um sistema Auxiliar para entrar: ");
				
				int acaoLobby2 = sc.nextInt();

				if (acaoLobby2 > 0) {
						validaBanco.validaBancoAuxiliar(loginAutenticacao, senhaAutenticacao, listaAuxiliar);
				}
			} else if (acaoLobby == 3) {
				logger.info("---------- CONTA ESTAGIARIO ----------" + System.lineSeparator());
				logger.info(" Contas Estagiario ativas:\n ");

				if (listaEstagiario.size() == 0) {
					bancoDeDadosFuncionario.listaDeRegistroEstagiario(listaEstagiario);
				} else {
					for (i = 0; i < listaEstagiario.size(); i++) {
						Estagiario estagiario = (Estagiario) listaEstagiario.get(i);
						logger.debug(estagiario.getNome() + " " + estagiario.getSobrenome());
					}
				}
				logger.info("Solicite um sistema Auxiliar para entrar: ");
				
				int acaoLobby2 = sc.nextInt();

				if (acaoLobby2 > 0) {
						validaBanco.validaBancoEstagiario(loginAutenticacao, senhaAutenticacao, listaEstagiario);
					}
			} else if (acaoLobby == 4) {

				logger.info("---------- CADASTRO DE FUNCIONARIO ----------");
				System.out.println();
				logger.debug("Digite o cargo do funcionario:\n 1.Gerente / 2.Auxiliar / 3.Estagiario ");
				int cargoCadastro = sc.nextInt();

				if (cargoCadastro == 1) {
					cadastrarGerente.cadastroGerente(listaGerente);

				} else if (cargoCadastro == 2) {
					cadastrarAuxiliar.cadastroAuxiliar(listaAuxiliar);

				} else if (cargoCadastro == 3) {
					cadastrarEstagiario.cadastroEstagiario(listaEstagiario);
				}

			} else if (acaoLobby == 5) {
				logger.info("Encerrando Sessao!" + "\n." + "\n." + "\n.");
				logger.info("Sessao Encerrada!");
				break;
			} else if (acaoLobby > 5) {
				logger.info("\n### Comando Invalido ### Por favor insira um valor valido!\n ");
				System.out.println();
			} else {
				logger.info("Login incorreto");
				System.out.println();
				logger.info("Tente novamente mais tarde.\n ");
			}
			logger.debug(
					"---------- Digite o Seu Cargo ----------\n \n 1 - Gerente\n 2 - Auxiliar\n 3 - Estagiario\n 4 - Cadastrar Funcionario\n 5 - Encerrar Sessao!");
			acaoLobby = sc.nextInt();
		}
		sc.close();
	}
}
