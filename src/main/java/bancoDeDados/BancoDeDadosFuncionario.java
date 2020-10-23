package bancoDeDados;

import java.util.List;

import entities.Auxiliar;
import entities.Estagiario;
import entities.Funcionario;
import entities.Gerente;

public class BancoDeDadosFuncionario {

	public void listaDeRegistroGerente(List<Funcionario> listaGerente) {

		if (listaGerente.size() == 0) {
			System.out.println("Nao ha Gerentes cadastrados!");
		} else {
			
			for (int i = 0; i < listaGerente.size(); i++) {
				Gerente gerente1 = (Gerente) listaGerente.get(i);

				System.out.println();
				System.out.println("--------- DADOS DO GERENTE ---------");
				System.out.println();
				System.out.println("Nome do Gerente: " + gerente1.getNome() + " " + gerente1.getSobrenome());
				System.out.println("cpf do Gerente: " + gerente1.getCpf());
				System.out.printf("Salario do Gerente: R$ %.2f\n", gerente1.getSalario());
				System.out.println("Idade do Gerente: " + gerente1.getIdade());
				System.out.println("Estado Civil do Gerente: " + gerente1.getEstadoCivil());
				System.out.println("Login do Gerente: " + gerente1.getLoginDoCadastroDoSistema());
				System.out.println("Senha do Gerente: **************");
				System.out.println();
			}
		}
	}

	public void listaDeRegistroAuxiliar(List<Funcionario> listaAuxiliar) {

		if (listaAuxiliar.size() == 0) {
			System.out.println("Nao ha funcionarios cadastrados!");
		} else {
			for (int i = 0; i < listaAuxiliar.size(); i++) {
				Auxiliar auxiliar1 = (Auxiliar) listaAuxiliar.get(i);

				System.out.println();
				System.out.println("--------- DADOS DO GERENTE ---------");
				System.out.println();
				System.out.println("Nome do Gerente: " + auxiliar1.getNome() + " " + auxiliar1.getSobrenome());
				System.out.println("cpf do Gerente: " + auxiliar1.getCpf());
				System.out.printf("Salario do Gerente: R$ %.2f\n", auxiliar1.getSalario());
				System.out.println("Idade do Gerente: " + auxiliar1.getIdade());
				System.out.println("Estado Civil do Gerente: " + auxiliar1.getEstadoCivil());
				System.out.println("Login do Gerente: " + auxiliar1.getLoginDoCadastroDoSistema());
				System.out.println("Senha do Gerente: **************");
				System.out.println();
			}
		}
	}

	public void listaDeRegistroEstagiario(List<Funcionario> listaEstagiario) {

		if (listaEstagiario.size() == 0) {
			System.out.println("Nao ha funcionarios cadastrados!");
		} else {
			for (int i = 0; i < listaEstagiario.size(); i++) {
				Estagiario estagiario1 = (Estagiario) listaEstagiario.get(i);

				System.out.println();
				System.out.println("--------- DADOS DO GERENTE ---------");
				System.out.println();
				System.out.println("Nome do Gerente: " + estagiario1.getNome() + " " + estagiario1.getSobrenome());
				System.out.println("cpf do Gerente: " + estagiario1.getCpf());
				System.out.printf("Salario do Gerente: R$ %.2f\n", estagiario1.getSalario());
				System.out.println("Idade do Gerente: " + estagiario1.getIdade());
				System.out.println("Estado Civil do Gerente: " + estagiario1.getEstadoCivil());
				System.out.println("Login do Gerente: " + estagiario1.getLoginDoCadastroDoSistema());
				System.out.println("Senha do Gerente: **************");
				System.out.println();
			}
		}
	}

	public List<Funcionario> listaDeRegistroGerente(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
