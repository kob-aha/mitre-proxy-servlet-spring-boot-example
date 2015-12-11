package org.example.proxyservlet.config;

import org.mitre.dsmiley.httpproxy.ProxyServlet;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SolrProxyServletConfiguration implements EnvironmentAware {

  private static final String ENV_PROXY_SOLR = "proxy.solr.";

  @Bean
  public ServletRegistrationBean solrServletRegistrationBean(){
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ProxyServlet(), propertyResolver.getProperty("servlet_url"));
    servletRegistrationBean.addInitParameter("targetUri", propertyResolver.getProperty("target_url"));
    servletRegistrationBean.addInitParameter(ProxyServlet.P_LOG, propertyResolver.getProperty("logging_enabled", "false"));
    return servletRegistrationBean;
  }

  private RelaxedPropertyResolver propertyResolver;

  @Override
  public void setEnvironment(Environment environment) {
    this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_PROXY_SOLR);
  }
}