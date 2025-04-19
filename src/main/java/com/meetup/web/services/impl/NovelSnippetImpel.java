package com.meetup.web.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.meetup.web.services.NovelSnippetService;
import com.meetup.web.dto.NovelSnippetDTO;
import com.meetup.web.models.NovelSnippets;
import com.meetup.web.repository.NovelSnippetRepo;
import com.meetup.web.mapper.NovelSnippetMapper;

public class NovelSnippetImpel implements NovelSnippetService {

	private NovelSnippetRepo novelSnippetRepo;
	
	//autowired tells spring where an injection needs to occur
	//searches for a bean of type NovelSnippetRepo to inject
	//is not needed for new Spring applications
	@Autowired
    public NovelSnippetImpel(NovelSnippetRepo novelSnippetRepo) {
        this.novelSnippetRepo = novelSnippetRepo;
    }
	
	@Override
	public List<NovelSnippetDTO> findAllSnippets() {
		List<NovelSnippets> novelsnips = novelSnippetRepo.findAll();
		
		//To use the DTO to display info securely and convieniently
		//Need to return a List of NovelSnippetDTO (return type in the method)
		//But only receiving List of NovelSnippets from DataBase
		//Hence mapping is required
		
		return novelsnips.stream()
				.map((novelsnip) -> NovelSnippetMapper.mapToNovelSnippetDTO(novelsnip))
				.collect(Collectors.toList());
	}

}
