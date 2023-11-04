package com.prodemy.kelompok3.springminiproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prodemy.kelompok3.springminiproject.config.UserInfoConfig;
import com.prodemy.kelompok3.springminiproject.entity.User;
import com.prodemy.kelompok3.springminiproject.exceptions.ResourceNotFoundException;
import com.prodemy.kelompok3.springminiproject.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(username);

		return user.map(UserInfoConfig::new).orElseThrow(() -> new ResourceNotFoundException("User", "email", username));
	}

}
