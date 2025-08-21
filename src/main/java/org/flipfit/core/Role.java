package org.flipfit.core;

import jakarta.persistence.*;


public class Role {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int RoleId;

    @Column(name = "RoleName", nullable = false)
    public String RoleName;

    public int getRoleId() {
        return RoleId;
    }
    public void setRoleId(int roleId) {
        RoleId = roleId;
    }
    public String getRoleName() {
        return RoleName;
    }
    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

}
