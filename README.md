# DNAReader
Teste técnico para vaga de desenvolvedor back-end no Mercado Livre.

API REST que identifica se uma sequência de DNA pertence a um humano ou a um símio.

## Introdução
Este projeto é uma API Rest, que usa Java com o framework Spring Boot.
O DNA recebido pela API é validado de acordo com as bases nitrogendas (A, T, G e C) válidas. Após receber o DNA, ocorre uma validação, informando se o DNA é de um símio ou de um humano.

## Endereço da aplicação:
> http://ec2-54-221-88-1.compute-1.amazonaws.com:8080

## Endpoints
* http://ec2-54-221-88-1.compute-1.amazonaws.com:8080/simian (POST) 
Esse endpoint recebe como parâmetro um JSON com a sequência de DNA. A sequência de DNA é composta por bases hidrogenadas: **A, T, G e C**.
Na tabela abaixo há uma amostra de como é uma sequência de um Humano e a de um Símio. 
 
<img src = "https://i.ibb.co/3BMJhhJ/tabela.png">

Esse endpoint retorna um JSON com o resultado da validação.



* http://ec2-54-221-88-1.compute-1.amazonaws.com:8080/stats (GET)
Retorna um JSON com as estatísticas da API. Essa estatística é feita a partir de uma contagem no banco de dados.  
A seguir um exemplo da resposta:

{"count_simian_dna": 40, "count_human_dna": 100: "ratio": 0.4}
 
* Swagger:
Para uma melhor visualização dos enpoints, acesse a documentação da API pelo Swagger:
 http://ec2-54-221-88-1.compute-1.amazonaws.com:8080

## Tecnologias 
* Desenvolvimento: Spring Boot, Java 11
* Build: Maven
* Deploy: Aws Ecs, Aws Fargate, Docker
* Documentação da API: Swagger
* Base de dados Desenvolvimento: H2
* Base de dados Produção: Mysql

## Execução local
* Clone este repositório
* Execute ```mvnw clean install && mvnw spring-boot:run``` na pasta ```dnareader``` para iniciar em localhost:8080



