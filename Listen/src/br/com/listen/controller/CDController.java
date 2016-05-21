package br.com.listen.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.listen.jdbc.ArtistaDB;
import br.com.listen.jdbc.FaixasDB;
import br.com.listen.jdbc.GeneroDB;
import br.com.listen.jdbc.TabelaCDDB;
import br.com.listen.model.Artista;
import br.com.listen.model.CDs;
import br.com.listen.model.Faixas;
import br.com.listen.model.Genero;
import br.com.listen.utils.GenerosType;

@Controller
public class CDController {
	@RequestMapping("cadastrarCD")
	public String formAdicionarCD(Model model) {
		ArrayList<GenerosType> listaGeneros = new ArrayList<GenerosType>(Arrays.asList(GenerosType.values()));
		model.addAttribute("listaGeneros",listaGeneros);
		return "cd/cadastrarCD";
	}

	@RequestMapping("removerCD")
	public String removerCD(int cdId) throws Exception {
		new TabelaCDDB().delete(cdId);
		return "redirect:listarCd";
	}

	@RequestMapping("mostrarCD")
	public String alterarCD(int cdId,Model model) throws Exception{
		System.out.println(cdId);
		TabelaCDDB bd = new TabelaCDDB();
		CDs cd = bd.buscaPeloId(cdId);
		System.out.println(cd);
		model.addAttribute("cd",cd);
		return "cd/mostrarCD";
	}
	
	@RequestMapping("adicionarCd")
	public String AdicionarCD(CDs cd,@RequestParam("genero")String genero)
			throws SQLException, Exception {
		cd.setDscGenero(GenerosType.valueOf(genero));
		System.out.println("Passou por aqui ?");
		System.out.println(cd);
		new TabelaCDDB().insert(cd);
//		cadastrarFaixa(faixa);
		return "redirect:listarCd";
	}

	private void cadastrarFaixa(ArrayList<String> faixa) throws SQLException, Exception {
		FaixasDB bd = new FaixasDB();
		Faixas f = new Faixas();
		for (int i = 0; i < faixa.size(); i++) {
			if (!(faixa.get(i) == null)) {
				f.setNumFaixa(i+1);
				f.setDscFaixa(faixa.get(i));
				f.setIdCd(new TabelaCDDB().descobreUltimoId());
				if (!(f.getDscFaixa() == "")) {
					try {
						bd.insert(f);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	

	@RequestMapping("cadastrarFaixa")
	public String formCadastrarFaixa() {
		return "redirect:cadastrarFaixa";
	}

	@RequestMapping("adicionarFaixa")
	public String adicionarFaixa(@RequestParam("faixa") ArrayList<String> faixa) throws SQLException, Exception {
		cadastrarFaixa(faixa);
		return "redirect:listarCd";
	}

	@RequestMapping("listarCd")
	public String lista(Model model) throws SQLException, Exception {
		TabelaCDDB bd = new TabelaCDDB();
		List<CDs> listacd = bd.findAll();
		model.addAttribute("cds", listacd);
		
		return "cd/listarCD";
	}

	@RequestMapping("index")
	public void index(Model model) throws SQLException, Exception {
		model.addAttribute("cds", new TabelaCDDB().findAll());
		for (CDs cd : new TabelaCDDB().findAll()) {
			model.addAttribute("listaDeFaixas", new FaixasDB().listarTodasFaixas());
		}
		// return "index";
	}

}
