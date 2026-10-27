package com.easygest.customerservice.users.application.service;

import com.easygest.customerservice.memberrole.application.port.out.MemberRoleRepositoryPort;
import com.easygest.customerservice.roles.application.port.out.RolesRepositoryPort;
import com.easygest.customerservice.societymember.application.port.out.SocietyMemberRepositoryPort;
import com.easygest.customerservice.users.application.port.out.UsersRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailService implements ReactiveUserDetailsService {

    private final UsersRepositoryPort usersRepositoryPort;
    private final SocietyMemberRepositoryPort societyMemberRepositoryPort;
    private final MemberRoleRepositoryPort memberRoleRepositoryPort;
    private final RolesRepositoryPort rolesRepositoryPort;


    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return usersRepositoryPort.findByEmail(username)
                 .flatMap(user -> societyMemberRepositoryPort.getSocietyMemberById(user.id())
                         .switchIfEmpty(Mono.error(new UsernameNotFoundException("Usuario no encontrado")))
                 .flatMap(societyMember -> memberRoleRepositoryPort.getMemberRoleById(societyMember.id())
                         .switchIfEmpty(Mono.error(new UsernameNotFoundException("El usuario no forma parte de ninguna empresa")))
                 .flatMap(memberRole -> rolesRepositoryPort.getRolesById(memberRole.id())
                         .switchIfEmpty(Mono.error( new UsernameNotFoundException("El usuario no tiene ningun rol asociado")))
                 .map( role-> new User(user.name(),"", List.of(new SimpleGrantedAuthority("ROLE_"+role.code())))))));
    }
}
