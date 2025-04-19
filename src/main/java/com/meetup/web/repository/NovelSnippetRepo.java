package com.meetup.web.repository;

import com.meetup.web.models.NovelSnippets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface NovelSnippetRepo extends JpaRepository<NovelSnippets, Long> {
    Optional<NovelSnippets> findByGenre(String url);
    @Query("SELECT n from NovelSnippets n WHERE n.genre LIKE CONCAT('%', :query, '%')")
    List<NovelSnippets> searchGenre(String query);
}