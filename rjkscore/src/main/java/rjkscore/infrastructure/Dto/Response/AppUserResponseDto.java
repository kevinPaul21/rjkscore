package rjkscore.infrastructure.Dto.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppUserResponseDto {
    private Long userId;
    private String username;
    private String email;
    private Integer coins;

}
