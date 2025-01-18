package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LoginResponseModel {
    Boolean success;
    UserData data;
    String appVersion;

    @Data
    public static class UserData {
        String id, apiToken;
        Boolean newUser;
        String username;
    }
}