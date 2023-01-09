package com.cocus.backendTask.model.response;

import com.cocus.backendTask.model.Owner;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RepoResponse {

    String repositoryName;
    Owner owner;

    List<BranchResponse> branches;

}
