# blog-spring-api
Backend de um blog com Spring Boot

Use o comando: mvn package -Dmaven.test.skip=true


# Executando o projeto pelo prompt de comando no maven e gerar executavel .jar na pasta target

mvn clean package

![package](./assets/01.png)

<br/>

Inicio dos testes

![inicio-testes](./assets/02.png)

<br/>
Fim dos testes


![fim-testes](./assets/04.png)

<br/>

Rodando o projeto através do executavel .jar na raiz do projeto: blog-spring-api

java -jar target/blog-spring-api-0.0.1.jar

![executavel](./assets/05.png)

![executavel](./assets/06.png)

<br/>

Link para rodar o Swagger

Clique no link: http://localhost:8080/swagger-ui.html

![link](./assets/07.png)

<br/>

![navegador](./assets/08.png)

<br/>

Executando o teste Junit direto no Eclipse no local do arquivo de teste: 

/blog-spring-api/src/test/java/br/com/blogapi/BlogSpringApiApplicationTests.java

![teste-eclipse](./assets/09.png)

<br/>

Resultado dos testes

![resultado](./assets/10.png)


