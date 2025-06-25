package com.fancyshop.ecommerce.controller;
import com.fancyshop.ecommerce.model.Role;
import com.fancyshop.ecommerce.model.User;
import com.fancyshop.ecommerce.repository.RoleRepository;
import com.fancyshop.ecommerce.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin as needed
public class RoleController {
    
    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @GetMapping
    public List<Role> getAllRoles() {
        return roleRepository.findAll(); 
       }
    
    //get role by id
    @GetMapping("/{id}")
    public Optional<Role> getRoleById(@PathVariable Long id) {
        return roleRepository.findById(id);
    }

    // create a new role
     @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    //  Delete a role
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }

}
