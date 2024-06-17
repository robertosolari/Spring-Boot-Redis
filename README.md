# Spring-Boot-Redis
Simple demo how to use Redis in Spring Boot application

## Installing Redis with Docker on Windows
This guide will walk you through the process of installing and running Redis using Docker on a Windows machine.

### Prerequisites
Docker Desktop: Ensure you have Docker Desktop installed on your Windows machine. If not, you can download and install it from [Docker's official website](https://www.docker.com/products/docker-desktop/).

### Steps to Install Redis
Step 1: Verify Docker Installation
Open PowerShell or Command Prompt and verify Docker is installed and running by executing:
```
docker --version
```
You should see the Docker version information if Docker is correctly installed.

Step 2: Pull the Redis Docker Image
Pull the latest Redis image from Docker Hub by running the following command:
```
docker pull redis
```
Step 3: Run the Redis Container
Run a Redis container using the pulled image:
```
docker run --name my-redis -d -p 6379:6379 redis
```
- --name my-redis: Names the container my-redis (you can choose any name).
- -d: Runs the container in detached mode (in the background).
- -p 6379:6379: Maps port 6379 on your host to port 6379 in the container.

Step 4: Verify Redis is Running
Check if the Redis container is running by listing all running containers:
```
docker ps
```
You should see the my-redis container listed.

### Common Docker Commands for Redis
Stop the Redis Container:
```
docker stop my-redis
```
Start the Redis Container:
```
docker start my-redis
```
