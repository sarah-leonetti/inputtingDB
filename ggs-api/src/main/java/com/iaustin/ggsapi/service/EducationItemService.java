package com.iaustin.ggsapi.service;

import com.iaustin.ggsapi.model.EducationItem;

import java.util.List;

public interface EducationItemService {

    List<EducationItem> getEducationItems();

    EducationItem validateAndGetEducationItem(Long id);

    // List<EducationItem> getEducationItems(Long id);

    Boolean isVisible(EducationItem edu);
}
