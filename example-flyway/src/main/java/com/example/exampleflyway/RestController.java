package com.example.exampleflyway;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestController {

    @Autowired
    private UsersInterface usersInterface;


    @GetMapping("/salvaUser")
    public @ResponseBody ResponseEntity<String> getCount() {
        Users users = new Users();
        users.setId(UUID.randomUUID().toString());
        users.setFirstName("Fernando");
        users.setLastName("Hosida");

        usersInterface.save(users);

        return new ResponseEntity<String>("GET Response: OK ", HttpStatus.OK);
    }


}
