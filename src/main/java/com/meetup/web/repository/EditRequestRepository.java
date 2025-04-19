package com.meetup.web.repository;

import com.meetup.web.model.EditRequest;
import com.meetup.web.model.WritingSnippet;
import com.meetup.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EditRequestRepository extends JpaRepository<EditRequest, Long> {
    List<EditRequest> findBySnippetOrderByCreatedAtDesc(WritingSnippet snippet);
    List<EditRequest> findByRequesterOrderByCreatedAtDesc(User requester);
} 