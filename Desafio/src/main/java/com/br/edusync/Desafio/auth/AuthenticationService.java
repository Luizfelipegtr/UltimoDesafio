package com.br.edusync.Desafio.auth;

import com.br.edusync.Desafio.Models.UserModel;
import com.br.edusync.Desafio.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder Encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean userExists(String username) {
        UserModel user = userRepository.findByUsername(username);
        return (user != null);
    }
    //Não consegui o erro de "package-private"
    public void createAdminUser() {
        UserModel adminUser = new UserModel();
        adminUser.setUsername("admin");
        adminUser.setPassword(Encoder.encode("1234"));
        adminUser.setEmail("Administrador");

        userRepository.save(adminUser);
    }
}