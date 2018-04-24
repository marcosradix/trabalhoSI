package br.com.si.interfaceCypher;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public interface ICypher {
	
	public String encriptaDecripta(String entrada, String algoritimo)
			throws IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException;

}
