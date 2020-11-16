package interfaces;

import java.util.List;

import entities.Funcionario;

public interface IValidadorDoBancoDeDados {

	public void validaBancoGerente(int loginDeAutenticacao, int senhaDeAutenticacao, int acaoLobbyGerente, List<Funcionario> listaGerente);
}
