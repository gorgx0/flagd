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


install ingress

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
mvn clean spring-boot:run
```

