
package com.pdfsample.model.Form4Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Report2 {

    @SerializedName("vehicle_checklist")
    @Expose
    private String vehicleChecklist = "";

    /**
     * @return The vehicleChecklist
     */
    public String getVehicleChecklist() {
        return vehicleChecklist;
    }

    /**
     * @param vehicleChecklist The vehicle_checklist
     */
    public void setVehicleChecklist(String vehicleChecklist) {
        this.vehicleChecklist = vehicleChecklist;
    }

}
