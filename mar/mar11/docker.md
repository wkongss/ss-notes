## Docker

**Docker** is a containerization platform that allows for the building of consistent virtual environments to run and deploy our software packages. This provides:
- **Portability** of applications, so they may be deployed from multiple destinations
- **Consistency** and **isolation** of deployment environments
- A more **lightweight** solution compared to spinning up a VM to ensure environment parity

The core themes of environment consistency aids developers at all points: development, testing, and deployment.
 - Example: you can define your environment during development and during cloud deployment, rebuild it in the cloud.

### Docker Structure

The **Docker Daemon** (`dockerd`) operates as a middleman between a client (requestor) and a server (registry).

The **Docker Client** (`docker` through the CLI) is the way we interact with Docker by sending HTTP requests to the Daemon.

**Docker Desktop** is the entirety of the Docker ecosystem in a simple package, containing `dockerd`, `docker`, `docker compose`,

The **Docker Registry** is where you pull your images from and can either be private or public like with [Docker Hub](https://hub.docker.com/).

Reference: https://docs.docker.com/get-started/docker-overview/

### Docker Objects

Docker's purpose is to allow you to manage objects including:
#### Images

An **image** is a template for how to build an environment, defined by a `Dockerfile`. Images are stored in registries and pulled and ran when needed.
#### Containers

If an image is a blueprint for the house, a **container** is the house made from that image. In other words, it's an *instance* of the image.
#### Volumes

**Volumes** are persistent storages that can be *mounted* to containers. As they are separate objects from containers, their lifecycle is separated, and as such, will exist even after the mounted container is terminated.
 - Volumes dynamically grow and shrink based on storage needs. They, by default, do not have a maximum size, and must be configured to not overconsume resources.

### The Docker Client

Docker provides a client with CLI commands to interact with the Daemon. Here are the most important:

#### Docker Pull

Also aliased as `docker pull`. Pulls an image from a registry - first tries locally before going to a remote registry like DockerHub. If the version isn't specified, then uses `latest`.

```bash
docker image pull <image-name>:<version>
```
#### Docker Commit

Also aliased as `docker commit`. Commits a container to an image.

```
docker container commit <container-id> <image-name>:<version>
```
#### Docker Push

Also aliased as `docker push`. Pushes an image to a local or remote registry such as Docker Hub.

```
docker image push <registry>/<username>/<image-name>:<version>
```
#### Docker Build

Also aliased as `docker build`. Builds an image from a Dockerfile.

```
docker image build <dockerfile-path>
```
#### Docker Run

Also aliased as `docker run`. Pulls the image if necessary and creates it.
Flags:
 - `-i` - Make the container interactive
 - `-t` - Allow for teletype (terminal interaction)
 - `-it` - Combination of `-i` and `-t`
 - `-d` - Detatch the container to run in the background (doesn't block your terminal)
 - `-e` - Declare environment variables
 - `--name <name>` - Give your container a custom name
 - `-v <volume-name>/:mnt <image-hash>` - Mount a volume to the container

```
docker container run <image-name>
```
#### Docker Stop

Also aliased as `docker stop`. Stops a container.

```
docker container stop <container-id>
```
#### Docker Start

Also aliased as `docker start`. Restarts a stopped container.

```
docker container start <container-id>
```
#### Docker Remove

Also aliased as `docker rm` for containers. Deletes a container. To remove an image or volume, replace `container` with `image` or `volume` respectively.

```
docker container rm <container-id>
```
#### Docker List

Also aliased as `docker ps`. Lists all created containers. To all images or volumes, replace `container` with `image` or `volume` respectively.

```
docker container ls
```

#### Docker Volume Create

Creates a volume to mount to a container.

```
docker volume create <volume-name>
```
## Dockerfiles

Dockerfiles are how we define images.
They contain sequential commands called **instructions** that declare how an image is built. The following are generally the most important instructions to know:

 - `FROM <image>`  - Set a base image to build off of. Can also include the `--platform` flag to set a different target platform depending on your CPU architecture.
 - `LABEL <metadata>` - Add some metadata to your image.
 - `RUN <cmd>` - Runs a shell command within the image.
 - `COPY <local-path> <remote-path>` - Copies files from the local path of the Dockerfile to the remote path within the image. 
 - `WORKDIR <path>` - Sets the working directory of the image.
 - `ENTRYPOINT [cmd, ...args]` - Sets a command to run when the container starts (i.e ["node", "index.js"]).

Example Dockerfile:

```dockerfile
# Starts with Node v22 on the Alpine distro of Linux
FROM node:22-alpine

# Copies all files from current local directory to current directory in image
COPY . .

# Moves working directory to /src/backend
WORKDIR /src/backend

# Runs a shell command to install dependencies
RUN npm install

# Tells the image to rune node index.js on start
ENTRYPOINT ["node", "index.js"]
```

Reference: https://docs.docker.com/get-started/docker-concepts/building-images/writing-a-dockerfile/

## Docker Compose

Sometimes, we want to run multiple containers for our application. Docker compose is an extension that allows us to do this.

To get started, create a `compose.yaml` file. Compose will also accept `compose.yml`, `docker-compose.yaml`, or `docker-compose.yml`, but `compose.yaml` is the preferred file name.

Within your `compose.yaml`, define the following:

1. The `version` of compose you're using.
2. Any containers you wish to build and coordinate under `services` 
	- This includes images (use an existing `image` or `build` from a Dockerfile), ports, networks, and container dependencies.
3. The `volumes` used by the containers.
4. The `networks` the containers use to communicate with each other.

Example:

```YAML
# Defines the version
version: "3.8"

# Defines containers here
services:
    # Defines the frontend container
    frontend:
        build: ./frontend
        ports:
            - "5137:5137"

    # Defines the backend API container
    backend:
        build: /backend
        ports:
            - "8080:8080"
        networks:
            - "db-network"
        # Needs db container to be active
        depends-on: "db"
    
    # Defiens the database container
    db:
        image: "mysql:latest"
        environment:
            - "MYSQL_DATABASE=ProductionStockDB"
            - "MYSQL_PASSWORD=${DB_PASSWORD}"
            - "MYSQL_ROOT_PASSWORD=${DB_PASSWORD}"
            - "MYSQL_USER=${DB_USERNAME}"
        ports:
            - "3307:3306"
        volumes:
            - "mysql-volume:/var/lib/mysql"
        networks:
            - "db-network"

volumes:
    mysql-volume:

networks:
    db-network:
```

Then, the start your multi-container application, use `docker compose up`.
Likewise, to stop your application, use `docker compose down`.

Reference: https://docs.docker.com/compose/