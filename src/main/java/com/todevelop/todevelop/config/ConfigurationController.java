package com.todevelop.todevelop.config;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.todevelop.todevelop.routes.RoutesApp.ROUTE_API_PUBLIC;

@RestController()
@RequestMapping(ROUTE_API_PUBLIC)
@AllArgsConstructor
public class ConfigurationController {

    private final SessionRegistry sessionRegistry;

    @GetMapping()
    public ResponseEntity<?> getDetailsSession(){

        var sessionId = "";
        User user = null;
        var sessions = sessionRegistry.getAllPrincipals();
        var response = new HashMap<String,Object>();

        for(Object session : sessions){
            if(session instanceof User){
                user = (User) session;
            }
            var sessionInform = sessionRegistry.getAllSessions(user,false);

            for(SessionInformation sessionInformation : sessionInform){
                sessionId = sessionInformation.getSessionId();
            }
        }
        response.put("sessionId", sessionId);
        response.put("user", user);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/index")
    public String getSessions(){
        return "Hello World";
    }
}
