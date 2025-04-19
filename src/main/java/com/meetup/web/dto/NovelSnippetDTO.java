package com.meetup.web.dto;

//import com.meetup.web.models.UserEntity;
import lombok.Builder;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class NovelSnippetDTO {
	
	//DTO allows us to only show the user what fields are necessary
	//rather than all the fields in the model ex. password
	
    private Long id;
    @NotEmpty(message = "Novel title should not be empty")
    private String title;
    @NotEmpty(message = "Content should not be empty")
    private String content;
    @NotEmpty(message = "Genre should not be empty")
    private String genre;
    @NotEmpty(message = "Request should not be empty")
    private String request;
//    private UserEntity createdBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
//    private List<EventDto> events;
}