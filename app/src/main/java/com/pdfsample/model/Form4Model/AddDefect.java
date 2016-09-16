package com.pdfsample.model.Form4Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddDefect {

    @SerializedName("defects")
    @Expose
    private String defects = "";
    @SerializedName("preffer_date")
    @Expose
    private String prefferDate = "";
    @SerializedName("repair_deadline")
    @Expose
    private String repairDeadline = "";
    @SerializedName("importance")
    @Expose
    private String importance = "";
    @SerializedName("defect_image")
    @Expose
    private String defectImage = "";

    /**
     * @return The defects
     */
    public String getDefects() {
        return defects;
    }

    /**
     * @param defects The defects
     */
    public void setDefects(String defects) {
        this.defects = defects;
    }

    /**
     * @return The prefferDate
     */
    public String getPrefferDate() {
        return prefferDate;
    }

    /**
     * @param prefferDate The preffer_date
     */
    public void setPrefferDate(String prefferDate) {
        this.prefferDate = prefferDate;
    }

    /**
     * @return The repairDeadline
     */
    public String getRepairDeadline() {
        return repairDeadline;
    }

    /**
     * @param repairDeadline The repair_deadline
     */
    public void setRepairDeadline(String repairDeadline) {
        this.repairDeadline = repairDeadline;
    }

    /**
     * @return The importance
     */
    public String getImportance() {
        return importance;
    }

    /**
     * @param importance The importance
     */
    public void setImportance(String importance) {
        this.importance = importance;
    }

    /**
     * @return The defectImage
     */
    public String getDefectImage() {
        return defectImage;
    }

    /**
     * @param defectImage The defect_image
     */
    public void setDefectImage(String defectImage) {
        this.defectImage = defectImage;
    }

}