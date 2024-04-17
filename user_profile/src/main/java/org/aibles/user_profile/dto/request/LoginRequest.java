package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

  @NotBlank(message = "Username cannot blank")
  private String username;
  @NotBlank(message = "Password cannot blank")
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
