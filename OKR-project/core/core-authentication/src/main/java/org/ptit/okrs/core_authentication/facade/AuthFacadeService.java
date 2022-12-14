package org.ptit.okrs.core_authentication.facade;

import org.ptit.okrs.core_authentication.dto.request.*;
import org.ptit.okrs.core_authentication.dto.response.AuthUserForgotPasswordOtpVerifyResponse;
import org.ptit.okrs.core_authentication.dto.response.AuthUserLoginResponse;
import org.ptit.okrs.core_authentication.dto.response.AuthUserRegisterResponse;
import org.ptit.okrs.core_authentication.entity.AuthAccount;

public interface AuthFacadeService {

  /**
   * active account task in auth facade
   * @param request - email and otp user want to active
   * @param authAccount - get isActive and update isActive if the email is not active
   */
  void activeAccount(AuthUserActiveAccountRequest request, AuthAccount authAccount);

  AuthUserLoginResponse login(AuthUserLoginRequest request);

  /**
   * register account user
   * @param request - registered user information
   * @return - recently registered user information
   */
  AuthUserRegisterResponse register(AuthUserRegisterRequest request);

  /**
   * forgot password function
   * @param request - email to send the otp code to the user
   */
  void forgotPassword(AuthUserResetPasswordRequest request);

  /**
   * otp code verification function forgot password
   * @param request - email and otp to be able to verify
   * @return - password new
   */
  AuthUserForgotPasswordOtpVerifyResponse verifyOtpForgotPassword(AuthUserForgotPasswordOtpVerifyRequest request);

  /**
   * password reset function
   * @param request - User information to change password
   */
  void resetPassword(AuthUserForgotPasswordResetRequest request);
}
