package com.cocus.backendTask.client;

import com.cocus.backendTask.client.vo.GitHubServiceGetAllRepoVO;
import com.cocus.backendTask.exception.custom.UserNotFoundException;
import com.cocus.backendTask.model.GithubRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.cocus.backendTask.fixture.TaskFixture.getGithubReposResponeArray;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class GitHubServiceClientTest {

    public static final String GET_REPOS_FROM_GITHUB_SERVCE_URL_EXAMPLE = "https://api.github.com/users/mohamedJo/repos";
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private GitHubServiceClientImpl classUnderTest;

    @Test
    void givenValidUserNameAndBranch_whenGetAllReposByUsername_thenReturnArrayOfGithubRepos() {


        GithubRepo[] githubRepos = getGithubReposResponeArray();
        when(restTemplate.getForObject(eq(GET_REPOS_FROM_GITHUB_SERVCE_URL_EXAMPLE), eq(GithubRepo[].class)))
                .thenReturn(githubRepos);


        GitHubServiceGetAllRepoVO response = classUnderTest.getAllRepos("mohamedJo");

        assertNotNull(response.getGithubRepoList());
        assertEquals(githubRepos.length, response.getGithubRepoList().size());
    }

    @Test
    void givenNotValidUserNAme_whenGetAllReposByUsername_thenThrowUserNotFoundException() {


        when(restTemplate.getForObject(eq(GET_REPOS_FROM_GITHUB_SERVCE_URL_EXAMPLE), eq(GithubRepo[].class)))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));



        assertThrows(UserNotFoundException.class, ()->classUnderTest.getAllRepos("mohamedJo"));
    }


}
