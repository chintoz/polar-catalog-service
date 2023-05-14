# Polar Catalog Service

This project is part of the examples created in the scope of the book **Cloud Native Spring in Action**.

## Launch local environment

To build it locally:

```shell
> mvn clean package
```

## Dockerize it

To dockerize it we could do it using the comand:

```shell
> mvn spring-boot:build-image 
```

The image created will be this one:

```shell
> docker image list polar-catalog-service
REPOSITORY              TAG              IMAGE ID       CREATED        SIZE
polar-catalog-service   0.0.1-SNAPSHOT   37c802844c2d   43 years ago   279MB
```

To execute it locally, it could be launched using the command:

```shell
> docker run --rm --name polar-catalog-service -p 8080:8080 polar-catalog-service:0.0.1-SNAPSHOT
```