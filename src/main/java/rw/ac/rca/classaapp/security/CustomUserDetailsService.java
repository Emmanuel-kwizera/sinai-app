package rw.ac.rca.classaapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rw.ac.rca.classaapp.model.User;
import rw.ac.rca.classaapp.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrMobileOrEmail) throws UsernameNotFoundException {
		User user = userRepository
				.findByEmail(usernameOrMobileOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException(
						"User not found with mobile or email : " + usernameOrMobileOrEmail));

		return UserPrincipal.create(user);
	}

	@Transactional
	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with id : " + id));

		return UserPrincipal.create(user);
	}
}
