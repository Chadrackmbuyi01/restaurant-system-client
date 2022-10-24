package za.ac.cput.gui.driver;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.DriverFactory;

public class DriverHttp {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String driverURL = "http://localhost:8080/restaurant/driver";

    private String username = "manager";
    private String password = "1234";
    private String username2 = "employee";
    private String password2 = "4321";

    public void save(String deliveryId, String orderId, String driverName){
        Driver driver = DriverFactory.createDriver(deliveryId,orderId,driverName);
        String url = driverURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Driver> httpEntity = new HttpEntity<>(driver, httpHeaders);
        ResponseEntity<Driver> responseEntity = restTemplate
                .postForEntity(url, httpEntity, Driver.class);
        driver = responseEntity.getBody();
    }
    public String check(String driverId){
        String url = driverURL + "/read/" +driverId;
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Driver> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Driver> responseCreate = restTemplate
                .exchange(url, HttpMethod.GET, request, Driver.class);
        return responseCreate.getBody().getDriverId() + responseCreate.getBody().getDeliveryId()
                + responseCreate.getBody().getOrderId() + responseCreate.getBody().getDriverName();
    }

    public String getAll(){
        String url = driverURL + "/all";
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth("driver","4321");
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll =
                this.restTemplate
                        .exchange(url, HttpMethod.GET, httpEntity, String.class);
        return responseGetAll.getBody();
    }

    public void delete(String driverId){

        String url = driverURL + "/delete/" + driverId;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username,password);
        HttpEntity<String> request = new HttpEntity<>(null, header);
        this.restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);

    }

}
