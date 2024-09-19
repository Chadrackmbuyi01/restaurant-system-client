package za.ac.cput.gui.payment;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.factory.PaymentFactory;

public class PaymentHttp {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String paymentURL = "http://localhost:8083/restaurant/payment";

    private String username = "manager";
    private String password = "1234";
    private String username2 = "employee";
    private String password2 = "4321";

    public void save(String paymentId, String payCash, String payCard, String payEft){
        Payment payment = PaymentFactory.createPayment(paymentId,payCash,payCard,payEft);
        String url = paymentURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, httpHeaders);
        ResponseEntity<Payment> responseEntity = restTemplate
                .postForEntity(url, httpEntity, Payment.class);
        payment = responseEntity.getBody();
    }

    public String check(String paymentId){
        String url = paymentURL + "/read/" +paymentId;
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Payment> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Payment> responseCreate = restTemplate
                .exchange(url, HttpMethod.GET, request, Payment.class);
        return responseCreate.getBody().getPaymentId() +"\t\t"+ responseCreate.getBody().getPayCash()
                +"\t\t\t"+ responseCreate.getBody().getPayCard() +"\t\t\t"+ responseCreate.getBody().getPayEft();
    }

    public String getAll(){
        String url = paymentURL + "/all";
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth("employee","4321");
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll =
                this.restTemplate
                        .exchange(url, HttpMethod.GET, httpEntity, String.class);
        return responseGetAll.getBody();
    }

    public void delete(String paymentId){

        String url = paymentURL + "/delete/" + paymentId;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username,password);
        HttpEntity<String> request = new HttpEntity<>(null, header);
        this.restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);

    }

}
