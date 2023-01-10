package com.cocus.backendTask.client.vo;

import com.cocus.backendTask.model.GithubRepo;
import lombok.Getter;

import java.util.List;

@Getter
public class GitHubServiceGetAllRepoVO {
    private List<GithubRepo> githubRepoList;

    public GitHubServiceGetAllRepoVO(List<GithubRepo> githubRepoList) {
        this.githubRepoList = githubRepoList;
    }
}
