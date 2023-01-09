
# Backend Task

REST API For interacting with the GitHub REST API

## Features

given username and header “Accept: application/json”, 
list of all of his github repositories, which are not forks will returned




## REST Endpoints

## GET
`repsetories by userName` [api/repositories/{userName}](#get-1billingretrieve-billing-datajson) <br/>

**Response**

```
[
    {
        "repositoryName": "Metro",
        "ownerName": "mohamedjo",
        "branches": [
            {
                "name": "YSF-123",
                "lastCommitSHA": "d5cbb5a40e633f41473ea467318cf4328530ac11"
            },
            {
                "name": "master",
                "lastCommitSHA": "4ccc3374ba40e16c29af67353fd78a681f549e9d"
            }
        ]
    },
    {
        "repositoryName": "Onlin-Shopping",
        "ownerName": "mohamedjo",
        "branches": [
            {
                "name": "master",
                "lastCommitSHA": "3fca4c06db8f84e0b8a481abcf5a9ee83bdfc590"
            }
        ]
    },
    {
        "repositoryName": "simple-Launcher-app",
        "ownerName": "mohamedjo",
        "branches": [
            {
                "name": "master",
                "lastCommitSHA": "122110fc7a0142dc4d1e5f58c70962993310d42d"
            }
        ]
    },
    {
        "repositoryName": "SmartRestaurant",
        "ownerName": "mohamedjo",
        "branches": [
            {
                "name": "Confirmation",
                "lastCommitSHA": "2d83292097e2dba082cd0c9cac2e5c8bcb88a7e5"
            },
            {
                "name": "ManagerLogin",
                "lastCommitSHA": "b7483e1ed5578d0265d99f6eaef1d845cdbab3ad"
            },
            {
                "name": "conectUserAndManager",
                "lastCommitSHA": "c85821dc04b093aaba305e6839748f28833e2652"
            },
            {
                "name": "final1",
                "lastCommitSHA": "ea4df3ee28ca65c468a5fb588c97530271c5b009"
            },
            {
                "name": "final2",
                "lastCommitSHA": "f4d78ac296c6f39e300cf229205e78dcb48d40db"
            },
            {
                "name": "master",
                "lastCommitSHA": "a98012df852f6d6d94f10a6c2f6d4b2b89438433"
            },
            {
                "name": "startWorkingOnManager",
                "lastCommitSHA": "71830abee89f9a60077f5e0e14ec41affafe912f"
            },
            {
                "name": "test_merge",
                "lastCommitSHA": "2c165d7323d227879e072bfab68a3d456ed61e7a"
            }
        ]
    },
    {
        "repositoryName": "The-Garduan-News",
        "ownerName": "mohamedjo",
        "branches": [
            {
                "name": "master",
                "lastCommitSHA": "6988c4d24f444efe2aad4fa1581723b04467f5a4"
            }
        ]
    }
]
```
## Technologies Used

- Springboot
- Junit, Mockito,  Mock MVC 
- https://developer.github.com/v3 as a backing API
## Requirements

- JDK 1.8
- Maven 3
## Run Locally


There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the om.cocus.backendTask.BackendTaskApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:


```bash
mvn spring-boot:run
```
