package com.yanqi.petmanager.dao;

import com.yanqi.petmanager.pojo.Pet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PetMapper {
    List<Pet> getByPetBreed(@Param("petBreed") int petBreed);
    int save(Pet pet);
}
