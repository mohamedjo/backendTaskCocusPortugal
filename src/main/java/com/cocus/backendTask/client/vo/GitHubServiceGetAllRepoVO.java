package com.cocus.backendTask.client.vo;

import com.cocus.backendTask.model.response.RepoResponse;

import java.util.List;

public class GitHubServiceGetAllRepoVO {
    List<RepoResponse>repoResponseList;

    public GitHubServiceGetAllRepoVO(List<RepoResponse> repoResponseList) {
        this.repoResponseList = repoResponseList;
    }
}
