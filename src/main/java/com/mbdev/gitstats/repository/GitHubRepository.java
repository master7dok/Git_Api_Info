package com.mbdev.gitstats.repository;

import lombok.Data;

@Data
public class GitHubRepository {
    private String full_name;
    private String description;
    private String clone_url;
    private boolean fork;
    private int forks_count;
    private String created_at;
}
