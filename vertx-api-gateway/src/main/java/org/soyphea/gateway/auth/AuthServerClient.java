package org.soyphea.gateway.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("auth-service")
public interface AuthServerClient{

    @RequestMapping(method = RequestMethod.GET, value = "/uaa/oauth/check_token")
    public ResponseEntity<String> checkToken(@RequestParam("token") String token);

}
