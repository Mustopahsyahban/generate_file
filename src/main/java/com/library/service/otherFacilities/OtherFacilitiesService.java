package com.library.service.otherFacilities;

import com.library.entity.IndividualDebitorEnity;
import com.library.entity.OtherFacilitiesEntity;

import java.util.List;


public interface OtherFacilitiesService {

    List<OtherFacilitiesEntity> findAll();

    public String  exportFile(String format);
}
