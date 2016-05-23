package br.com.listen.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

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
		model.addAttribute("listaGeneros", listaGeneros);
		return "cd/cadastrarCD";
	}

	@RequestMapping("removerCD")
	public String removerCD(int cdId) throws Exception {
		new TabelaCDDB().delete(cdId);
		return "redirect:listarCd";
	}

	@RequestMapping("mostrarCD")
	public String alterarCD(int cdId, Model model) throws Exception {
		TabelaCDDB bd = new TabelaCDDB();
		CDs cd = bd.buscaPeloId(cdId);
		System.out.println("O cd é :"+cd);
		ArrayList<GenerosType> listaGeneros = new ArrayList<GenerosType>(Arrays.asList(GenerosType.values()));
		model.addAttribute("listaGeneros", listaGeneros);
		ArrayList<Faixas> listaFaixas=new TabelaCDDB().listarFaixasPorId(cdId);
		System.out.println("lista de faixas em mostrar cd e:"+listaFaixas);
		model.addAttribute("listaFaixas",listaFaixas);
		model.addAttribute("cd", cd);

		return "cd/mostrarCD";
	}
	@RequestMapping("alterarCd")
	public String alterarCd(CDs cd,@RequestParam("genero")String genero)throws Exception{
		System.out.println(cd);
		cd.setDscGenero(GenerosType.valueOf(genero));
		TabelaCDDB bd = new TabelaCDDB();
		bd.update(cd);
		return "redirect:listarCd";
	}

	@RequestMapping("mostrarFaixa")
	public String formCadastrarFaixa(int cdId, Model model) throws Exception {
		System.out.println("entrou no mostrar faixa com id:" + cdId);
		model.addAttribute("cdId", cdId);
		
		return "cd/mostrarFaixa";
	}

	@RequestMapping("adicionarFaixa")
	public String adicionarFaixa(Model model, int cdId, @RequestParam("faixa") ArrayList<String> faixa)
			throws SQLException, Exception {
		System.out.println("entrou no adicionarFaixa com id:" + cdId);
		cadastrarFaixa(cdId, faixa);
		model.addAttribute("msg", "Você adicionou novas faixas com sucesso!");
		return "redirect:listarCd";
	}

	@RequestMapping("adicionarCd")
	public String AdicionarCD(Model model, CDs cd, @RequestParam("genero") String genero)
			throws SQLException, Exception {
		cd.setDscGenero(GenerosType.valueOf(genero));
		System.out.println(cd);
		new TabelaCDDB().insert(cd);
		model.addAttribute("msg", "Você adicionou um novo CD com sucesso!");
		return "redirect:listarCd";
	}

	private void cadastrarFaixa(int cdId, ArrayList<String> faixa) throws SQLException, Exception {
		FaixasDB bd = new FaixasDB();
		Faixas f = new Faixas();
		for (int i = 0; i < faixa.size(); i++) {
			if (!(faixa.get(i) == null)) {
				f.setNumFaixa(i + 1);
				f.setDscFaixa(faixa.get(i));
				f.setIdCd(cdId);
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

	@RequestMapping("listarCd")
	public String lista(String msg, Model model) throws SQLException, Exception {
		TabelaCDDB bd = new TabelaCDDB();
		List<CDs> listacd = bd.findAll();
		model.addAttribute("cds", listacd);
		model.addAttribute("msg", msg);
		return "cd/listarCD";
	}

	@RequestMapping("index")
	public void index(Model model) throws SQLException, Exception {

		ArrayList<GenerosType> listaGeneros = new ArrayList<GenerosType>(Arrays.asList(GenerosType.values()));	
		
		ArrayList<Genero> listaQuantidadePorGenero = new ArrayList<>();
	
		for(int i=0;i<listaGeneros.size();i++){
			Genero genero = new Genero();
			genero.setQtdGenero(new GeneroDB().buscaQuantidadePorGenero(listaGeneros.get(i).name()));
			genero.setDscGenero(listaGeneros.get(i).getDescricao());
			listaQuantidadePorGenero.add(genero);
		}
		
		TreeSet<Artista> tree = new TabelaCDDB().listaTodosArtistasOrdem();
		List<Artista> listaArtistas = new ArrayList<Artista>(tree);
		
		System.out.println("antes do loop"+listaArtistas);
		
		for(int i=0;i<listaArtistas.size();i++){
			listaArtistas.get(i).setQtdArtista(new ArtistaDB().buscaQuantidaePorArtista(listaArtistas.get(i).getNomeArtista()));
		}
		
		System.out.println("depois do loop"+listaArtistas);
			
		model.addAttribute("cds", new TabelaCDDB().buscaTodosLancamentos());
		model.addAttribute("quantidadePorGenero",listaQuantidadePorGenero);	
		model.addAttribute("listaArtistas",listaArtistas);
		model.addAttribute("listaDeFaixas", new FaixasDB().listarTodasFaixas());

	}

	
}
