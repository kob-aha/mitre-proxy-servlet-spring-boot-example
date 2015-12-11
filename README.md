Example Spring Boot application with HTTP-Proxy-Servlet
======================================================

This is example of HTTP-Proxy-Servlet (<https://github.com/mitre/HTTP-Proxy-Servlet>) with Spring Boot (<http://projects.spring.io/spring-boot/>) and Gradle (<http://gradle.org/>)

1. clone repo
2. compile/start application from commond line with `./gradlew bootRun` (linux) `gradlew.bat bootrun` (Windows)
3. open in browser <http://localhost:8008/solr/example/something> - this is location where our example is served
4. open `http://localhost:8008/proxy/example/something` - this is our example served through ProxyServlet