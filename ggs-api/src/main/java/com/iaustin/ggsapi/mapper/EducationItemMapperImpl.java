package com.iaustin.ggsapi.mapper;

import com.iaustin.ggsapi.model.EducationItem;
//import com.iaustin.ggsapi.rest.dto.CreateEducationArticleRequest;
import com.iaustin.ggsapi.rest.dto.EducationItemDto;
import org.springframework.stereotype.Service;

@Service
public class EducationItemMapperImpl implements EducationItemMapper {

     
    @Override
    public EducationItemDto toEducationItemDto(EducationItem educationitem) {
        if (educationitem == null) {
            return null;
        }
        return new EducationItemDto(educationitem.getId(), educationitem.getName());
    }
}
