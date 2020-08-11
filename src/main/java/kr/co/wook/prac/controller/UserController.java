package kr.co.wook.prac.controller;

import kr.co.wook.prac.model.User;
import kr.co.wook.prac.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService ;

    @CrossOrigin
    @PostMapping("")
    public void InsertUser (User user){
        userService.userInsert(user);
    }

}
