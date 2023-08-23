package com.iaustin.ggsapi.rest;

import com.iaustin.ggsapi.mapper.EducationItemMapper;
import com.iaustin.ggsapi.model.EducationItem;
//import com.iaustin.ggsapi.rest.dto.CreateEducationItemRequest;
import com.iaustin.ggsapi.rest.dto.EducationItemDto;
import com.iaustin.ggsapi.service.EducationItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.iaustin.ggsapi.config.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;

@RequiredArgsConstructor
@RestController
//curl get localhost:8080/api/education_item
@RequestMapping("/api/education_item")
public class EducationItemController {

    private final EducationItemService educationitemService;
    private final EducationItemMapper educationitemMapper;

    // @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    // @GetMapping
    // public List<EducationItemDto> getCategories(@RequestParam(value = "id", required = false) Long id) {
    //     List<EducationItem> educationitems = (id == null) ? educationitemService.getCategories() : educationitemService.getCategories();
    //     return educationitems.stream()
    //             .map(educationitemMapper::toEducationItemDto)
    //             .collect(Collectors.toList());
    // }

    // @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    // @DeleteMapping("/{id}")
    // public EducationItemDto deleteEducationItem(@PathVariable Long id) {
    //     EducationItem educationitem = educationitemService.validateAndGetEducationItem(id);
    //     educationitemService.deleteEducationItem(educationitem);
    //     return educationitemMapper.toEducationItemDto(educationitem);
    // }
}
