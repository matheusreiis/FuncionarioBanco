package util;

import org.apache.log4j.Logger; 

public class GeradorDeId {
	
	Logger logger = Logger.getLogger(GeradorDeId.class);
;
	static int id;
	
	public int gerarId() {
		
		for (int i = 1; i < 10;) {
			id++;
			logger.info("Novo id do usuario: " + id);
			break;
		}
		return id;
	}
}
