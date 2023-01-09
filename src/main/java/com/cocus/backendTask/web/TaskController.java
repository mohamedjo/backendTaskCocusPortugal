package com.cocus.backendTask.web;

import com.cocus.backendTask.model.response.RepoResponse;
import com.cocus.backendTask.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
public class TaskController {


    @Autowired
    TaskService taskService;

    @GetMapping("/repositories/{userName}")
    public ResponseEntity<List<RepoResponse>> getRepositoriesByUserName(@PathVariable @NonNull String userName) {
        log.info("Retrieve Repositories list for userName {}", userName);
        List<RepoResponse> responseList = taskService.getAllGitHubReposByUserName(userName);

        return ResponseEntity.ok().body(responseList);
    }

}
