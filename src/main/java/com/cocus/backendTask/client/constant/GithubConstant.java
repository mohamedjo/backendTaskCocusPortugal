package com.cocus.backendTask.client.constant;

public class GithubConstant {
    public static final String USER_CONSTANT = "{USER}";
    public static final String REPO_CONSTANT = "{REPO}";
    public static final String GITHUB_API_BASE_URL = "https://api.github.com/";
    public static final String USER_REPOS_GET_PATH = "users/" + USER_CONSTANT + "/repos";
    public static final String REPO_BRANCHES_GET_PATH = "repos/" + USER_CONSTANT + "/" + REPO_CONSTANT + "/branches?";


}
