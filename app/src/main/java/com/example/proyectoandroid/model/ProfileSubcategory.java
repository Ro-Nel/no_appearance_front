package com.example.proyectoandroid.model;

public class ProfileSubcategory {

    private Integer profileSubId;
    private Integer profileId;
    private Integer subcategoryId;
    private Integer status;

    public ProfileSubcategory(Integer profileSubId, Integer profileId, Integer subcategoryId, Integer status) {
        this.profileSubId = profileSubId;
        this.profileId = profileId;
        this.subcategoryId = subcategoryId;
        this.status = status;
    }
    public ProfileSubcategory(Integer profileId, Integer subcategoryId ) {
        this.profileId = profileId;
        this.subcategoryId = subcategoryId;
    }

    public Integer getProfileSubId() {
        return profileSubId;
    }

    public void setProfileSubId(Integer profileSubId) {
        this.profileSubId = profileSubId;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

