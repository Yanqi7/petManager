package com.yanqi.petmanager.pojo;


import java.util.Date;

public class Pet {

  private int petId;
  private String petName;
  private int petBreed;
  private int petSex;
  private Date birthday;
  private String description;


  public int getPetId() {
    return petId;
  }

  public void setPetId(int petId) {
    this.petId = petId;
  }


  public String getPetName() {
    return petName;
  }

  public void setPetName(String petName) {
    this.petName = petName;
  }


  public int getPetBreed() {
    return petBreed;
  }

  public void setPetBreed(int petBreed) {
    this.petBreed = petBreed;
  }


  public int getPetSex() {
    return petSex;
  }

  public void setPetSex(int petSex) {
    this.petSex = petSex;
  }


  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
