package za.ac.cput.gui.employee;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

public class EmployeeHttp {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String employeeURL = "http://localhost:8083/restaurant/employee";

    private String username = "manager";
    private String password = "1234";
    private String username2 = "employee";
    private String password2 = "4321";


    public void save(String empFname, String empLname, String empAddress){
        Employee employee = EmployeeFactory.build(empFname,empLname,empAddress);
        String url = employeeURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Employee> httpEntity = new HttpEntity<>(employee, httpHeaders);
        ResponseEntity<Employee> responseEntity = restTemplate
                .postForEntity(url, httpEntity, Employee.class);
        employee = responseEntity.getBody();
    }

    public String check(String empId){
        String url = employeeURL + "/read/" +empId;
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Employee> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Employee> responseCreate = restTemplate
                .exchange(url, HttpMethod.GET, request, Employee.class);
        return responseCreate.getBody().getEmpId() +"\t\t\t"+ responseCreate.getBody().getEmpFname()
                +"\t"+ responseCreate.getBody().getEmpLname() +"\t\t"+ responseCreate.getBody().getEmpAddress();
    }

    public String getAll(){
        String url = employeeURL + "/all";
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username2, password2);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = this.restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        return responseGetAll.getBody();
    }

    public void delete(String empId){

        String url = employeeURL + "/delete/" + empId;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username,password);
        HttpEntity<String> request = new HttpEntity<>(null, header);
        this.restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);

    }
    
    
}
