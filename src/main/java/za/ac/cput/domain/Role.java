/* Role.java
   Entity Role for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */
package za.ac.cput.domain;

import java.io.Serializable;


public class Role implements Serializable {

     private int roleId;
     private String roleName;

    public Role(Builder builder){
        this.roleId = builder.roleId;
        this.roleName = builder.roleName;
    }
    public Role(){

    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }


    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
    public static class Builder{
         private int roleId;
         private String roleName;

        public Builder setRoleId(int roleId) {
            this.roleId = roleId;
            return this;
        }

        public Builder setRoleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public Builder copy(Role role){
            this.roleId = role.roleId;
            this.roleName = role.roleName;
            return this;
        }

        public Role build(){
            return new Role(this);
        }
    }
}
