package com.example.demo.model;

import com.example.demo.repository.IPullRequestRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    private Integer id;

    private String name;

    private String is_template;

    private String is_private;

    private Timestamp created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigment_id")
    private Assignment assignment;

    @OneToMany(mappedBy = "repository", cascade = CascadeType.ALL)
    private List<PullRequest> pullRequests;

    @OneToMany(mappedBy = "repository", cascade = CascadeType.ALL)
    private List<Commit> commits;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User users;

    @JsonIgnore
    @OneToMany(mappedBy = "repo", cascade = CascadeType.ALL)
    private List<Repository> repositories;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_repo_id")
    private Repository repo;









}
