package com.meetup.web.dto;

import lombok.AllArgsConstructor;
//import com.meetup.web.models.UserEntity;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class NovelSnippetDTO {
	
	//DTO allows us to only show the user what fields are necessary
	//rather than all the fields in the model ex. password
	
    private Long id;
    @NotEmpty(message = "Novel title should not be empty")
    private String title;
    @NotEmpty(message = "Content should not be empty")
    private String photoUrl;
    @NotEmpty(message = "Snippet should not be empty")
    private String content;
    @NotEmpty(message = "Genre should not be empty")
    private String genre;
//    private UserEntity createdBy;
    private LocalDateTime createdOn;
//    private List<EventDto> events;
}