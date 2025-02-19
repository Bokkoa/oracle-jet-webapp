package schedule;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
 
public class CrossDomainFilter implements ContainerResponseFilter {
 
  @Override
      public ContainerResponse filter(ContainerRequest creq, ContainerResponse cres) {
          cres.getHttpHeaders().add("Access-Control-Allow-Origin", "*");
          cres.getHttpHeaders().add("Access-Control-Max-Age", "28800"); // 8 hours cache
          cres.getHttpHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, xtoken");
          cres.getHttpHeaders().add("Access-Control-Allow-Credentials", "true");
          cres.getHttpHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
          return cres;
      }
 
}