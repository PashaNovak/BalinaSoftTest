package com.novakpavel.balinasofttest.mvp.model.repository.dto;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Authority {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("TTL")
    @Expose
    private Integer tTL;
    @SerializedName("data")
    @Expose
    private String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTTL() {
        return tTL;
    }

    public void setTTL(Integer tTL) {
        this.tTL = tTL;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
