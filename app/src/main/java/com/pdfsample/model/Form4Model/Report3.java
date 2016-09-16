
package com.pdfsample.model.Form4Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Report3 {

    @SerializedName("vehicle_checklist2")
    @Expose
    private String vehicle_checklist2="";

    /**
     * @return The vehicleChecklist
     */
    public String getVehicleChecklist() {
        return vehicle_checklist2;
    }

    /**
     * @param vehicleChecklist The vehicle_checklist
     */
    public void setVehicleChecklist(String vehicleChecklist) {
        this.vehicle_checklist2 = vehicleChecklist;
    }

}
