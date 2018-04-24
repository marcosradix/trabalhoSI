package br.com.si.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.si.cypher.Decripta;
import br.com.si.cypher.Encripta;
import br.com.si.interfaceCypher.ICypher;

@RestController
@RequestMapping("/cypher")
public class CypherController {

	
	
	@GetMapping("/encriptar/{entrada}/{algoritimo}")
	public String encriptarDados(@PathVariable String entrada,@PathVariable String algoritimo ) {
		ICypher dadosServiceEn = new Encripta();
		String retorno= "";
		try {
			retorno = dadosServiceEn.encriptaDecripta(entrada, algoritimo);
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(retorno);
	}
	
	@GetMapping("/decriptar/{entrada}/{algoritimo}")
	public String decriptarDados(@PathVariable String entrada, @PathVariable String algoritimo ) {
		ICypher dadosServiceDe = new Decripta();
		String retorno= "";
		try {
			retorno =  dadosServiceDe.encriptaDecripta(entrada, algoritimo);
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(retorno);
	}
	
	
}
