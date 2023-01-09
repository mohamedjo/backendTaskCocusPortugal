package com.cocus.backendTask.client;

import com.cocus.backendTask.client.vo.GitHubServiceGetAllRepoVO;
import com.cocus.backendTask.model.Branch;
import com.cocus.backendTask.model.GithubRepo;
import com.cocus.backendTask.model.response.BranchResponse;
import com.cocus.backendTask.model.response.RepoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.cocus.backendTask.client.constant.GithubConstant.*;


@Slf4j
@Component
public class GitHubServiceClientImpl implements GitHubServiceClient {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public GitHubServiceGetAllRepoVO getAllRepos(String userName) {

        GithubRepo[] githubRepos = restTemplate.getForObject(GITHUB_API_BASE_URL + USER_REPOS_GET_PATH.replace(USER_CONSTANT, userName)
                , GithubRepo[].class);

        List<RepoResponse> repoResponseList = new ArrayList<>();
        for (GithubRepo githubRepo : githubRepos) {

            if (!githubRepo.isFork()) {
                RepoResponse repoResponse = new RepoResponse();
                repoResponse.setRepositoryName(githubRepo.getRepositoryName());
                repoResponse.setOwner(githubRepo.getOwner());
                List<Branch> branchList = getAllBranches(userName, githubRepo.getRepositoryName());
                List<BranchResponse> branchResponseList= new ArrayList<>();
                for (Branch branch : branchList) {

                    BranchResponse branchResponse=new BranchResponse()
                }


            }

        }

        return null;
    }

    public List<Branch> getAllBranches(String userName, String repoName) {

        Branch[] objects = restTemplate.getForObject(GITHUB_API_BASE_URL + REPO_BRANCHES_GET_PATH.replace(USER_CONSTANT, userName).replace(REPO_CONSTANT, repoName)
                , Branch[].class);


        return Arrays.stream(objects).toList();
    }
}
