package rjkscore.infrastructure.Dto.Response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteResponseDto {
    private Integer favoriteId;
    private String itemType;
    private Integer itemId;
    private LocalDateTime createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL) 
    private Object itemData;
}
