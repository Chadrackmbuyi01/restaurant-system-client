package za.ac.cput.gui.role;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.domain.Owner;
import za.ac.cput.domain.Role;
import za.ac.cput.factory.OwnerFactory;
import za.ac.cput.factory.RoleFactory;

public class RoleHttp {

    //RestTemplate and HTTPHeaders
    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders httpHeaders = new HttpHeaders();
    private final String roleURL = "http://localhost:8083/restaurant/role";

    private String username = "manager";
    private String password = "1234";
    private String username2 = "employee";
    private String password2 = "4321";

    public void save(int roleId, String roleName){
        Role role = RoleFactory.createRole(roleId,roleName);
        String url = roleURL + "/save";
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Role> httpEntity = new HttpEntity<>(role, httpHeaders);
        ResponseEntity<Role> responseEntity = restTemplate
                .postForEntity(url, httpEntity, Role.class);
        role = responseEntity.getBody();
    }

    public String check(int roleId){
        String url = roleURL + "/read/" +roleId;
        httpHeaders.setBasicAuth(username, password);
        HttpEntity<Role> request = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<Role> responseCreate = restTemplate
                .exchange(url, HttpMethod.GET, request, Role.class);
        return responseCreate.getBody().getRoleId() +"\t\t"+ responseCreate.getBody().getRoleName();
    }

    public String getAll(){
        String url = roleURL + "/all";
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth("employee","4321");
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll =
                this.restTemplate
                        .exchange(url, HttpMethod.GET, httpEntity, String.class);
        return responseGetAll.getBody();
    }
    public void delete(int roleId){

        String url = roleURL + "/delete/" + roleId;
        System.out.println(url);
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username,password);
        HttpEntity<String> request = new HttpEntity<>(null, header);
        this.restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);

    }
}
