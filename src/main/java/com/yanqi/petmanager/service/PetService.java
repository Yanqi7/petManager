package com.yanqi.petmanager.service;

import com.yanqi.petmanager.pojo.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetService {
    List<Pet> findByPetBreed(int petBreed);
}
