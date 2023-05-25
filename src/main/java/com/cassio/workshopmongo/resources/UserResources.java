package com.cassio.workshopmongo.resources;

import com.cassio.workshopmongo.domain.User;
import com.cassio.workshopmongo.dto.UserDTO;
import com.cassio.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list
                                .stream()
                                .map(x -> new UserDTO(x))
                                .toList();
        return ResponseEntity.ok().body(listDto);
    }
}
