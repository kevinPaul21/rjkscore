package rjkscore.infrastructure.Dto.Response;

import lombok.Data;
import java.util.List;

@Data
public class ApiResponse<T> {
    private List<T> data;
    private Object pagination; // Puedes mapearlo con una clase específica si lo necesitas
    private Boolean success;
}