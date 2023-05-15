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

## Kubernetes it

To launch the dockerized version in kubernetes we have to launch following commands.

First, we have to load the docker image in minikube cluster

```shell
> minikube image load polar-catalog-service:0.0.1-SNAPSHOT
```

After that a deployment could be launched:

```shell
> kubectl create deployment polar-catalog-service --image=polar-catalog-service:0.0.1-SNAPSHOT
```

Deployments and PODs are available

```shell
> kubectl get deployment
NAME                    READY   UP-TO-DATE   AVAILABLE   AGE
polar-catalog-service   1/1     1            1           39s

> kubectl get pods
NAME                                     READY   STATUS    RESTARTS   AGE
polar-catalog-service-84d6bc98bf-tsm7c   1/1     Running   0          44s
```

After that the deployment can be exposed

```shell
> kubectl expose deployment polar-catalog-service --name=polar-catalog-service --port=8080
```

Then a service is created

```shell
> kubectl get service polar-catalog-service
NAME                    TYPE        CLUSTER-IP     EXTERNAL-IP   PORT(S)    AGE
polar-catalog-service   ClusterIP   10.98.42.194   <none>        8080/TCP   44s
```

Lastly, the port forwarding could be defined to access to the application deployed. In this concrete example we are going to forward from 8000 (External)
to 8080 (Internal)

```shell
> kubectl port-forward service/polar-catalog-service 8000:8080
```

For cleaning up the resources in the kubernetes cluster:

```shell
> kubectl delete service polar-catalog-service
> kubectl delete deployment polar-catalog-service
```