package com.example.demo.registration;

import lombok.AllArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping(path = "/register")
    public JSONObject register(RegistrationRequest request){

        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
    @PostMapping(path = "/login")
    public JSONObject logintest(@RequestParam(value="username") String isMatch ,@RequestParam(value ="password") String token) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isMatch", true);
        jsonObject.put("token", "test");
        return  jsonObject;
    }

}
