package com.yanqi.petmanager.service.impl;

import com.yanqi.petmanager.dao.PetMapper;
import com.yanqi.petmanager.pojo.Pet;
import com.yanqi.petmanager.service.PetService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Resource
    private PetMapper petMapper;

    @Override
    public List<Pet> findByPetBreed(int petBreed){
        List<Pet> pet = petMapper.getByPetBreed(petBreed);
        return pet;
    }
}
