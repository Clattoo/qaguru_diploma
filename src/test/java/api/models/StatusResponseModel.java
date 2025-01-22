package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusResponseModel {
    Boolean success;
    StatusData data;
    String appVersion;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StatusData {
        String status;
    }
}
