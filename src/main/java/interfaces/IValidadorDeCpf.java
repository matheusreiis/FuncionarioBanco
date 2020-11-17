package interfaces;

import java.io.IOException;
import java.sql.SQLException;

public interface IValidadorDeCpf {

	public long validaCpf(long cpf, String mensagemCpf) throws IOException, SQLException;
}
