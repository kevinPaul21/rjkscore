package rjkscore.application.service;

import rjkscore.infrastructure.Dto.Request.RegisterRequestDto;
import rjkscore.infrastructure.Dto.Response.AppUserResponseDto;

public interface AuthService {
    AppUserResponseDto register(RegisterRequestDto dto);
}
