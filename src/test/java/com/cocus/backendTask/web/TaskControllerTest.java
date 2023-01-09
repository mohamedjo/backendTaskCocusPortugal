package com.cocus.backendTask.web;

import com.cocus.backendTask.BackendTaskApplication;
import com.cocus.backendTask.exception.ApplicationExceptionHandler;
import com.cocus.backendTask.exception.custom.UserNotFoundException;
import com.cocus.backendTask.fixture.TaskFixture;
import com.cocus.backendTask.service.TaskServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = BackendTaskApplication.class)
@AutoConfigureMockMvc
public class TaskControllerTest {
    public static final String GET_REPOS_BY_USERNAME_REQUEST_URL_EXAMPLE = "/api/repositories/mohamedjo";
    private MockMvc mockMvc;

    @MockBean
    private TaskServiceImpl taskService;

    @Autowired
    private TaskController taskController;

    @BeforeEach
    public void init() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(taskController)
                .setControllerAdvice(new ApplicationExceptionHandler()).build();
    }

    @Test
    void givenNotValidUserName_whenRequestIsReceived_ThenStatusIs404() throws Exception {
        doThrow(new UserNotFoundException("u")).when(taskService).getAllGitHubReposByUserName(anyString());

        mockMvc.perform(get(GET_REPOS_BY_USERNAME_REQUEST_URL_EXAMPLE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isNotFound());
    }

    @Test
    void givenValidUserName_whenRequestIsReceived_ThenStatusIs200() throws Exception {
        doReturn(TaskFixture.getListOfRepoResponse()).when(taskService).getAllGitHubReposByUserName(anyString());

        mockMvc.perform(get(GET_REPOS_BY_USERNAME_REQUEST_URL_EXAMPLE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isOk());
    }

    @Test
    void givenValidUserNameAnd_whenRequestIsReceived_ThenStatusIs200() throws Exception {
        doReturn(TaskFixture.getListOfRepoResponse()).when(taskService).getAllGitHubReposByUserName(anyString());

        mockMvc.perform(get(GET_REPOS_BY_USERNAME_REQUEST_URL_EXAMPLE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_XML)
                        .content(""))
                .andExpect(status().isNotAcceptable());
    }


}
