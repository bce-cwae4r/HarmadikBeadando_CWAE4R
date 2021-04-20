package hu.haltech.harmadikBeadando.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class HarmadikBeadandóRequestDto {
    private String content;
}
