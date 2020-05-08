package com.socialservice.auth;

import com.socialservice.constants.admin.Constants;
import com.socialservice.exceptions.UnauthorizedAccessException;
import com.socialservice.utils.RequestUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ClientAuthInterceptor {

  @Autowired
  RequestUtil requestUtil;

  @Before("@within(com.socialservice.auth.AuthenticateClient) "
      + "|| @annotation(com.socialservice.auth.AuthenticateClient)")
  public void validate(JoinPoint jp) throws UnauthorizedAccessException {
    String clientToken = requestUtil.getHeader("Authorization");
    if (clientToken == null) {
      throw new UnauthorizedAccessException("Authorization not present");
    }
    if(!Constants.AUTHORIZATION.equals(clientToken)){
        throw new UnauthorizedAccessException("Authorization not present");
    }
  }
}
