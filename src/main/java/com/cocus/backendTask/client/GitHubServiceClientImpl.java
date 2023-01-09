package com.cocus.backendTask.client;

import com.cocus.backendTask.client.vo.GitHubServiceGetAllRepoVO;
import com.cocus.backendTask.exception.custom.APIRateLimitExceededException;
import com.cocus.backendTask.exception.custom.UserNotFoundException;
import com.cocus.backendTask.model.GithubBranch;
import com.cocus.backendTask.model.GithubRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static com.cocus.backendTask.client.constant.GithubConstants.*;


@Slf4j
@Component
public class GitHubServiceClientImpl implements GitHubServiceClient {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public GitHubServiceGetAllRepoVO getAllRepos(String userName) {
        GithubRepo[] githubRepos = null;
        try {
            githubRepos = restTemplate.getForObject(GITHUB_API_BASE_URL + USER_REPOS_GET_PATH.replace(USER_CONSTANT, userName)
                    , GithubRepo[].class);

        } catch (HttpClientErrorException | HttpServerErrorException httpClientOrServerExc) {
            if (HttpStatus.NOT_FOUND.equals(httpClientOrServerExc.getStatusCode())) {
                throw new UserNotFoundException(" user: " + userName + " Not Exist");

            }
            if (HttpStatus.FORBIDDEN.equals(httpClientOrServerExc.getStatusCode())) {
                throw new APIRateLimitExceededException("API rate limit exceeded");
            }
        }

        return new GitHubServiceGetAllRepoVO(Arrays.stream(githubRepos).toList());
    }

    @Override
    public List<GithubBranch> getAllBranches(String userName, String repoName) {

        GithubBranch[] objects = restTemplate.getForObject(GITHUB_API_BASE_URL + REPO_BRANCHES_GET_PATH.replace(USER_CONSTANT, userName).replace(REPO_CONSTANT, repoName)
                , GithubBranch[].class);

        return Arrays.stream(objects).toList();
    }
}
