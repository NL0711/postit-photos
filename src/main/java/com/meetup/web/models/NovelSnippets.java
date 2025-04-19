package com.meetup.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //tells spring this is a model we want to represent
@Table(name = "NovelSnip")
public class NovelSnippets{
    @Id //primary key for multiple instances of photos table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment ID
    private Long id;
    private String title;
    private String content;
    private String genre;
    private String request;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

//    @ManyToOne
//    @JoinColumn(name = "created_by", nullable = false)
//    private UserEntity createdBy;
//
//    @OneToMany(mappedBy = "club", cascade = CascadeType.REMOVE)
//    private List<Event> events = new ArrayList<>();
}