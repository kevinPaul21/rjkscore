package rjkscore.infrastructure.Dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteRequestDto {
    private String itemType;
    private Integer itemId;
}
