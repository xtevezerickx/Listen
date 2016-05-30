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
		ArrayList<String> listaGenerosString = new ArrayList<String>();
		for(int i=0;i<listaGeneros.size();i++){
			listaGenerosString.add(i,listaGeneros.get(i).getDescricao());
		}
		model.addAttribute("listaGeneros", listaGenerosString);
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
		ArrayList<GenerosType> listaGeneros = new ArrayList<GenerosType>(Arrays.asList(GenerosType.values()));
		ArrayList<String> listaGenerosString = new ArrayList<String>();
		for(int i=0;i<listaGeneros.size();i++){
			listaGenerosString.add(i,listaGeneros.get(i).getDescricao());
		}
		System.out.println(listaGenerosString);
		model.addAttribute("listaGeneros", listaGenerosString);
		ArrayList<Faixas> listaFaixas=new TabelaCDDB().listarFaixasPorId(cdId);
		model.addAttribute("listaFaixas",listaFaixas);
		model.addAttribute("cd", cd);

		return "cd/mostrarCD";
	}
	@RequestMapping("alterarCd")
	public String alterarCd(CDs cd, @RequestParam("faixa") ArrayList<String> faixas,Model model)throws Exception{
		TabelaCDDB bdCd = new TabelaCDDB();
		bdCd.update(cd);
		
		
		ArrayList<Faixas> listaFaixasUpdate = new ArrayList<Faixas>();
		for(int i=0;i<faixas.size();i++){
			Faixas f = new Faixas();
			f.setIdCd(cd.getIdCD());
			f.setNumFaixa(i+1);
			f.setDscFaixa(faixas.get(i));
			listaFaixasUpdate.add(f);
		}
		
		System.out.println("Faixas para update"+faixas);
		System.out.println("id do cd para update"+cd.getIdCD());
		FaixasDB bdFaixa = new FaixasDB();
		for(int i=0;i<faixas.size();i++){
			bdFaixa.update(listaFaixasUpdate.get(i));
		}		
		model.addAttribute("msg", "Você alterou um CD com sucesso!");
		return "redirect:listarCd";
	}

	@RequestMapping("mostrarFaixa")
	public String formCadastrarFaixa(int cdId, Model model) throws Exception {
		model.addAttribute("cdId", cdId);
		return "cd/mostrarFaixa";
	}

	@RequestMapping("adicionarFaixa")
	public String adicionarFaixa(Model model, int cdId, @RequestParam("faixa") ArrayList<String> faixa)
			throws SQLException, Exception {
		cadastrarFaixa(cdId, faixa);
		model.addAttribute("msg", "Você adicionou novas faixas com sucesso!");
		return "redirect:listarCd";
	}

	@RequestMapping("adicionarCd")
	public String AdicionarCD(Model model, CDs cd)	throws SQLException, Exception {
		new TabelaCDDB().insert(cd);
		model.addAttribute("msg", "Você adicionou um novo CD com sucesso!");
		return "redirect:listarCd";
	}

	private void cadastrarFaixa(int cdId, ArrayList<String> faixa) throws SQLException, Exception {
		FaixasDB bd = new FaixasDB();
		Faixas f = new Faixas();
		for (int i = 0; i < faixa.size(); i++) {
			if (!(faixa.get(i) == null)) {
				f.setNumFaixa(bd.descobreUltimaFaixa(cdId));
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
	public String lista(String msg, Model model,Integer pag) throws SQLException, Exception {
		System.out.println(pag);
		TabelaCDDB bd = new TabelaCDDB();
		List<CDs> listacd = bd.findAll();
		
		int quantidadePaginas = quantidadeDePaginas(listacd.size());
		ArrayList<Integer> qtdPaginaLista = new ArrayList<Integer>();
		for(int i=0;i<quantidadePaginas;i++){
			qtdPaginaLista.add(i+1);
		}
		
		if(pag!=null){
			model.addAttribute("cds", new TabelaCDDB().listarPaginado(pag));	
		}else{
			model.addAttribute("cds",new TabelaCDDB().listarPaginado(1));
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("paginas",qtdPaginaLista);
		return "cd/listarCD";
	}
	
	

	@RequestMapping("index")
	public void index(Model model) throws SQLException, Exception {

		ArrayList<GenerosType> listaGeneros = new ArrayList<GenerosType>(Arrays.asList(GenerosType.values()));	
		
		ArrayList<Genero> listaQuantidadePorGenero = new ArrayList<>();
	
		for(int i=0;i<listaGeneros.size();i++){
			Genero genero = new Genero();
			genero.setQtdGenero(new GeneroDB().buscaQuantidadePorGenero(listaGeneros.get(i).getDescricao()));
			genero.setDscGenero(listaGeneros.get(i).getDescricao());
			listaQuantidadePorGenero.add(genero);
		}
		
		List<Artista> listaArtistas = new TabelaCDDB().listaTodosArtistasOrdem();

		for(int i=0;i<listaArtistas.size();i++){
			listaArtistas.get(i).setQtdArtista(new ArtistaDB().buscaQuantidaePorArtista(listaArtistas.get(i).getNomeArtista()));
		}
		
		
		
		model.addAttribute("cds", new TabelaCDDB().buscaTodosLancamentos());
		model.addAttribute("quantidadePorGenero",listaQuantidadePorGenero);	
		model.addAttribute("listaArtistas",listaArtistas);
		model.addAttribute("listaDeFaixas", new FaixasDB().listarTodasFaixas());
		
	}
	
	
	private int quantidadeDePaginas(int numero){
		if(numero%8==0){
			return numero/8;
		}else{
			return Math.round(numero/8)+1;
		}
	}

	
}