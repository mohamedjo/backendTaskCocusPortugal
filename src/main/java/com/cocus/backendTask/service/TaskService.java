package com.cocus.backendTask.service;

import com.cocus.backendTask.model.response.RepoResponse;

import java.util.List;

public interface TaskService {

    List<RepoResponse> getAllGitHubReposByUserName(String userName);



}
