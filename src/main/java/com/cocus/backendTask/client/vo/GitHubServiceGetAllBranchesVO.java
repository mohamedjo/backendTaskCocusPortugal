package com.cocus.backendTask.client.vo;

import com.cocus.backendTask.model.GithubBranch;
import lombok.Getter;

import java.util.List;

@Getter
public class GitHubServiceGetAllBranchesVO {

    private List<GithubBranch> githubBranches;

    public GitHubServiceGetAllBranchesVO(List<GithubBranch> githubBranches) {
        this.githubBranches = githubBranches;
    }
}
