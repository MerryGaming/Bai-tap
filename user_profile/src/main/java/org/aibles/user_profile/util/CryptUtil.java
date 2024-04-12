package org.aibles.user_profile.util;

import java.util.Base64;
import java.util.UUID;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CryptUtil {

  private static final BCryptPasswordEncoder B_CRYPT_ENCODER = new BCryptPasswordEncoder();

  public static PasswordEncoder getPasswordEncoder() {
    return B_CRYPT_ENCODER;
  }

  public static String generateResetKey(String username) {
    var uuid = UUID.randomUUID().toString();
    return Base64.getEncoder().encodeToString((username + uuid).getBytes());
  }
}