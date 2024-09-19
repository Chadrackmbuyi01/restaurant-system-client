package za.ac.cput.gui.customer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.EmployeeFactory;

public class CustomerHttp {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String customerURL = "http://localhost:8083/restaurant/customer";

    private String username = "manager";
    private String password = "1234";
    private String username2 = "employee";
    private String password2 = "4321";

    public void save(String custId, int custCellNum,String custEmail,String custFirstName, String custLastName){
        Customer customer = CustomerFactory.createcustomer(custId,custFirstName,custLastName,custCellNum,custEmail);
        String url = customerURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Customer> httpEntity = new HttpEntity<>(customer, httpHeaders);
        ResponseEntity<Customer> responseEntity = restTemplate
                .postForEntity(url, httpEntity, Customer.class);
        customer = responseEntity.getBody();
    }

    public String check(String custId){
        String url = customerURL + "/read/" +custId;
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Customer> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Customer> responseCreate = restTemplate
                .exchange(url, HttpMethod.GET, request, Customer.class);
        return responseCreate.getBody().getCustId() +"\t\t\t\t"+ responseCreate.getBody().getCustFirstName()
                +"\t"+ responseCreate.getBody().getCustLastName() +"\t\t\t"+ responseCreate.getBody().getCustCellNum()
                +"\t"+ responseCreate.getBody().getCustEmail();
    }

    public String getAll(){
        String url = customerURL + "/all";
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth("employee","4321");
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll =
                this.restTemplate
                        .exchange(url, HttpMethod.GET, httpEntity, String.class);
        return responseGetAll.getBody();
    }

    public void delete(String custId){

        String url = customerURL + "/delete/" + custId;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username,password);
        HttpEntity<String> request = new HttpEntity<>(null, header);
        this.restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);

    }
}
