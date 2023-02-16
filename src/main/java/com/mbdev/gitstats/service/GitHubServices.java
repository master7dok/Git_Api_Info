package com.mbdev.gitstats.service;

import com.mbdev.gitstats.repository.GitHubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class GitHubServices {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${github.api.url}")
    private String apiUrl;

    public GitHubRepository getInfo(String owner, String repositoryName){
        String url = apiUrl + "/repos/" + owner + "/" + repositoryName;
        GitHubRepository repository = restTemplate.getForObject(url, GitHubRepository.class);
        return repository;
    }
}
