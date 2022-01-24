package com.exam.pariksha.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;
    private String  roleName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "role")
    private Set<UserRole> userroles=new HashSet<>();



    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }


    public Set<UserRole> getUserroles() {
        return userroles;
    }

    public void setUserroles(Set<UserRole> userroles) {
        this.userroles = userroles;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role() {

    }

}
