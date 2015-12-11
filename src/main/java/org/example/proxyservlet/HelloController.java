package org.example.proxyservlet;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @RequestMapping("/")
  public String index() {
    return "Greetings from Spring Boot!";
  }

  @RequestMapping("/solr/example/{path}")
  public String solrExample(@PathVariable String path) {
    return "Greetings from " + path;
  }

  @RequestMapping("/replace/example/{path}")
  public String replacementExample(@PathVariable String path) {
    return "Greetings from " + path + "! this url http://some.internal.server/solr/ should be replaced when queried through proxy.";
  }

}