package com.staffsterr2000.integrationapi.model.enumeration;

public enum EmployedStatus {
    EMPLOYED(true),
    UNEMPLOYED(false);

    private Boolean isEmployed;

    EmployedStatus(Boolean isEmployed) {
        this.isEmployed = isEmployed;
    }

    public Boolean getIsEmployed() {
        return isEmployed;
    }

}
