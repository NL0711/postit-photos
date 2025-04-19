package com.meetup.web.repository;

import com.meetup.web.model.WritingSnippet;
import com.meetup.web.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WritingSnippetRepository extends JpaRepository<WritingSnippet, Long> {
    Page<WritingSnippet> findByIsPublicTrue(Pageable pageable);
    List<WritingSnippet> findByAuthor(User author);
    Page<WritingSnippet> findByAuthorAndIsPublicTrue(User author, Pageable pageable);
    Page<WritingSnippet> findByTitleContainingIgnoreCaseAndIsPublicTrue(String title, Pageable pageable);
} 