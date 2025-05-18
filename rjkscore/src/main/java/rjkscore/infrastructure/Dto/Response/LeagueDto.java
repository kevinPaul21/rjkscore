package rjkscore.infrastructure.Dto.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LeagueDto {
    private Integer id;
    private String name;
    private Integer importance;
    @JsonProperty("start_league")
    private String startLeague;
    @JsonProperty("end_league")
    private String endLeague;
    @JsonProperty("hash_image")
    private String hashImage;
    @JsonProperty("class_id")
    private Integer classId;
    @JsonProperty("class_name")
    private String className;
    @JsonProperty("class_hash_image")
    private String classHashImage;
}
