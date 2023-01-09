package com.cocus.backendTask.helper;

import com.cocus.backendTask.model.GithubBranch;
import com.cocus.backendTask.model.GithubRepo;
import com.cocus.backendTask.model.response.BranchResponse;
import com.cocus.backendTask.model.response.RepoResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskServiceHelper {
    public static List<BranchResponse> getBranchResponseList(List<GithubBranch> githubBranchList) {
        List<BranchResponse> branchResponseList = new ArrayList<>();
        for (GithubBranch githubBranch : githubBranchList) {
            BranchResponse branchResponse = githupBranchToBranchResponse(githubBranch);
            branchResponseList.add(branchResponse);
        }
        return branchResponseList;
    }

    public static RepoResponse gitHupRepoToRepoResponse(GithubRepo githubRepo) {
        RepoResponse repoResponse = new RepoResponse();
        repoResponse.setRepositoryName(githubRepo.getRepositoryName());
        repoResponse.setOwnerName(githubRepo.getOwner().getLoginName());
        return repoResponse;
    }

    public static BranchResponse githupBranchToBranchResponse(GithubBranch githubBranch) {
        BranchResponse branchResponse = new BranchResponse();
        branchResponse.setName(githubBranch.getName());
        branchResponse.setLastCommitSHA(githubBranch.getCommit().getLastCommitSHA());
        return branchResponse;
    }
}
