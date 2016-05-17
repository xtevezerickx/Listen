package br.com.listen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import br.com.listen.jdbc.TabelaCDDB;
import br.com.listen.model.CDs;
import br.com.listen.model.Faixas;

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
	public String AdicionarCD(CDs cd,Faixas faixas){
		TabelaCDDB bd = new TabelaCDDB();	
		System.out.println(faixas);
		try {
			bd.insert(cd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:cadastrarCD";
	}
	
	
	
}
