Example Spring Boot application with HTTP-Proxy-Serlet
======================================================

1. clone repo
2. start application `./gradlew bootRun` (linux) `gradlew.bat bootrun` (Windows)
3. open in browser <http://localhost:8008/solr/example/something> - this is location where our example is served
4. open `http://localhost:8008/proxy/example/something` - this is our example served through ProxyServlet