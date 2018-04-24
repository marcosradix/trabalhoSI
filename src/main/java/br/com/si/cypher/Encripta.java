package br.com.si.cypher;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import br.com.si.interfaceCypher.ICypher;

public class Encripta implements ICypher{

	@Override
	public String encriptaDecripta(String entrada, String algoritimo) throws
	IllegalBlockSizeException, BadPaddingException,
	NoSuchAlgorithmException, NoSuchPaddingException,
	InvalidKeyException, UnsupportedEncodingException {
	
		KeyGenerator keyGenerator = KeyGenerator.getInstance(algoritimo);
		SecretKey secretKey = keyGenerator.generateKey();
		Cipher cipher;
		cipher = Cipher.getInstance(algoritimo);
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] senhaCriptografada = cipher.doFinal(entrada.getBytes());
		System.out.println("Saída de texto encriptado: "+new String(senhaCriptografada,"UTF-8"));
		return new String(senhaCriptografada,"UTF-8");
	}

}
