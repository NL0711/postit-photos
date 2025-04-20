package com.meetup.web.mapper;

import com.meetup.web.dto.NovelSnippetDTO;
import com.meetup.web.models.NovelSnippets;

public class NovelSnippetMapper {
	public static NovelSnippetDTO mapToNovelSnippetDTO(NovelSnippets novelSnippets) {
		NovelSnippetDTO novelSnippetDTO = NovelSnippetDTO.builder()
		.id(novelSnippets.getId())
		.title(novelSnippets.getTitle())
		.content(novelSnippets.getContent())
		.photoUrl(novelSnippets.getPhotoUrl())
		.genre(novelSnippets.getGenre())
		.createdOn(novelSnippets.getCreatedOn())
		.build();
		return novelSnippetDTO;
	}
	
	public static NovelSnippets mapToSnippet(NovelSnippetDTO novelSnippets) {
		NovelSnippets snippetDTO = NovelSnippets.builder()
				.id(novelSnippets.getId())
				.title(novelSnippets.getTitle())
				.content(novelSnippets.getContent())
				.photoUrl(novelSnippets.getPhotoUrl())
				.genre(novelSnippets.getGenre())
				.createdOn(novelSnippets.getCreatedOn())
				.build();
		return snippetDTO;
	}

}