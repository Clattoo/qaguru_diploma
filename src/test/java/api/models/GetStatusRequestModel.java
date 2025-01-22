package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetStatusRequestModel {
    Boolean success;
    StatusData data;
    List<NotificationsModel> notifications;
    int userV;
    String appVersion;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StatusData {
        String name, id;
        Boolean challenge;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class NotificationsModel {

    }
}
