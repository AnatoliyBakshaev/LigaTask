package com.library.ligatask.dto;
import com.library.ligatask.entity.ClientStatus;
import jakarta.validation.constraints.NotBlank;

public class ClientUpdateRequest {

    @NotBlank(message = "фио обязательно")
    private String fullName;

    private ClientStatus status;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }
}