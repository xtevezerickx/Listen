package br.com.listen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

	@RequestMapping("cadastrarUsuario")
	public String formCadastrarUsuario(){
		return "usuario/cadastrarUsuario";
	}
	
	@RequestMapping("login")
	public String formFazerLogin(){
		return "usuario/login";
	}
	
}
