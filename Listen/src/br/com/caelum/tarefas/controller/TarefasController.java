package br.com.caelum.tarefas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
public class TarefasController {
	@RequestMapping("novaTarefa")
	public String form(){
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa,BindingResult result) {
		if(result.hasFieldErrors("descricao")){
			return "tarefa/formulario";
		}
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/formulario";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefas",dao.lista());
		return "tarefa/lista";
	}
}
