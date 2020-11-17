package principal;

import java.io.FileInputStream;
import java.io.IOException;
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

		Scanner sc = new Scanner(System.in);
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

		int loginAutenticacao = 0;
		int senhaAutenticacao = 0;
		boolean validaErroCatch = true;

		logger.info("BEM VINDO AO SISTEMA DA EMPRESA DATACORE SOLUTIONS!" + System.lineSeparator());

		while (validaErroCatch) {
			logger.debug(
					"---------- Digite o Seu Cargo ----------\n \n 1 - Gerente\n 2 - Auxiliar\n 3 - Estagiario\n 4 - Cadastrar Funcionario\n 5 - Encerrar Sessao!");
			try {
				int acaoLobby = sc.nextInt();

				for (int i = acaoLobby; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i > 5; i++) {

					if (acaoLobby == 1) {
						logger.info("---------- CONTA GERENTE ----------" + System.lineSeparator());

						boolean validaErroIdGerente = true;
						while (validaErroIdGerente) {
							if (listaGerente.size() != 0) {
								bancoDeDadosGerente.listaDeRegistroGerente(listaGerente, gerente);
								validaErroIdGerente = false;
							} else {
								logger.info(" Contas Gerente ativas:\n ");
								bancoDeDadosGerente.mostrarDadosBancoGerente(gerente);
								try {
									logger.info("Solicite um sistema Gerente para entrar: ");

									int acaoLobbyGerente = sc.nextInt();

									autenticaSistema.autenticaSistemaGerente(loginAutenticacao, senhaAutenticacao,
											acaoLobbyGerente, listaGerente);
								} catch (Exception e) {
									logger.error("#### Comando invalido, por favor insira apenas numeros! ####"
											+ System.lineSeparator());
									sc.next();
									validaErroIdGerente = true;
								}
							}
						}
						break;
					} else if (acaoLobby == 2) {
						logger.info("---------- CONTA AUXILIAR ----------" + System.lineSeparator());

						boolean validaErroIdAuxiliar = true;
						while (validaErroIdAuxiliar) {
							if (listaAuxiliar.size() == 0) {
								bancoDeDadosAuxiliar.listaDeRegistroAuxiliar(listaAuxiliar, auxiliar);
								validaErroIdAuxiliar = false;
							} else {
								logger.info(" Contas Auxiliar ativas:\n ");
								bancoDeDadosAuxiliar.mostrarDadosBancoAuxiliar();

								try {
									logger.info("Solicite um sistema Auxiliar para entrar: ");

									int acaoLobbyAuxiliar = sc.nextInt();

									for (i = 0; i < listaAuxiliar.size(); i++) {
										Auxiliar auxiliar = (Auxiliar) listaAuxiliar.get(i);
										if (acaoLobbyAuxiliar == auxiliar.getId()) {
											logger.info("---------- AUTENTICANDO SISTEMA AUXILIAR ----------" + "\n."
													+ "\n." + "\n.");
											logger.info("Bem vindo(a) novamente Sr. " + auxiliar.getNome());
											validaErroIdAuxiliar = false;
										} else {
											logger.error(
													"#### Id inexistente, por favor insira um id existente para entrar no sistema! ####"
															+ System.lineSeparator());
											validaErroIdAuxiliar = true;
										}
									}
								} catch (Exception e) {
									logger.error("#### Comando invalido, por favor insira apenas numeros! ####"
											+ System.lineSeparator());
									sc.next();
									validaErroIdAuxiliar = true;
								}
							}
						}
						break;
					} else if (acaoLobby == 3) {
						logger.info("---------- CONTA ESTAGIARIO ----------" + System.lineSeparator());

						boolean validaErroIdEstagiario = true;
						while (validaErroIdEstagiario) {
							if (listaEstagiario.size() == 0) {
								bancoDeDadosEstagiario.listaDeRegistroEstagiario(listaEstagiario, estagiario);
								validaErroIdEstagiario = false;
							} else {
								logger.info(" Contas Estagiario ativas:\n ");
								bancoDeDadosAuxiliar.mostrarDadosBancoAuxiliar();
								try {
									logger.info("Solicite um sistema Estagiario para entrar: ");

									int acaoLobbyEstagiario = sc.nextInt();

									for (i = 0; i < listaGerente.size(); i++) {
										Estagiario estagiario = (Estagiario) listaEstagiario.get(i);
										if (acaoLobbyEstagiario == estagiario.getId()) {
											logger.info("---------- AUTENTICANDO SISTEMA ESTAGIARIO ----------" + "\n."
													+ "\n." + "\n.");
											logger.info("Bem vindo(a) novamente Sr. " + estagiario.getNome());
											validaErroIdEstagiario = false;
										} else {
											logger.error(
													"#### Id inexistente, por favor insira um id existente para entrar no sistema! ####"
															+ System.lineSeparator());
											validaErroIdEstagiario = true;
										}
									}
								} catch (Exception e) {
									logger.error("#### Comando invalido, por favor insira apenas numeros! ####"
											+ System.lineSeparator());
									sc.next();
									validaErroIdEstagiario = true;
								}
							}
						}
						break;
					} else if (acaoLobby == 4) {

						logger.info("---------- CADASTRO DE FUNCIONARIO ----------" + System.lineSeparator());
						logger.debug("Digite o cargo do funcionario:\n 1.Gerente / 2.Auxiliar / 3.Estagiario ");
						int cargoCadastro = sc.nextInt();

						if (cargoCadastro == 1) {
							cadastrarGerente.cadastroGerente(listaGerente);

						} else if (cargoCadastro == 2) {
							cadastrarAuxiliar.cadastroAuxiliar(listaAuxiliar);

						} else if (cargoCadastro == 3) {
							cadastrarEstagiario.cadastroEstagiario(listaEstagiario);
						}
						break;
					} else if (acaoLobby == 5) {
						logger.info("Encerrando Sessao!" + "\n." + "\n." + "\n.");
						logger.info("Sessao Encerrada!");
						System.exit(0);
					} else if (acaoLobby > 5) {
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
	}
}
