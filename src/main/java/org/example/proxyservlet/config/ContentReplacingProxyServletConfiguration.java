package org.example.proxyservlet.config;

import org.example.proxyservlet.contentreplacer.ContentReplacingProxyServlet;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ContentReplacingProxyServletConfiguration implements EnvironmentAware {

  private static final String ENV_PROXY_REPLACER = "proxy.replacer.";

  @Bean
  public ServletRegistrationBean contentReplacingServletRegistrationBean() {
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new ContentReplacingProxyServlet(), propertyResolver.getProperty("servlet_url"));
    servletRegistrationBean.addInitParameter("targetUri", propertyResolver.getProperty("target_url"));
    servletRegistrationBean.addInitParameter(ContentReplacingProxyServlet.P_LOG, propertyResolver.getProperty("logging_enabled", "false"));
    servletRegistrationBean.addInitParameter(ContentReplacingProxyServlet.P_URL_TO_REPLACE, propertyResolver.getProperty("url_to_replace"));
    servletRegistrationBean.addInitParameter(ContentReplacingProxyServlet.P_URL_REPLACEMENT_VALUE, propertyResolver.getProperty("url_replacement_value", ""));
    return servletRegistrationBean;
  }

  private RelaxedPropertyResolver propertyResolver;

  @Override
  public void setEnvironment(Environment environment) {
    this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_PROXY_REPLACER);
  }
}
