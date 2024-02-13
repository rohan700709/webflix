package com.stackroute.UserAuthService.security;


import com.stackroute.UserAuthService.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String, String> generateToken(User user);
}
