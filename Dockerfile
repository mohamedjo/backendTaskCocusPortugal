FROM openjdk:19
EXPOSE 8080
ADD target/backend-task-youssef-docker.jar backend-task-youssef-docker.jar
ENTRYPOINT ["java","-jar","/backend-task-youssef-docker.jar"]