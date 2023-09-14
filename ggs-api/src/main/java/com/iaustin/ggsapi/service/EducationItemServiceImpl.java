package com.iaustin.ggsapi.service;

import com.iaustin.ggsapi.exception.EducationItemNotFoundException;
import com.iaustin.ggsapi.model.EducationItem;
import com.iaustin.ggsapi.repository.EducationItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EducationItemServiceImpl implements EducationItemService {

    private final EducationItemRepository educationitemRepository;

    @Override
    public List<EducationItem> getEducationItems() {
        return educationitemRepository.findAll();
    }

    @Override
    public EducationItem validateAndGetEducationItem(Long id) {
        return educationitemRepository.findById(id)
                .orElseThrow(() -> new EducationItemNotFoundException(String.format("Education item with id %s not found", id)));
    }

    // @Override
    // public List<EducationItem> getEducationItems(Long id) {
    //     return educationitemRepository.findByCategoryId(id);
    // }

    @Override
    public Boolean isVisible(EducationItem edu) {
        return edu.getIsActive();
    }

  

}
    
    


    
