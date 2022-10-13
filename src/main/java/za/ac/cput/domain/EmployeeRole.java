/* EmployeeRole.java
   Entity EmployeeRole for Restaurant system
   Author: Marcia Zanele Bika (211054356)
 */
package za.ac.cput.domain;

import java.util.Objects;
public class EmployeeRole{


    private int empId;
    private int roleId;
    private String employee;


    public EmployeeRole(int roleId) {
        this.roleId = roleId;
        this.empId = empId;
        this.empId = this.roleId;
    }

    public EmployeeRole(Builder builder, int roleId) {
        this.roleId = roleId;
    }

    public int getEmpId() {
        return empId;
    }

    public int getRoleId() {
        return roleId;
    }

    public EmployeeRole build() {
        return null;
    }

    public static class EmployeeRoleId{
        private int empId, roleId;

        public EmployeeRoleId(int empId){
            this.empId = empId;
        }
        public int getEmpId(){
            return empId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof EmployeeRoleId)) return false;
            EmployeeRoleId that = (EmployeeRoleId) o;
            return getEmpId() == that.getEmpId() && roleId == that.roleId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(getEmpId(), roleId);
        }
    }

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "empId=" + empId +
                ", roleId=" + roleId +
                '}';
    }
    public static class Builder{
        private int empId, roleId;
        private String employee;

        public Builder employee(String employee){
            this.employee = employee;
            return this;
        }
        public Builder empId(int empId){
            this.empId = empId;
            return this;
        }
        public Builder copy(EmployeeRole employeeRole) {
            this.employee = employeeRole.employee;
            this.empId = employeeRole.empId;
            return this;
        }
        public EmployeeRole build(){
            return new EmployeeRole(this, roleId);
        }

        public EmployeeRole setEmployeeRoleId(String roleId) {
            return null;
        }
    }

}