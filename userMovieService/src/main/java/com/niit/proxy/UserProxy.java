package com.niit.proxy;

import com.niit.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * UserProxy class which uses Feign client to communicate to userAuthenticate microservice.
 */
@FeignClient(name = "user-authentication-service" ,url = "localhost:8085")
public interface UserProxy {
    /**
     *
     * @param user
     * @return Response entity containing the saved user which is returned from user-authentication-service
     */
    @PostMapping("/api/v1/register")
    public ResponseEntity<?> save (@RequestBody User user);
}
