package com.cocus.backendTask.service;

import com.cocus.backendTask.client.GitHubServiceClient;
import com.cocus.backendTask.client.vo.GitHubServiceGetAllRepoVO;
import com.cocus.backendTask.fixture.TaskFixture;
import com.cocus.backendTask.helper.TaskServiceHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private GitHubServiceClient gitHubServiceClient;

    @InjectMocks
    private TaskServiceImpl classUnderTest;

    @Test
    void givenUserName_whenGetAllGitHubReposByUserName_thenGetAllReposAndGetAllBranchesAreCalled() throws JsonProcessingException {
        when(gitHubServiceClient.getAllRepos("mohamedjo")).thenReturn(new GitHubServiceGetAllRepoVO(TaskFixture.getListOfGithubRepos()));

        classUnderTest.getAllGitHubReposByUserName("mohamedjo");

        verify(gitHubServiceClient, times(1)).getAllRepos(eq("mohamedjo"));
        verify(gitHubServiceClient, times(2)).getAllBranches(eq("mohamedjo"), anyString());

    }

    @Test
    void givenUserNameAndReturnedReposAllForked_whenGetAllGitHubReposByUserName_thenGetAllReposIsCalledAndGetAllBranchesNotCalled() throws JsonProcessingException {
        when(gitHubServiceClient.getAllRepos("mohamedjo")).thenReturn(new GitHubServiceGetAllRepoVO(TaskFixture.getListOfGithubReposAllForked()));

        classUnderTest.getAllGitHubReposByUserName("mohamedjo");

        verify(gitHubServiceClient, times(1)).getAllRepos(eq("mohamedjo"));
        verify(gitHubServiceClient, times(0)).getAllBranches(eq("mohamedjo"), anyString());

    }
}
