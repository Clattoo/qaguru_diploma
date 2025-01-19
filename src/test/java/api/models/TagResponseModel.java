package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagResponseModel {
    Boolean success;
    TagData data;
    List<UserNotifications> notifications;
    int userV;
    String appVersion;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TagData {
        String name, id;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserNotifications {

    }
}
