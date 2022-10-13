/* RoleFactory.java
   RoleFactory for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */

package za.ac.cput.factory;

import za.ac.cput.domain.Role;


public class RoleFactory {

    public static Role createRole(int roleId, String roleName){
        return new Role.Builder().setRoleId(roleId)
                .setRoleName(roleName)
                .build();

    }
}

