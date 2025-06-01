package rjkscore.infrastructure.Dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDto {

    private String token;
    private AppUserResponseDto user;
    private String message;

}
