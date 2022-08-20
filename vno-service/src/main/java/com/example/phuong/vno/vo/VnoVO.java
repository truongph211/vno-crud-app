package com.example.phuong.vno.vo;

import com.example.phuong.vno.model.entity.VnoEntity;
import com.example.phuong.vno.util.VnoUtil;

public class VnoVO {

    private Integer id;
    private String name;
    private String type;
    private String version;
    private String startTime; // tu Client gui qua la String, nen no ko tu cast qua dang Time dc
    private String endTime;

    public VnoVO() {
    }

    public VnoVO(VnoEntity entity) {
        // Cho nay  chi show nhung entity cho phep thoi
        // va hide di "startTime"
        this.id = entity.getId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.version = entity.getVersion().toString();
        this.endTime = VnoUtil.timeStampToString(entity.getEndTime());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "VnoVO{" +
                " name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", version=" + version +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
