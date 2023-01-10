package com.cocus.backendTask.client;

import com.cocus.backendTask.client.vo.GitHubServiceGetAllBranchesVO;
import com.cocus.backendTask.client.vo.GitHubServiceGetAllRepoVO;
import com.cocus.backendTask.model.GithubBranch;

import java.util.List;

public interface GitHubServiceClient {


    GitHubServiceGetAllRepoVO getAllRepos(String useNAme);

    GitHubServiceGetAllBranchesVO getAllBranches(String userName, String repoName);
}
