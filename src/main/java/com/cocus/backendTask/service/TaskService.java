package com.cocus.backendTask.service;

import com.cocus.backendTask.model.GithubRepo;

import java.util.List;

public interface TaskService {

    List<GithubRepo> GetAllGitHubReposByUserName(String userName);


}
