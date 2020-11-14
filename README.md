# Betha Fullstack Challenge

## Como rodar o projeto

### App

```sh
cd packages/app
yarn
yarn start
```

Deps:

- nodejs 8 (ou superior)
- yarn +1.22 ou npm +3.5.2 (ou superior)

Obs: Podem ocorrer problemas na hora de instalar as dependencias. Isso dependende do seu sistema operacional, uma dica rapida e fácil é: Se tiver problemas utilize `yarn install --ignore-engines`

### Server

```sh
cd packages/server
./mvnw spring-boot:run
```

As seguintes variaveis devem ser configuradas em ``application.propertioes`

- spring.datasource.url=
- spring.datasource.username=
- spring.datasource.password=

Deps:

- JDK

  - openjdk version "11.0.9.1" 2020-11-04
  - OpenJDK Runtime Environment (build 11.0.9.1+1-Ubuntu-0ubuntu1.18.04)
  - OpenJDK 64-Bit Server VM (build 11.0.9.1+1-Ubuntu-0ubuntu1.18.04, mixed mode, sharing)

- Postgressql 10.14
- Apache Maven 3.6.0
