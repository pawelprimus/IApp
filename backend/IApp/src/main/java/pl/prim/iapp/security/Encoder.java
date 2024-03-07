package pl.prim.iapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Encoder {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String encode(String password) {
        return passwordEncoder.encode(password);
    }
}