package br.com.si.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.si.cypher.Decripta;
import br.com.si.cypher.Encripta;
import br.com.si.interfaceCypher.ICypher;
import br.com.si.util.CypherText;

@RestController
public class CypherController {
	
	@RequestMapping(value = "/encriptar", method = RequestMethod.POST, produces = "text/text;charset=iso-8859-1" )
	public String encriptarDados(@RequestBody CypherText cypherText ) {
		ICypher dadosServiceEn = new Encripta();
		String retorno= "";
		try {
			retorno = dadosServiceEn.encriptaDecripta(cypherText.getEntrada(), cypherText.getAlgoritimo());
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	@RequestMapping(value = "/decriptar", method = RequestMethod.POST, produces = "text/text;charset=iso-8859-1")
	public String decriptarDados(@RequestBody CypherText cypherText ) {
		ICypher dadosServiceDe = new Decripta();
		String retorno= "";
		try {
			retorno =  dadosServiceDe.encriptaDecripta(cypherText.getEntrada(), cypherText.getAlgoritimo());
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
	
	
}
