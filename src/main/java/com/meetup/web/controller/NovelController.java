package com.meetup.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.meetup.web.dto.NovelSnippetDTO;
import com.meetup.web.services.NovelSnippetService;

import jakarta.validation.Valid;

import com.meetup.web.models.NovelSnippets;

@Controller
public class NovelController {
	private NovelSnippetService novelService;
	
	@Autowired
	public NovelController(NovelSnippetService novelService) {
		this.novelService = novelService;
	}
	
	@GetMapping("/snippets") 
	public String listNovels(Model model){
		List<NovelSnippetDTO> snippets = novelService.findAllSnippets();
		model.addAttribute("snippets", snippets);
		return "novels-list";
	}

	@GetMapping("/snippets/new")
	public String createSnippetForm(Model model){
		NovelSnippets snippet = new NovelSnippets();
		model.addAttribute("snippet", snippet);
		return "snippets-create";
	}
	
	@PostMapping("/snippets/new")
	public String saveSnippet(@Valid @ModelAttribute("snippet") NovelSnippetDTO snippetDTO,
							  BindingResult result, 
							  Model model){
		if(result.hasErrors()) {
			model.addAttribute("snippet", snippetDTO);
			return "snippets-create";
		}
		novelService.saveSnippet(snippetDTO);
		return "redirect:/snippets";
	}
	
	@GetMapping("/snippets/{snippetID}") 
	public String snippetDetails(@PathVariable("snippetID") Long snippetID, Model model){
		NovelSnippetDTO snippetDTO = novelService.findSnippetByID(snippetID);
		model.addAttribute("snippet", snippetDTO);
		return "snippets-detail";
	}

	@GetMapping("/snippets/{snippetID}/delete") 
	public String deleteSnippet(@PathVariable("snippetID") Long snippetID){
		novelService.deleteSnippet(snippetID);
		return "redirect:/snippets";
	}


	@GetMapping("/snippets/{snippetID}/edit")
	public String editSnippetForm(@PathVariable("snippetID") Long snippetID, Model model) {
			NovelSnippetDTO snippet = novelService.findSnippetByID(snippetID);
			model.addAttribute("snippet",snippet);
			return "snippets-edit";
	}
	
	@PostMapping("/snippets/{snippetID}/edit")
	public String updateSnippet(@PathVariable("snippetID") Long snippetID,
													 @Valid @ModelAttribute("snippet") NovelSnippetDTO snippet,
													 BindingResult result, Model model) {
			if(result.hasErrors()) {
					model.addAttribute("snippet", snippet );
					return "snippets-edit";	
			}
			snippet.setId(snippetID);
			novelService.updateSnippet(snippet);
			return "redirect:/snippets";
	}
}