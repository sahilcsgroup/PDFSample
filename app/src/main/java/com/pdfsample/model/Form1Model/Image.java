
package com.pdfsample.model.Form1Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Image implements Serializable {

    @SerializedName("parts_image1")
    @Expose
    private String partsImage1="";
    @SerializedName("parts_image2")
    @Expose
    private String partsImage2="";
    @SerializedName("parts_image3")
    @Expose
    private String partsImage3="";

    /**
     * @return The partsImage1
     */
    public String getPartsImage1() {
        return partsImage1;
    }

    /**
     * @param partsImage1 The parts_image1
     */
    public void setPartsImage1(String partsImage1) {
        this.partsImage1 = partsImage1;
    }

    /**
     * @return The partsImage2
     */
    public String getPartsImage2() {
        return partsImage2;
    }

    /**
     * @param partsImage2 The parts_image2
     */
    public void setPartsImage2(String partsImage2) {
        this.partsImage2 = partsImage2;
    }

    /**
     * @return The partsImage3
     */
    public String getPartsImage3() {
        return partsImage3;
    }

    /**
     * @param partsImage3 The parts_image3
     */
    public void setPartsImage3(String partsImage3) {
        this.partsImage3 = partsImage3;
    }

}
