package com.meetup.web.services;

import com.meetup.web.services.NovelSnippetService;
import com.meetup.web.dto.NovelSnippetDTO;
import com.meetup.web.models.NovelSnippets;

import java.util.List;

public interface NovelSnippetService {
	List<NovelSnippetDTO> findAllSnippets();
//	NovelSnippets saveSnippet(NovelSnippetDTO clubDto);
//	NovelSnippetDTO findClubById(Long clubId);
//    void updateClub(NovelSnippetDTO club);
//    void delete(Long clubId);
//    List<NovelSnippetDTO> searchClubs(String query);
}
