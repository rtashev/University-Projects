package com.project.library.services.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.library.dao.UserDao;

@Service("customUserDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.project.library.entities.User myCustomUser = userDao.getUserByName(username);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(myCustomUser.getRole()));
		
		return buildUserForAuthentication(myCustomUser, authorities);
	}
	
	
	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.project.library.entities.User user, List<GrantedAuthority> authorities) {
	
		return new User(user.getName(), user.getPassword(), user.isEnabled(), true, true, true, authorities /*see if it should be replaced by getRole();*/);
	}
	
}
