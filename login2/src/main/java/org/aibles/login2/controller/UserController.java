package org.aibles.login2.controller;


import lombok.RequiredArgsConstructor;
import org.aibles.login2.dto.UserCreateRequest;
import org.aibles.login2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  @PostMapping
  public ResponseEntity createUser (@RequestBody UserCreateRequest userCreateRequest) {
    userService.createUser(userCreateRequest);
    return ResponseEntity.ok().build();
  }
}
