package lt.codeacademy.service;

import lt.codeacademy.dao.RoleRepository;
import lt.codeacademy.model.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;

    public Role getRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }
}
