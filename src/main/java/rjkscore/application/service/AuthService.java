package rjkscore.application.service;

import rjkscore.infrastructure.Dto.Request.LoginRequestDto;
import rjkscore.infrastructure.Dto.Request.RegisterRequestDto;
import rjkscore.infrastructure.Dto.Response.AuthResponseDto;

public interface AuthService {
    AuthResponseDto register(RegisterRequestDto dto);
    AuthResponseDto login(LoginRequestDto dto);
}
