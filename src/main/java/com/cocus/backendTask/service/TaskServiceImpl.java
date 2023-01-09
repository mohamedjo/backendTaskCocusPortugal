package com.cocus.backendTask.service;

import com.cocus.backendTask.client.GitHubServiceClient;
import com.cocus.backendTask.client.GitHubServiceClientImpl;
import com.cocus.backendTask.model.GithubRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    GitHubServiceClient gitHubServiceClient;

    @Override
    public List<GithubRepo> GetAllGitHubReposByUserName(String userName) {
        gitHubServiceClient.getAllRepos(userName);

        return new ArrayList<>();
    }
}
