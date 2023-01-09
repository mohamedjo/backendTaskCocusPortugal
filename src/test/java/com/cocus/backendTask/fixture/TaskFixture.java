package com.cocus.backendTask.fixture;

import com.cocus.backendTask.TestUtils;
import com.cocus.backendTask.model.GithubRepo;
import com.cocus.backendTask.model.Owner;
import com.cocus.backendTask.model.response.RepoResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

public class TaskFixture {

    public static List<RepoResponse> getListOfRepoResponse() throws JsonProcessingException {
        String singleResponse = "{\n" +
                "        \"repositoryName\": \"Metro\",\n" +
                "        \"ownerName\": \"mohamedjo\",\n" +
                "        \"branches\": [\n" +
                "            {\n" +
                "                \"name\": \"YSF-123\",\n" +
                "                \"lastCommitSHA\": \"d5cbb5a40e633f41473ea467318cf4328530ac11\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\": \"master\",\n" +
                "                \"lastCommitSHA\": \"4ccc3374ba40e16c29af67353fd78a681f549e9d\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }";
        RepoResponse repoResponse = TestUtils.getMapper().readValue(singleResponse, RepoResponse.class);

        List<RepoResponse> repoResponseList = new ArrayList();
        repoResponseList.add(repoResponse);


        return repoResponseList;


    }

    public static List<GithubRepo> getListOfGithubRepos() throws JsonProcessingException {
        GithubRepo githubRepo=new GithubRepo();
        githubRepo.setOwner(new Owner("mohamedjo"));
        githubRepo.setRepositoryName("Metro");
        githubRepo.setFork(false);
        GithubRepo githubRepo2=new GithubRepo();
        githubRepo2.setOwner(new Owner("mohamedjo"));
        githubRepo2.setRepositoryName("jax");
        githubRepo2.setFork(false);
        List<GithubRepo> githubRepoList = new ArrayList<>();
        githubRepoList.add(githubRepo);
        githubRepoList.add(githubRepo2);

        return githubRepoList;

    }

    public static List<GithubRepo> getListOfGithubReposAllForked() throws JsonProcessingException {
        GithubRepo githubRepo=new GithubRepo();
        githubRepo.setOwner(new Owner("mohamedjo"));
        githubRepo.setRepositoryName("Metro");
        githubRepo.setFork(true);
        GithubRepo githubRepo2=new GithubRepo();
        githubRepo2.setOwner(new Owner("mohamedjo"));
        githubRepo2.setRepositoryName("jax");
        githubRepo2.setFork(true);
        List<GithubRepo> githubRepoList = new ArrayList<>();
        githubRepoList.add(githubRepo);
        githubRepoList.add(githubRepo2);


        return githubRepoList;

    }
    public static GithubRepo[] getGithubReposResponeArray() {
        GithubRepo[] githubRepos = new GithubRepo[2];

        GithubRepo githubRepo = new GithubRepo();
        githubRepo.setFork(false);
        githubRepo.setRepositoryName("metro");
        githubRepo.setOwner(new Owner("mohamedjo"));
        GithubRepo githubRepo2 = new GithubRepo();
        githubRepo2.setFork(false);
        githubRepo2.setRepositoryName("Jax");
        githubRepo2.setOwner(new Owner("mohamedjo"));
        githubRepos[0] = githubRepo;
        githubRepos[1]= githubRepo;
        return githubRepos;
    }

}
