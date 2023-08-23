package com.iaustin.ggsapi.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateEducationArticleRequest {

    @Schema(example = "The article title")
    @NotBlank
    private String name;

    @Schema(example = "1245")
    private Long categoryId;

    @Schema(example = "Author name")
    @NotBlank
    private String author;

    @Schema(example = "this is the info of the article")
    @NotBlank
    private String details;

}
