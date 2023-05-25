package ru.itis.semesterwork.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.semesterwork.repositories.UserRepository;


@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "user with email %s not found";
    private final UserRepository userRepository;
    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new CustomUserDetails(userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND,email))));
    }
}
