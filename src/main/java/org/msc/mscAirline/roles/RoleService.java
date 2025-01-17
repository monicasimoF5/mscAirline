package org.msc.mscAirline.roles;

import org.springframework.stereotype.Service;

import org.msc.mscAirline.roles.exceptions.RoleNotFoundException;
import java.util.HashSet;
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

    public Set<Role> assignDefaultRole(Long id) throws RoleNotFoundException {
        Role defaultRole = this.getById(1L);//Pdte de revisar

        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        return roles;
    }

}
