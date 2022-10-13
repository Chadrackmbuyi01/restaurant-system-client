/* EmployeeFactory.java
   Employee Factory for Restaurant management system
   Author: Chadrack Mbuyi Kalala (219013012)
   Date: 05 April 2022
 */
package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.helper.Helper;

public class EmployeeFactory {

    public static Employee build(String empFname, String empLname, String empAddress){

        Helper.checkStringPara("empFname:",empFname);
        Helper.checkStringPara("empLname",empLname);
        Helper.checkStringPara("empAddress",empAddress);
        if (Helper.isEmptyOrNull(empFname) || Helper.isEmptyOrNull(empLname) || Helper.isEmptyOrNull(empAddress) )
            throw new IllegalArgumentException("empFname or/and empLname");
        return new Employee.Builder().setEmpFname(empFname).setEmpLname(empLname).setEmpAddress(empAddress).build();

    }
}
