package com.iaustin.ggsapi.mapper;

import com.iaustin.ggsapi.model.EducationItem;
import com.iaustin.ggsapi.rest.dto.EducationItemDto;

public interface EducationItemMapper {

    //EducationItem toEducationItem(CreateEducationItemRequest createEducationItemRequest);

    EducationItemDto toEducationItemDto(EducationItem educationitem);
}