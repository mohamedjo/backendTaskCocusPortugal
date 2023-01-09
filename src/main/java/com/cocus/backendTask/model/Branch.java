package com.cocus.backendTask.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Branch {
    @JsonProperty("name")
    String name;
    Commit commit;
}
