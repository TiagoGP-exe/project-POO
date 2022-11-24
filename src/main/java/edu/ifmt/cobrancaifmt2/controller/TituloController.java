package edu.ifmt.cobrancaifmt2.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.ifmt.cobrancaifmt2.Titulos;
import edu.ifmt.cobrancaifmt2.model.StatusTitulo;
import edu.ifmt.cobrancaifmt2.model.Titulo;

@Controller
@RequestMapping("/titulos")
class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		
		mv.addObject(new Titulo());
		
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(@Validated Titulo titulo, Errors errors) {
		ModelAndView mv = new ModelAndView("CadastroTitulo");

		if (errors.hasErrors()) {
			return mv;
		}
		
		titulos.save(titulo);
		mv.addObject("mensagem", "Foi salvo com sucesso!");
		
		return mv;
		
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
			
		return mv;
	}
}
