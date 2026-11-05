package com.library.ligatask.dto;

import com.library.ligatask.entity.ClientStatus;
import com.library.ligatask.entity.Gender;

import java.time.OffsetDateTime;

public class ClientResponse {

    private Long id;
    private String fullName;
    private Gender gender;
    private ClientStatus status;
    private OffsetDateTime createDttm;
    private OffsetDateTime modifyDttm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public OffsetDateTime getCreateDttm() {
        return createDttm;
    }

    public void setCreateDttm(OffsetDateTime createDttm) {
        this.createDttm = createDttm;
    }

    public OffsetDateTime getModifyDttm() {
        return modifyDttm;
    }

    public void setModifyDttm(OffsetDateTime modifyDttm) {
        this.modifyDttm = modifyDttm;
    }
}