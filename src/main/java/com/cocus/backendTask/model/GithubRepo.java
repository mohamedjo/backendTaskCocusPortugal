package com.cocus.backendTask.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GithubRepo {
    @JsonProperty("name")
    String repositoryName;

    @JsonProperty("fork")
    boolean fork;

    @JsonProperty("owner")
    Owner owner;


}
