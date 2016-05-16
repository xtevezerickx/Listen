package br.com.listen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CDController {
	
	@RequestMapping("cadastrarCD")
	public String formAdicionarCD(){
		return "cd/cadastrarCD";
	}
	
	@RequestMapping("listarCD")
	public String formAlterarCD(){
		return "cd/listarCD";
	}
	
	@RequestMapping("adicionarCD")
	public String AdicionarCD(){
		//TODO faz a logica de adicionar CD
		return "cd/cadastrarCD";
	}
	
	
	
}
