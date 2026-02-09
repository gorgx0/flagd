# flagd demo README.md

## steps

1. start minikube
```bash
minikube start --extra-config=kubelet.sync-frequency=10s
```

2. install traefik
```bash
helm install traefik traefik/traefik -f traefik/custom-values.yaml
```
> **Note:** check custom-values.yaml for the tcp port treafik web is exposed on minikube (it defaults to 30080)

> **Note:** to open traefik dashoard 
```shell
kubectl port-forward deployments/traefik 8082:8080
```
> and open http://localhost:8082/dashboard/

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
cd demo-app
mvn -f demo-app/pom.xml  clean spring-boot:run
```

open demo page at http://localhost:8080

## k8s

set minikube docker env
```shell
eval $(minikube docker-env)
```

create app image
```shell
docker build -t flagd-demo-app:0.0.1 demo-app/.
```

deploy app to k8s
```shell
kubectl apply -f demo-app/k8s/01-deployment.yaml
```

open demo page at http://192.168.112.2:30088/ (or check your minikube ip)

## local app with flagd in k8s

make sure the /etc/hosts contain the minikube ip
with the following names  
```
resolve.flagd.minikube  
sync.flagd.minikube  
```

to obtain minikube ip
```shell
minikube ip
```

run demo app with _k8s-out_ profile
```shell
mvn -f demo-app/pom.xml clean spring-boot:run -Dspring-boot.run.profiles=k8s-out
```

open demo page at http://localhost:8080
