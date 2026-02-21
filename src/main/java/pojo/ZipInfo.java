package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ZipInfo {
    @JsonProperty("post code")
    private String postCode;
    private String country;

    @JsonProperty("country abbreviation")
    private String countryAbbreviation;
    private List<Places> places;

    @Data
    public static class Places{
        @JsonProperty("place name")
        private String placeName;
        private String longitude;
        private String state;

        @JsonProperty("state abbreviation")
        private String stateAbbreviation;
        private String latitude;
    }
}
