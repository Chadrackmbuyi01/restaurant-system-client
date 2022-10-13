/* Employee.java
   Entity for the Employee
   Author: Chadrack Mbuyi Kalala (219013012)
   Date: 29 March 2022
 */
package za.ac.cput.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull private int empId;
    @NotNull private String empFname, empLname, empAddress;

     public Employee (Builder builder){
         this.empFname=builder.empFname;
         this.empLname=builder.empLname;
         this.empAddress=builder.empAddress;

     }

    public Employee() {

    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpFname() {
        return empFname;
    }

    public String getEmpLname() {
        return empLname;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empFname='" + empFname + '\'' +
                ", empLname='" + empLname + '\'' +
                ", empAddress='" + empAddress + '\'' +
                '}';
    }


    public static class Builder{

        @NotNull private int empId;
        @NotNull private String empFname;
        @NotNull private String empLname;
        @NotNull private String empAddress;
        public Builder setEmpId(int empId) {
            this.empId = empId;
            return this;
        }

        public Builder setEmpFname(String empFname) {
            this.empFname = empFname;
            return this;
        }

        public Builder setEmpLname(String empLname) {
            this.empLname = empLname;
            return this;
        }

        public Builder setEmpAddress(String empAddress) {
            this.empAddress = empAddress;
            return this;
        }

       public Builder copy(Employee employee){
            this.empFname=employee.empFname;
            this.empLname=employee.empLname;
            this.empAddress=employee.empAddress;

            return this;
        }
        public Employee build(){
            return new Employee (this);
        }
    }




}
