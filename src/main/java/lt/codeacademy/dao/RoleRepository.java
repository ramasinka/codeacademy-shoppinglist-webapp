package lt.codeacademy.dao;


import lt.codeacademy.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query("SELECT r FROM Role r WHERE r.name = :roleName")
    Role findRoleByName(@Param("roleName") String roleName);
}
