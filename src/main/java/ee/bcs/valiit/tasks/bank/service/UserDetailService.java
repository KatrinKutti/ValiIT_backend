package ee.bcs.valiit.tasks.bank.service;

import ee.bcs.valiit.tasks.bank.BankingRepository;
import ee.bcs.valiit.tasks.bank.BankingService;
import ee.bcs.valiit.tasks.bank.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private BankingService bankingRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        String password = bankingRepository.findPasswordByUserName(userName);
        return User.withUsername(userName)
                .password(password)
                .roles("USER").build();
    }
}