package com.cassio.workshopmongo.resources;

import com.cassio.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User objTeste1 = new User("1", "Maria Brown", "maria@gmail.com");
        User objTeste2 = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(objTeste1, objTeste2));
        return ResponseEntity.ok().body(list);
    }
}
