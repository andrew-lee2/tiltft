# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.6.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### To start app
`./mvnw spring-boot:run`

### Run tests 
`./mvnw test`

### Riot API Key
In order for this project to pull data, need to get a [Riot API Key](https://developer.riotgames.com/docs/portal#web-apis_api-keys)

Add environmental vars in `.env`:
* `RIOT_API_KEY`: riot api key from above
 
 `export $(cat .env | xargs)` to export variables to environment