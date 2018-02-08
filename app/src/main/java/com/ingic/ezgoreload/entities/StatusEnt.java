package com.ingic.ezgoreload.entities;

/**
 * Created on 9/8/2017.
 */

public class StatusEnt {
    private String Active;
    private String Inactive;

    public StatusEnt(String active, String inactive) {
        Active = active;
        Inactive = inactive;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String active) {
        Active = active;
    }

    public String getInactive() {
        return Inactive;
    }

    public void setInactive(String inactive) {
        Inactive = inactive;
    }
}
