package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Auxiliar auxiliar1 = new Auxiliar();
		Estagiario estagiario1 = new Estagiario();
		CalculadoraDaBonificacaoServico calculadoraDaBonificacao = new CalculadoraDaBonificacaoServico();
		BancoDeDadosFuncionario bancoDeDadosFuncionario = new BancoDeDadosFuncionario();
		ValidadorDeBancoDeDados validaBanco = new ValidadorDeBancoDeDados();
		CadastroGerenteBancoDeDados cadastrarGerente = new CadastroGerenteBancoDeDados();
		CadastroAuxiliarBancoDeDados cadastrarAuxiliar = new CadastroAuxiliarBancoDeDados();
		CadastroEstagiarioBancoDeDados cadastrarEstagiario = new CadastroEstagiarioBancoDeDados();
		List<Funcionario> listaGerente = new ArrayList<Funcionario>();
		List<Funcionario> listaAuxiliar = new ArrayList<Funcionario>();
		List<Funcionario> listaEstagiario = new ArrayList<Funcionario>();


		System.out.println("\n BEM VINDO AO SISTEMA DA EMPRESA DATACORE SOLUTIONS!");
		System.out.println();
		// boolean validaBotaoVoltar = true;
		// char botaoVoltar = 0;

		System.out.println(
				"---------- Digite o Seu Cargo ----------\n \n 1 - Gerente\n 2 - Auxiliar\n 3 - Estagiario\n 4 - Cadastrar Funcionario\n 5 - Encerrar Sessao!");

		int acao1 = sc.nextInt();

		for (int i = acao1; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i > 5; i++) {

			if (acao1 == 1) {
				System.out.println("---------- CONTA GERENTE ----------");
				System.out.println();
				System.out.println(" Contas Gerente:\n ");
				if (listaGerente.size() == 0) {
					bancoDeDadosFuncionario.listaDeRegistroGerente(listaGerente);
				} 
				for (i = 0; i < listaGerente.size(); i++) {
					Gerente gerente1 = (Gerente) listaGerente.get(i);
					System.out.println("1 - " + gerente1.getNome() + " " + gerente1.getSobrenome());
				}
				/*
				 * while (listaGerente.size() == 0 && botaoVoltar != 'V') {
				 * System.out.println("VOLTAR (V)"); botaoVoltar = sc.next().charAt(0); } if
				 * (botaoVoltar == 'V') { validaBotaoVoltar = true; }
				 */
				System.out.print("Solicite um sistema Gerente para entrar: ");
				int acao2 = sc.nextInt();

				if (acao2 == 1) {
					//for (i = 0; i < listaGerente.size(); i++) {
						//Gerente gerente1 = (Gerente) listaGerente.get(i);
						//System.out.println(
								//"\nBem vindo novamente Sr. " + gerente1.getNome() + " " + gerente1.getSobrenome());
					//}
					System.out.println();
					int loginAutenticacao = 0;
					int senhaAutenticacao = 0;
					String mensagemDeLogin = "Digite seu login: ";
					String mensagemDeSenha = "Digite sua senha: ";
					validaBanco.validaBancoGerente(mensagemDeLogin, mensagemDeSenha);
					System.out.println();

					int loginCadastro = 0;
					int senhaCadastro = 0;

					if (loginAutenticacao == loginCadastro && senhaAutenticacao == senhaCadastro) {

						System.out.println("\n---------- LOGIN REALIZADO COM SUCESSO ----------\n");
						System.out.println(
								"Qual acao deseja realizar?\n \n1 - Visualizar Projetos\n 2 - Visualizar Ponto\n 3 - Banco de horas\n 4 - Calendario\n 5 - Chat Online\n 6 - Encerrar Sessao\n");
						int acaoGerente = sc.nextInt();

						for (i = acaoGerente; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i > 5; i++) {
							if (acaoGerente == 1) {
								System.out.println("PROJETOS EM REFORMA");
							} else if (acaoGerente == 2) {
								System.out.println("PONTO DE REFORMA");
							} else if (acaoGerente == 3) {
								System.out.println("BANCO DE DADOS EM REFORMA");
							} else if (acaoGerente == 4) {
								System.out.println("CALENDARIO EM REFORMA");
							} else if (acaoGerente == 5) {
								System.out.println("CHAT EM REFORMA");
							} else if (acaoGerente == 6) {
								System.out.println("Sessao Finalizada!");
								break;
							} else if (acaoGerente > 6) {
								System.out.println(
										"## ACAO NAO ENCONTRADA EM NOSSO SISTEMA, POR FAVOR DIGITE UM VALOR VALIDO ##\n");
							}

							System.out.println(
									"Qual acao deseja realizar?\n 1 - Visualizar Projetos\n 2 - Visualizar Ponto\n 3 - Banco de horas\n 4 - Calendario\n 5 - Chat Online\n 6 - Encerrar Sessao\n");
							acaoGerente = sc.nextInt();
						}
					}
				}

			} else if (acao1 == 2) {
				System.out.println("---------- CONTA AUXILIAR ----------");
				System.out.println();
				System.out.println(
						" Contas Auxiliar:\n " + "1 - " + auxiliar1.getNome() + " " + auxiliar1.getSobrenome());

				int acao2 = sc.nextInt();

				if (acao2 == 1) {

					System.out.println(
							"\n Bem vindo novamente Sr. " + auxiliar1.getNome() + " " + auxiliar1.getSobrenome());
					System.out.println();
					System.out.print("Digite seu login: ");
					String validacaoDoSistema = sc.next();
					// auxiliar1.setValidacaoDoSistema(validacaoDoSistema);
					System.out.print("Digite sua senha: ");
					validacaoDoSistema = sc.next();
					// auxiliar1.setValidacaoDoSistema(validacaoDoSistema);
					System.out.println();

					String mensagem = "";

					int a = 0;
					int b = 0;
					if (a > b) {
						System.out.println("\n---------- LOGIN REALIZADO COM SUCESSO ----------\n");
						System.out.println(
								"Qual acao deseja realizar?\n 1 - Visualizar Projetos\n 2 - Cronograma\n 3 - Anotacoes\n 4 - Calendario\n 5 - Encerrar Sessao\n");

						int acaoAuxiliar = sc.nextInt();

						for (i = acaoAuxiliar; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i > 5; i++) {
							if (acaoAuxiliar == 1) {
								System.out.println("PROJETOS EM REFORMA");
							} else if (acaoAuxiliar == 2) {
								System.out.println("CRONOGRAMA EM REFORMA");
							} else if (acaoAuxiliar == 3) {
								System.out.println("ANOTAÇÕES EM REFORMA");
							} else if (acaoAuxiliar == 4) {
								System.out.println("CALENDARIO EM REFORMA");
							} else if (acaoAuxiliar == 5) {
								System.out.println("Sessao Encerrada!");
								break;
							} else if (acaoAuxiliar > 5) {
								System.out.println(
										"## ACAO NAO ENCONTRADA EM NOSSO SISTEMA, POR FAVOR DIGITE UM VALOR VALIDO ##\n");
							}
						}
					}
				}
			} else if (acao1 == 3) {
				System.out.println("---------- CONTA ESTAGIARIO ----------");
				System.out.println();
				System.out.println(
						" Contas Auxiliar:\n " + "1 - " + estagiario1.getNome() + " " + estagiario1.getSobrenome());

				int acao2 = sc.nextInt();

				if (acao2 == 1) {
					System.out.println(
							"\n Bem vindo novamente Sr. " + estagiario1.getNome() + " " + estagiario1.getSobrenome());
					System.out.println();
					System.out.print("Digite seu login: ");
					String validacaoDoSistema = sc.next();
					// estagiario1.setValidacaoDoSistema(validacaoDoSistema);
					System.out.print("Digite sua senha: ");
					validacaoDoSistema = sc.next();
					// estagiario1.setValidacaoDoSistema(validacaoDoSistema);
					System.out.println();

					String mensagem = "";
					int a = 0;
					int b = 0;
					if (a > b) {
						System.out.println("\n---------- LOGIN REALIZADO COM SUCESSO ----------\n");
						System.out.println(
								"Qual acao deseja realizar?\n 1 - Visualizar Projetos\n 2 - Cronograma\n 3 - Anotacoes\n 4 - Calendario\n 5 - Encerrar Sessao\n");

						int acaoEstagiario = sc.nextInt();

						for (i = acaoEstagiario; i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i > 5; i++) {
							if (acaoEstagiario == 1) {
								System.out.println("PROJETOS EM REFORMA");
							} else if (acaoEstagiario == 2) {
								System.out.println("CRONOGRAMA EM REFORMA");
							} else if (acaoEstagiario == 3) {
								System.out.println("ANOTAÇÕES EM REFORMA");
							} else if (acaoEstagiario == 4) {
								System.out.println("CALENDARIO EM REFORMA");
							} else if (acaoEstagiario == 5) {
								System.out.println("Sessao Encerrada!");
								break;
							} else if (acaoEstagiario > 5) {
								System.out.println(
										"## ACAO NAO ENCONTRADA EM NOSSO SISTEMA, POR FAVOR DIGITE UM VALOR VALIDO ##\n");
							}
						}
					}
				}
			} else if (acao1 == 4) {
				System.out.println("---------- CADASTRO DE FUNCIONARIO ----------");
				System.out.println();
				System.out.println(" Digite o cargo do funcionario:\n 1.Gerente / 2.Auxiliar / 3.Estagiario ");
				int cargoCadastro = sc.nextInt();

				if (cargoCadastro == 1) {
					System.out.println("\n---------- CADASTRO GERENTE ---------");
					System.out.println();

					String mensagemNome = "Cadastre o nome e sobrenome do Gerente: ";
					String mensagemCpf = "Cadastre o cpf do Gerente: ";
					String mensagemSalario = "Cadastre um salario do Gerente: ";
					String mensagemIdade = "Cadastre uma idade do Gerente: ";
					String mensagemEstadoCivil = "Cadastre o Estado Civil do Gerente: ";
					String mensagemDeLoginCadastro = "Digite seu login (6 digitos): ";
					String mensagemDeSenhaCadastro = "Digite sua senha (6 digitos): ";
					cadastrarGerente.cadastroGerente(mensagemNome, mensagemCpf, mensagemSalario, mensagemIdade,
							mensagemEstadoCivil, mensagemDeLoginCadastro, mensagemDeSenhaCadastro, listaGerente);

					System.out.println("********** GERENTE CADASTRADO COM SUCESSO! **********\n");

				} else if (cargoCadastro == 2) {
					System.out.println("\n---------- CADASTRO AUXILIAR ---------");
					System.out.println();

					String mensagemNome = "Cadastre o nome e sobrenome do Auxiliar: ";
					String mensagemCpf = "Cadastre o cpf do Auxiliar: ";
					String mensagemSalario = "Cadastre um salario do Auxiliar: ";
					String mensagemIdade = "Cadastre uma idade do Auxiliar: ";
					String mensagemEstadoCivil = "Cadastre o Estado Civil do Auxiliar: ";
					cadastrarAuxiliar.cadastroAuxiliar(mensagemNome, mensagemCpf, mensagemSalario, mensagemIdade,
							mensagemEstadoCivil, listaGerente);

					// auxiliar1.setLoginAuxiliar(bancoDeDadosFuncionario.bancoDeDadosDeFuncionarios());
					// auxiliar1.setLoginAuxiliar(bancoDeDadosFuncionario.bancoDeDadosDeFuncionarios());

					System.out.println("\n********** AUXILIAR CADASTRADO COM SUCESSO! **********\n");

				} else if (cargoCadastro == 3) {

					System.out.print("\n---------- CADASTRO ESTAGIARIO ---------");
					System.out.println();

					String mensagemNome = "Cadastre o nome e sobrenome do Estagiario: ";
					String mensagemCpf = "Cadastre o cpf do Estagiario: ";
					String mensagemSalario = "Cadastre um salario do Estagiario: ";
					String mensagemIdade = "Cadastre uma idade do Estagiario: ";
					String mensagemEstadoCivil = "Cadastre o Estado Civil do Estagiario: ";
					cadastrarEstagiario.cadastroEstagiario(mensagemNome, mensagemCpf, mensagemSalario, mensagemIdade,
							mensagemEstadoCivil, listaGerente);

					// estagiario1.setLoginEstagiario(bancoDeDadosFuncionario.bancoDeDadosDeFuncionarios());
					// estagiario1.setLoginEstagiario(bancoDeDadosFuncionario.bancoDeDadosDeFuncionarios());

					System.out.println("\n********** ESTAGIARIO CADASTRADO COM SUCESSO! **********\n");

				}
			} else if (acao1 == 5) {
				System.out.println("Sessao Encerrada!");
				break;
			} else if (acao1 > 5) {
				System.out.print("\n### Comando Invalido ### Por favor insira um valor valido!\n ");
				System.out.println();
			} else {
				System.out.println("Login incorreto");
				System.out.println();
				System.out.println("Tente novamente mais tarde.\n ");
			}

			System.out.println(
					"---------- Digite o Seu Cargo ----------\n \n 1 - Gerente\n 2 - Auxiliar\n 3 - Estagiario\n 4 - Cadastrar Funcionario\n 5 - Encerrar Sessao!");
			acao1 = sc.nextInt();
		}
		sc.close();

	}

}
