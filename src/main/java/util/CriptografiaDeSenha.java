package util;

import java.security.MessageDigest;

public class CriptografiaDeSenha {

	static MessageDigest criptografiaDeSenha;

	public static void criptografarSenha(Integer senhaCadastro) throws Exception {

		criptografiaDeSenha = MessageDigest.getInstance("MD5");
		byte messageDigest[] = criptografiaDeSenha.digest(senhaCadastro.toString().getBytes("UTF-8"));

		System.out.println(messageDigest);

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		String senhahex = hexString.toString();

		System.out.println(senhahex);
	}
}