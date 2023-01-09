package com.cocus.backendTask.service;

import com.cocus.backendTask.client.GitHubServiceClient;
import com.cocus.backendTask.helper.TaskServiceHelper;
import com.cocus.backendTask.model.GithubBranch;
import com.cocus.backendTask.model.GithubRepo;
import com.cocus.backendTask.model.response.BranchResponse;
import com.cocus.backendTask.model.response.RepoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private GitHubServiceClient gitHubServiceClient;

    @Autowired
    private TaskServiceHelper taskServiceHelper;

    @Override
    public List<RepoResponse> getAllGitHubReposByUserName(String userName) {


        List<GithubRepo> githubRepoList = gitHubServiceClient.getAllRepos(userName).getGithubRepoList();

        return getAllNotForkedRepos(githubRepoList);
    }

    private List<RepoResponse> getAllNotForkedRepos(List<GithubRepo> githubRepoList) {

        List<RepoResponse> repoResponseList = new ArrayList<>();
        for (GithubRepo githubRepo : githubRepoList) {

            if (!githubRepo.isFork()) {
                RepoResponse repoResponse = taskServiceHelper.gitHupRepoToRepoResponse(githubRepo);
                List<GithubBranch> githubBranchList = gitHubServiceClient.getAllBranches(githubRepo.getOwner().getLoginName(), githubRepo.getRepositoryName());
                List<BranchResponse> branchResponseList = taskServiceHelper.getBranchResponseList(githubBranchList);
                repoResponse.setBranches(branchResponseList);
                repoResponseList.add(repoResponse);

            }

        }
        return repoResponseList;
    }


}
