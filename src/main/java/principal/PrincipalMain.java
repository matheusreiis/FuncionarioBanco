package principal;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;

import bancoDeDados.BancoDeDadosAuxiliar;
import bancoDeDados.BancoDeDadosEstagiario;
import bancoDeDados.BancoDeDadosGerente;
import bancoDeDados.CadastroAuxiliarBancoDeDados;
import bancoDeDados.CadastroEstagiarioBancoDeDados;
import bancoDeDados.CadastroGerenteBancoDeDados;
import bancoDeDados.ConexaoBancoDeDados;
import entities.Auxiliar;
import entities.Estagiario;
import entities.Funcionario;
import entities.Gerente;
import sistemas.AutenticacaoSistema;
//import util.CalculadoraDaBonificacaoServico;

public class PrincipalMain {

	private final static Logger logger = Logger.getLogger(PrincipalMain.class);
	static Gerente gerente;
	static Auxiliar auxiliar;
	static Estagiario estagiario;

	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\DataCore\\eclipse-workspace\\FuncionarioBanco\\src\\main\\resources\\dados.properties");
		props.load(file);
		return props;
	}

	public static void main(String[] args) throws Exception {

		ConexaoBancoDeDados conexaoBancoDeDados = new ConexaoBancoDeDados();
		Connection connection = conexaoBancoDeDados.conexaoJDBC();

		Scanner sc = new Scanner(System.in);
		Properties props = getProp();
//		CalculadoraDaBonificacaoServico calculadoraDaBonificacao = new CalculadoraDaBonificacaoServico();
		CadastroGerenteBancoDeDados cadastrarGerente = new CadastroGerenteBancoDeDados();
		CadastroAuxiliarBancoDeDados cadastrarAuxiliar = new CadastroAuxiliarBancoDeDados();
		CadastroEstagiarioBancoDeDados cadastrarEstagiario = new CadastroEstagiarioBancoDeDados();
		AutenticacaoSistema autenticaSistema = new AutenticacaoSistema();
		BancoDeDadosGerente bancoDeDadosGerente = new BancoDeDadosGerente();
		BancoDeDadosAuxiliar bancoDeDadosAuxiliar = new BancoDeDadosAuxiliar();
		BancoDeDadosEstagiario bancoDeDadosEstagiario = new BancoDeDadosEstagiario();
		List<Funcionario> listaGerente = new ArrayList<>();
		List<Funcionario> listaAuxiliar = new ArrayList<>();
		List<Funcionario> listaEstagiario = new ArrayList<>();
		PreparedStatement stmtGerente = connection
				.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaGerente"));
		PreparedStatement stmtAuxiliar = connection
				.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaAuxiliar"));
		PreparedStatement stmtEstagiario = connection
				.prepareStatement(props.getProperty("path.bancoDeDados.pegarDadosListaEstagiario"));

		int loginAutenticacao = 0;
		int senhaAutenticacao = 0;
		boolean validaErroCatch = true;

		logger.info("BEM VINDO AO SISTEMA DA EMPRESA DATACORE SOLUTIONS!" + System.lineSeparator());

		while (validaErroCatch) {
			logger.debug(
					"---------- Digite o Seu Cargo ----------\n \n 1 - Gerente\n 2 - Auxiliar\n 3 - Estagiario\n 4 - Cadastrar Funcionario\n 5 - Excluir Funcionario\n 6 - Encerrar Sessao!");
			try {
				int acaoLobby = sc.nextInt();

				for (int i = acaoLobby; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i > 7; i++) {

					if (acaoLobby == 1) {
						logger.info("---------- CONTA GERENTE ----------" + System.lineSeparator());

						boolean validaErroGerente = true;
						while (validaErroGerente) {
							ResultSet rsGerente = stmtGerente.executeQuery();
							if (rsGerente.next() == false && listaGerente.size() == 0) {
								logger.info("Nao ha Gerentes cadastrados!");
								logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
								validaErroGerente = false;
							} else {
								try {
									logger.info(" Contas Gerentes ativas:\n ");
									bancoDeDadosGerente.mostrarDadosBancoGerente(connection);
									logger.info("Solicite um sistema Gerente para entrar: ");

									int acaoLobbyGerente = sc.nextInt();

									autenticaSistema.autenticaSistemaGerente(loginAutenticacao, senhaAutenticacao,
											acaoLobbyGerente, listaGerente, connection);
									validaErroGerente = false;
								} catch (Exception e) {
									logger.error("#### Comando invalido, por favor insira apenas numeros! ####"
											+ System.lineSeparator());
									sc.next();
									validaErroGerente = true;
								}
							}
							rsGerente.close();
						}
						break;
					} else if (acaoLobby == 2) {
						logger.info("---------- CONTA AUXILIAR ----------" + System.lineSeparator());

						boolean validaErroAuxiliar = true;
						while (validaErroAuxiliar) {
							ResultSet rsAuxiliar = stmtAuxiliar.executeQuery();
							if (rsAuxiliar.next() == false && listaAuxiliar.size() == 0) {
								logger.info("Nao ha Auxiliares cadastrados!");
								logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
								validaErroAuxiliar = false;
							} else {
								try {
									logger.info(" Contas Auxiliar ativas:\n ");
									bancoDeDadosAuxiliar.mostrarDadosBancoAuxiliar(connection);
									logger.info("Solicite um sistema Auxiliar para entrar: ");

									int acaoLobbyAuxiliar = sc.nextInt();

									autenticaSistema.autenticaSistemaAuxiliar(loginAutenticacao, senhaAutenticacao,
											acaoLobbyAuxiliar, listaAuxiliar);
									validaErroAuxiliar = false;
								} catch (Exception e) {
									logger.error("#### Comando invalido, por favor insira apenas numeros! ####"
											+ System.lineSeparator());
									sc.next();
									validaErroAuxiliar = true;
								}
							}
							rsAuxiliar.close();
						}
						break;
					} else if (acaoLobby == 3) {
						logger.info("---------- CONTA ESTAGIARIO ----------" + System.lineSeparator());

						boolean validaErroEstagiario = true;
						while (validaErroEstagiario) {
							ResultSet rsEstagiario = stmtEstagiario.executeQuery();
							if (rsEstagiario.next() == false && listaEstagiario.size() == 0) {
								logger.info("Nao ha Estagiarios cadastrados!");
								logger.info("Retornando ao lobby." + "\n." + "\n." + "\n.");
								validaErroEstagiario = false;
							} else {
								try {
									logger.info(" Contas Estagiario ativas:\n ");
									bancoDeDadosAuxiliar.mostrarDadosBancoAuxiliar(connection);
									logger.info("Solicite um sistema Estagiario para entrar: ");

									int acaoLobbyEstagiario = sc.nextInt();

									autenticaSistema.autenticaSistemaEstagiario(loginAutenticacao, senhaAutenticacao,
											acaoLobbyEstagiario, listaEstagiario);
									validaErroEstagiario = false;
								} catch (Exception e) {
									logger.error("#### Comando invalido, por favor insira apenas numeros! ####"
											+ System.lineSeparator());
									sc.next();
									validaErroEstagiario = true;
								}
							}
							rsEstagiario.close();
						}
						break;
					} else if (acaoLobby == 4) {

						logger.info("---------- CADASTRO DE FUNCIONARIO ----------" + System.lineSeparator());
						logger.debug("Digite o cargo do funcionario:\n 1.Gerente / 2.Auxiliar / 3.Estagiario ");
						int cargoCadastro = sc.nextInt();

						if (cargoCadastro == 1) {
							cadastrarGerente.cadastroGerente(listaGerente, connection);

						} else if (cargoCadastro == 2) {
							cadastrarAuxiliar.cadastroAuxiliar(listaAuxiliar, connection);

						} else if (cargoCadastro == 3) {
							cadastrarEstagiario.cadastroEstagiario(listaEstagiario, connection);
						}
						break;
					} else if (acaoLobby == 5) {

						logger.info("---------- EXCLUSAO DE FUNCIONARIO ----------" + System.lineSeparator());
						logger.debug("Digite o cargo do funcionario:\n 1.Gerente / 2.Auxiliar / 3.Estagiario ");
						int cargoExclusao = sc.nextInt();

						if (cargoExclusao == 1) {
							bancoDeDadosGerente.excluirDadosBancoGerente(connection);

						} else if (cargoExclusao == 2) {
							bancoDeDadosAuxiliar.excluirDadosBancoAuxiliar(connection);

						} else if (cargoExclusao == 3) {
							bancoDeDadosEstagiario.excluirDadosBancoEstagiario(connection);

						}
						break;
					} else if (acaoLobby == 6) {
						logger.info("Encerrando Sessao!" + "\n." + "\n." + "\n.");
						logger.info("Sessao Encerrada!");
						System.exit(0);
					} else if (acaoLobby > 6) {
						logger.error("\n### Comando Invalido ### Por favor insira um valor valido! "
								+ System.lineSeparator());
						break;
					}
				}
			} catch (Exception e) {
				logger.error("##### Erro! Reconectando ao sistema ##### " + "\n." + "\n." + "\n.");
				logger.info("Sistema reconectado!");
				sc.nextLine();
				validaErroCatch = true;
			}
		}
		sc.close();
		stmtGerente.close();
		stmtAuxiliar.close();
		stmtEstagiario.close();
	}
}