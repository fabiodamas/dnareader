# DNAReader
Technical test for a back-end developer job on Mercado Livre.

REST API that identifies whether a DNA sequence belongs to a human or an ape.

## Getting Started

### Prerequisites
What things you need to install the software and how install them

* Install Java 11 (This project I use ORACLE JDK)

### Installing
* Clone this project repository
* Run ```mvnw clean install && mvnw spring-boot:run``` in the folder ```dnareader``` to start in localhost:5000

## Addresses

### Remote Access: 
> http://xxxxxxxxxxxxxxxxxxxx


### Local Access: 
> http://localhost:5000


---
### URL for test the application
##### /titles
```shell
curl -s http://localhost:5000/xxxxx?s=xxx+xxxx
```

##### /services
```shell
curl -sH 'Content-Type: application/json' http://localhost:5000/xxx
curl -sH 'Content-Type: application/json' http://localhost:5000/xxx -XPOST -d '{"name":"aaaa"}'

```