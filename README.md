# flagd demo README.md

## steps

1. start minikube
```bash
minikube start
```

2. install traefik
```bash
helm install traefik traefik/traefik -f traefik/custom-values.yaml
```
> **Note:** check custom-values.yaml for the tcp port treafik web is exposed on minikube (it defaults to 30080)

3. install flagd

create configmap for flagd

```shell
kubectl create configmap --from-file=flags.json=flagd/flags_2.json flagd-config
```

install flagd

```shell
kubectl apply -f flagd/02_deploy.yaml
```


create ingress route

```shell
kubectl apply -f flagd/03_ingress.yaml
```
## local 

start flagd locally

```shell
flagd start -f file:./flagd/flags_2.json -g 8015 -p 8013 -x
```

build and run demo app

```shell
cd demoApp
mvn -f demoApp/pom.xml  clean spring-boot:run
```

open demo page at http://localhost:8080

## k8s

set minikube docker env
```shell
eval $(minikube docker-env)
```

create app image
```shell
docker build -t flagd-demo-app:0.0.1 demoApp/.
```

deploy app to k8s
```shell
kubectl apply -f demoApp/02_deploy.yaml
```

open demo page at http://localhost:30088

