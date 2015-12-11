package org.example.proxyservlet.contentreplacer;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.mitre.dsmiley.httpproxy.ProxyServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class ContentReplacingProxyServlet extends ProxyServlet {

  public static final String P_URL_TO_REPLACE = "url_to_replace";
  public static final String P_URL_REPLACEMENT_VALUE = "url_replacement_value";

  private Map<byte[], byte[]> replacements = new HashMap<>();

  @Override
  public void init() throws ServletException {
    super.init();

    String urlToBeReplaced = getConfigParam(P_URL_TO_REPLACE);
    if (urlToBeReplaced != null) {
      try {
        replacements.put(urlToBeReplaced.getBytes("UTF-8"), getConfigParam(P_URL_REPLACEMENT_VALUE).getBytes("UTF-8"));
      }
      catch (UnsupportedEncodingException e) {
        throw new ServletException(e);
      }
    }
  }

  @Override
  protected void copyResponseEntity(HttpResponse proxyResponse, HttpServletResponse servletResponse) throws IOException {
    HttpEntity entity = proxyResponse.getEntity();
    if (entity != null) {
      try (ReplaceFilterInputStream in = new ReplaceFilterInputStream(entity.getContent(), replacements)) {
        IOUtils.copy(in, servletResponse.getOutputStream());
      }
    }
  }

}
