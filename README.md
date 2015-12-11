Example Spring Boot application with HTTP-Proxy-Servlet
======================================================

This is example of HTTP-Proxy-Servlet (<https://github.com/mitre/HTTP-Proxy-Servlet>) with Spring Boot (<http://projects.spring.io/spring-boot/>) and Gradle (<http://gradle.org/>)

1. clone repo
2. compile/start application from commond line with `./gradlew bootRun` (linux) `gradlew.bat bootrun` (Windows)
3. open in browser <http://localhost:8008/solr/example/something> - this is location where our example is served
4. open <http://localhost:8008/proxy/example/something> - this is our example served through ProxyServlet

Proxy Servlet with content modification example
===============================================
1. open in browser <http://localhost:8008/replace/example/something> - this is location where our example is served
2. open <http://localhost:8008/contentreplacer/example/something> - this is our example served through ProxyServlet that replaces content matching "proxy.replacer.url_to_replace" application property with "proxy.replacer.url_replacement_value" property value

Proxy Servlet configuration can be found in  "src/main/resources/application.yml" file. 
Servlet itself is configured with spring auto configuration magic and can be found at "src/main/java/org.example.proxyservlet.config=SolrProxyServletConfiguration"