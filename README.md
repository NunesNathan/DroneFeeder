# Olá, seja bem vindo ao projeto Drone Feeder

## Objetivo
  O objetivo do Drone Feeder era desenvolver um backend para um aplicativo de entregas com drone. A API conta com um sistema de inserção, leitura, atualização e remoção de drones e entregas.
  
  É possível também a inserção de direct links de videos de confirmação das entregas.

### As tecnologias selecionadas foram:
  * Java 11
  * Spring-boot
  * Docker
  * MySQL
  * Checkstyle
  * Swagger

## O que foi entregue
### Além das rotas esperadas para um crud, a API prevê a necessidade de: 
* Recuperar a lista de links de confirmação de entrega;
* Atualização de status da entrega, podendo ou não adicionar o link de confirmação em caso de entrega efetuada;
* Listagem de entregas referente a um drone;
* Recuperar um drone a partir de uma entrega;
* Guardar a última checagem de componentes do drone.

## Como utilizar

Obs.: Afim de facilitar a utilização da API, ela foi pensada para rodar com docker-compose.
1) Faça o clone da aplicação;
2) Entre na pasta clonada;
3) ```docker-compose up```no terminal começará a orquestração dos containers docker;
4) O banco de dados estará na porta 3306;
5) A aplicação estará na porta 8080;
6) Na rota "/" estará a documentação com todos os endpoints da aplicação.

### Finalização

Esse projeto foi desenvolvido sem nenhum propósito além de praticar spring-boot, docker e REST api em Java.

Desenvolvido baseado no tema 1, dentre os dois disponíveis, como projeto final da aceleração da [Trybe](https://www.betrybe.com/) em parceria com a [Wipro](https://www.linkedin.com/company/wipro/?originalSubdomain=br).

Toda e qualquer consideração será bem vinda! :)
