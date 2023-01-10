package com.cocus.backendTask.client;

import com.cocus.backendTask.client.vo.GitHubServiceGetAllBranchesVO;
import com.cocus.backendTask.client.vo.GitHubServiceGetAllRepoVO;
import com.cocus.backendTask.exception.custom.UserNotFoundException;
import com.cocus.backendTask.model.GithubBranch;
import com.cocus.backendTask.model.GithubRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.cocus.backendTask.fixture.TaskFixture.getGithubBranchesResponseArray;
import static com.cocus.backendTask.fixture.TaskFixture.getGithubReposResponseArray;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class GitHubServiceClientTest {

    private static final String GET_REPOS_FROM_GITHUB_SERVICE_URL_EXAMPLE = "https://api.github.com/users/mohamedJo/repos";

    private static final String GET_BRANCHES_FROM_GITHUB_SERVICE_URL_EXAMPLE="https://api.github.com/repos/mohamedjo/Metro/branches?";

    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private GitHubServiceClientImpl classUnderTest;

    @Test
    void givenValidUserName_whenGetAllReposByUsername_thenReturnArrayOfGithubRepos() {


        GithubRepo[] githubRepos = getGithubReposResponseArray();
        when(restTemplate.getForObject(eq(GET_REPOS_FROM_GITHUB_SERVICE_URL_EXAMPLE), eq(GithubRepo[].class)))
                .thenReturn(githubRepos);


        GitHubServiceGetAllRepoVO response = classUnderTest.getAllRepos("mohamedJo");

        assertNotNull(response.getGithubRepoList());
        assertEquals(githubRepos.length, response.getGithubRepoList().size());
    }

    @Test
    void givenNotValidUserNAme_whenGetAllReposByUsername_thenThrowUserNotFoundException() {


        when(restTemplate.getForObject(eq(GET_REPOS_FROM_GITHUB_SERVICE_URL_EXAMPLE), eq(GithubRepo[].class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));



        assertThrows(UserNotFoundException.class, ()->classUnderTest.getAllRepos("mohamedJo"));
    }

    @Test
    void givenValidUserNameAndBranch_whenGetAllReposByUsername_thenReturnArrayOfGithubRepos() {


        GithubBranch[] githubBranches = getGithubBranchesResponseArray();
        when(restTemplate.getForObject(eq(GET_BRANCHES_FROM_GITHUB_SERVICE_URL_EXAMPLE), eq(GithubBranch[].class)))
                .thenReturn(githubBranches);


        GitHubServiceGetAllBranchesVO response = classUnderTest.getAllBranches("mohamedJo","metro");

        assertNotNull(response.getGithubBranches());
        assertEquals(githubBranches.length, response.getGithubBranches().size());
    }



}
