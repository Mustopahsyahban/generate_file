package com.library.dao.otherFacilities;


import com.library.entity.OtherFacilitiesEntity;
import com.library.repository.OtherFacilitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherFacilitiesDaoImp implements OtherFacilitiesDao {

    @Autowired
    OtherFacilitiesRepository otherFacilitiesRepository;


    public List<OtherFacilitiesEntity> findAll(){

        List<OtherFacilitiesEntity> list = otherFacilitiesRepository.findAll();

        if (!list.isEmpty()){

            return list;
        }else{

            return null;
        }

    }
}
