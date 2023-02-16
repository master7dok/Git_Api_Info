package com.mbdev.gitstats.controller;

import com.mbdev.gitstats.repository.GitHubRepository;
import com.mbdev.gitstats.service.GitHubServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GitHubController {

    @Autowired
    private GitHubServices gitHubServices;

    @GetMapping("/repositories/{owner}/{repositoryName}")
    public GitHubRepository getInfo(@PathVariable String owner, @PathVariable String repositoryName) {
        return gitHubServices.getInfo(owner, repositoryName);
    }
}
