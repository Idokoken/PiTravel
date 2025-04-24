package ndgroups.PiTravel.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class JwtResponse {
    private Integer id;
    private String token;

    public JwtResponse(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public JwtResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

