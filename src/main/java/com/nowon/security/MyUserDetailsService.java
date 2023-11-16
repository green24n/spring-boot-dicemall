package com.nowon.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nowon.domain.entity.MemberEntity;
import com.nowon.domain.entity.MemberEntityRepository;


public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	MemberEntityRepository memRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//DB접속해서 회원이 존재하는지
		MemberEntity member = memRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 유저"));
//		memRepo.aaa(email);
		Set<SimpleGrantedAuthority> grantedAuthority
			=member.getRoles().stream()
				.map(myRole -> new SimpleGrantedAuthority("ROLE_"+myRole.name()))
				.collect(Collectors.toSet());
//		USER -> "ROLE_USER"
//		Collection<? extends GrantedAuthority>
		return new User(username, member.getPass(), grantedAuthority);
	}

}
