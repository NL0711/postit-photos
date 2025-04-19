package com.meetup.web.mapper;

import com.meetup.web.dto.NovelSnippetDTO;
import com.meetup.web.models.NovelSnippets;

public class NovelSnippetMapper {
	public static NovelSnippetDTO mapToNovelSnippetDTO(NovelSnippets novelSnippets) {
		NovelSnippetDTO novelSnippetDTO = NovelSnippetDTO.builder()
		.id(novelSnippets.getId())
		.title(novelSnippets.getTitle())
		.content(novelSnippets.getContent())
		.genre(novelSnippets.getGenre())
		.request(novelSnippets.getRequest())
		.createdOn(novelSnippets.getCreatedOn())
		.updatedOn(novelSnippets.getUpdatedOn())
		.build();
		return novelSnippetDTO;
	}	
	
}
