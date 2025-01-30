package org.msc.mscAirline.roles;

import org.springframework.stereotype.Service;

import org.msc.mscAirline.roles.exceptions.RoleNotFoundException;

import java.util.Collections;
import java.util.Set;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role getById(Long id) throws RoleNotFoundException {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found."));
        return role;
    }

    public Set<Role> assignDefaultRole(Long userId) throws RoleNotFoundException {
        Role defaultRole = roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new RoleNotFoundException("Default role (ROLE_USER) not found."));

        return Collections.singleton(defaultRole);
    }

}
