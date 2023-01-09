package com.cocus.backendTask.client;

import com.cocus.backendTask.client.vo.GitHubServiceGetAllRepoVO;

public interface GitHubServiceClient {


    GitHubServiceGetAllRepoVO getAllRepos(String useNAme);
}
