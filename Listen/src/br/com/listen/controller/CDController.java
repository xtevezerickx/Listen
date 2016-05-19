package br.com.listen.controller;

import java.sql.SQLException;
import java.util.ArrayList;
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

@Controller
public class CDController {
	@RequestMapping("cadastrarCD")
	public String formAdicionarCD() {
		return "cd/cadastrarCD";
	}

	@RequestMapping("adicionarCD")
	public String AdicionarCD(CDs cd,@RequestParam("faixa") ArrayList<String> faixa,Genero genero,Artista artista) throws SQLException, Exception {

		
		if(new GeneroDB().descobreId(genero)==0){
			new GeneroDB().insert(genero);
			genero.setIdGenero(new GeneroDB().descobreUltimoId());
		}else{
			genero.setIdGenero(new GeneroDB().descobreId(genero));
		}
		
		artista.setIdGenero(genero.getIdGenero());
	
		if(new ArtistaDB().descobreId(artista)==0){
			new ArtistaDB().insert(artista);
			artista.setIdArtista(new ArtistaDB().descobreUltimoId());
		}else{
			artista.setIdArtista(new ArtistaDB().descobreId(artista));
		}
		
		cd.setIdArtista(artista.getIdArtista());
		new TabelaCDDB().insert(cd);
		
		FaixasDB bd = new FaixasDB();
		Faixas f = new Faixas();
		for (int i = 0; i < faixa.size(); i++) {
			if (!(faixa.get(i) == null)) {
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
	

		return "redirect:listarCd";
	}

	@RequestMapping("cadastrarFaixa")
	public String formCadastrarFaixa() {
		return "redirect:cadastrarFaixa";
	}

	@RequestMapping("adicionarFaixa")
	public String adicionarFaixa(@RequestParam("faixa") ArrayList<String> faixa) throws SQLException, Exception {
		FaixasDB bd = new FaixasDB();
		Faixas f = new Faixas();
		for (int i = 0; i < faixa.size(); i++) {
			if (!(faixa.get(i) == null)) {
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
		return "redirect:listarCd";
	}

	@RequestMapping("listarCd")
	public String lista(Model model) throws SQLException, Exception{
		TabelaCDDB bd = new TabelaCDDB();
		List<CDs> listacd=bd.findAll();
		model.addAttribute("cds",listacd);
		return "cd/listarCD";
	}
	
}
