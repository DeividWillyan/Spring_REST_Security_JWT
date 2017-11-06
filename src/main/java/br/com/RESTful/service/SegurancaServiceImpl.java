package br.com.RESTful.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.RESTful.domain.Authority;
import br.com.RESTful.domain.User;

@Service("segurancaService")
public class SegurancaServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null) {
			throw new UsernameNotFoundException(username);
		}
		Authority authority = new Authority();
		if (username.equals("admin")) {
			authority.setAuthority("ROLE_ADMIN");
		} else {
			authority.setAuthority("ROLE_USER");
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(username);
		user.setAuthorities(new ArrayList<Authority>());
		user.getAuthorities().add(authority);
		return user;
	}

}