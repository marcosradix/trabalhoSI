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

public class Decripta implements ICypher{

	@Override
	public String encriptaDecripta(String entrada, String algoritimo) throws
	NoSuchAlgorithmException, NoSuchPaddingException
	, InvalidKeyException, IllegalBlockSizeException,
	BadPaddingException, UnsupportedEncodingException {
		
		//Algorítimos de critografia simetricos
				//AES, RC2, RC5, IDEA, BLOWFISH
		
		byte[] senhaCriptografada = entrada.getBytes("iso-8859-1");
		KeyGenerator keyGenerator = KeyGenerator.getInstance(algoritimo);
		SecretKey secretKey = keyGenerator.generateKey();
		Cipher cipher;
		cipher = Cipher.getInstance(algoritimo);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] senhaDecriptografada = cipher.doFinal(senhaCriptografada);
		System.out.println("Saída de texto claro: "+new String(senhaDecriptografada,"iso-8859-1"));
		return new String(senhaDecriptografada);
	}

}
