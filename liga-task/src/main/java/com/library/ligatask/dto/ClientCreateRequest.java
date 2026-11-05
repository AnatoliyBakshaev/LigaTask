package com.library.ligatask.dto;

import com.library.ligatask.entity.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClientCreateRequest {

    @NotBlank(message = "фио обязательно")
    private String fullName;

    @NotNull(message = "пол обязателен")
    private Gender gender;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}