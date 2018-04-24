package br.com.si.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class UtilCypher {

	private static Scanner scanner;

	public static void main(String[] args) throws UnsupportedEncodingException {
		scanner = new Scanner(System.in);
		System.out.println("Digite o texta para encriptar");
		String entrada = scanner.nextLine();
		
		//Algorítimos de critografia simetricos
		//AES, RC2, RC5, IDEA, BLOWFISH
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("BLOWFISH");
			SecretKey secretKey = keyGenerator.generateKey();
			Cipher cipher;
			cipher = Cipher.getInstance("BLOWFISH");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] senhaCriptografada = cipher.doFinal(entrada.getBytes("iso-8859-1"));
			System.out.println("Saída de texto encriptado: "+new String(senhaCriptografada,"iso-8859-1") );
			
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] senhaDecriptografada = cipher.doFinal(senhaCriptografada);
			System.out.println("Saída de texto claro: "+new String(senhaDecriptografada,"iso-8859-1"));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Programa Finalizado!");
	}

}