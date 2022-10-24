package za.ac.cput.gui.owner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Owner;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.OwnerFactory;
import za.ac.cput.factory.PaymentFactory;

public class OwnerHttp {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String ownerURL = "http://localhost:8080/restaurant/owner";

    private String username = "manager";
    private String password = "1234";
    private String username2 = "employee";
    private String password2 = "4321";

    public void save(int ownerId, String ownerName){
        Owner owner = OwnerFactory.createOwner(ownerId,ownerName);
        String url = ownerURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Owner> httpEntity = new HttpEntity<>(owner, httpHeaders);
        ResponseEntity<Owner> responseEntity = restTemplate
                .postForEntity(url, httpEntity, Owner.class);
        owner = responseEntity.getBody();
    }

    public String check(int ownerId){
        String url = ownerURL + "/read/" +ownerId;
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Owner> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Owner> responseCreate = restTemplate
                .exchange(url, HttpMethod.GET, request, Owner.class);
        return responseCreate.getBody().getOwnerId() +"\t\t"+ responseCreate.getBody().getOwnerName();
    }

    public String getAll(){
        String url = ownerURL + "/All";
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth("employee","4321");
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll =
                this.restTemplate
                        .exchange(url, HttpMethod.GET, httpEntity, String.class);
        return responseGetAll.getBody();
    }
    public void delete(int ownerId){

        String url = ownerURL + "/delete/" + ownerId;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username,password);
        HttpEntity<String> request = new HttpEntity<>(null, header);
        this.restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);

    }


}
