package com.wayfarer.member.oauth.service;


import com.wayfarer.member.entity.Member;
import com.wayfarer.member.oauth.entity.PrincipalDetails;
import com.wayfarer.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    private MemberRepository memberRepository;

    public PrincipalDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member memberEntity = memberRepository.findBySocialId(username).orElse(null);
        System.out.println("username: " + username);
        if (memberEntity == null) {
            throw new UsernameNotFoundException("Can not find username");
        }

        return PrincipalDetails.create(memberEntity);
    }
}

