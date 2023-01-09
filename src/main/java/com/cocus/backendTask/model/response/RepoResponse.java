package com.cocus.backendTask.model.response;

import com.cocus.backendTask.model.Owner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepoResponse {

    private String repositoryName;
    private String ownerName;

    private List<BranchResponse> branches;

}
