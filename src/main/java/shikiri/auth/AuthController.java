package shikiri.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "shikiri-auth")
public interface AuthController {

    @PostMapping("/auth/register")
    ResponseEntity<?> create (
        @RequestBody(required = true) RegisterIn in
    );

    @PostMapping("/auth/login")
    ResponseEntity<LoginOut> authenticate (
        @RequestBody(required = true) CredentialIn in
    );

    @PostMapping("/auth/solve")
    ResponseEntity<SolveOut> solve (
        @RequestBody(required = true) SolveIn in
    );

}