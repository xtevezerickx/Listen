package br.com.listen.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.listen.jdbc.FaixasDB;
import br.com.listen.jdbc.TabelaCDDB;
import br.com.listen.model.CDs;
import br.com.listen.model.Faixas;

@Controller
public class CDController {
	@RequestMapping("cadastrarCD")
	public String formAdicionarCD() {
		return "cd/cadastrarCD";
	}

//	@RequestMapping("alterarCD")
//	public String formAlterarCD() {
//		return "cd/alterarCD";
//	}

	@RequestMapping("adicionarCD")
	public String AdicionarCD(CDs cd) {
		System.out.println(cd.toString());
		TabelaCDDB bd = new TabelaCDDB();
		try {
			bd.insert(cd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cd/cadastrarFaixa";
	}

	@RequestMapping("cadastrarFaixa")
	public String formCadastrarFaixa() {
		return "redirect:cadastrarFaixa";
	}

	@RequestMapping("adicionarFaixa")
	public String adicionarFaixa(@RequestParam("faixa") ArrayList<String> faixa) {
		FaixasDB bd = new FaixasDB();
		Faixas f = new Faixas();
		for (int i = 0; i < faixa.size(); i++) {
			if (!(faixa.get(i) == null)) {
				f.setDscFaixa(faixa.get(i));
				if (!(f.getDscFaixa() == "")) {
					try {
						bd.insert(f);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "redirect:listarCd";
	}

	@RequestMapping("listarCd")
	public String lista(Model model){
		TabelaCDDB bd = new TabelaCDDB();
		try {
			model.addAttribute("cd",bd.findAll());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "cd/listarCD";
	}
	
}
