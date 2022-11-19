package com.hydraulic.applyforme.controller;

import com.hydraulic.applyforme.model.domain.Role;
import com.hydraulic.applyforme.model.dto.role.RoleDto;
import com.hydraulic.applyforme.model.dto.role.DeleteManyRoleDto;
import com.hydraulic.applyforme.service.RoleService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "role",
        produces = { MediaType.APPLICATION_JSON_VALUE }
)
public class RoleController {

    private RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping("/entries")
    public List<Role> findAll(@RequestParam(required = false, defaultValue = "1" , name = "page") Integer pageNumber) {
        return service.findAll(pageNumber);
    }

    @GetMapping("/entries/all")
    public List<Role> findAll() {
        return service.findAll();
    }

    @GetMapping("/detail/{id}")
    public Role findOne(@PathVariable(name ="id") Long id) {
        return service.findOne(id);
    }

    @PostMapping("/save")
    public Role save(@Validated @RequestBody RoleDto body) {
        return service.save(body);
    }

    @PutMapping("/update/{id}")
    public Role update(@Validated @RequestBody RoleDto body, @PathVariable(name ="id") Long id) {
        return service.update(id, body);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/remove/many")
    public boolean deleteMany(@Validated @RequestBody DeleteManyRoleDto body) {
        return service.deleteMany(body);
    }

    @PutMapping("/remove/all")
    public boolean deleteAll() {
        return service.deleteAll();
    }
}