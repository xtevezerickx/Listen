package br.com.listen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CDController {
	
	@RequestMapping("cadastrarCD")
	public String formAdicionarCD(){
		return "cd/cadastrarCD";
	}
	
	@RequestMapping("alterarCD")
	public String formAlterarCD(){
		return "cd/alterarCD";
	}
	
	@RequestMapping("adicionarCD")
	public String AdicionarCD(){
		//TODO faz a logica de adicionar
		return "cd/cadastrarCD";
	}
}
