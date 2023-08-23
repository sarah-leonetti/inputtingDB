package com.iaustin.ggsapi.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateEducationVideoRequest {

    @Schema(example = "Devie 101")
    @NotBlank
    private String name;

    @Schema(example = "1245")
    private Long categoryId;

    @Schema(example = "1235HSJFN@43J")
    @NotBlank
    private String key;

}
