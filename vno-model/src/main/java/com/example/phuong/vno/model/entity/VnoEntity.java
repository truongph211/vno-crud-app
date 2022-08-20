package com.example.phuong.vno.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "vno")
public class VnoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private Double version;
    private Timestamp startTime; // Timestamp
    private Timestamp endTime;

    public VnoEntity() {
    }

    public VnoEntity(String name, String type, Double version, Timestamp startTime, Timestamp endTime) {
        this.name = name;
        this.type = type;
        this.version = version;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "id")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "version")
    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VnoEntity vnoEntity = (VnoEntity) o;
        return Objects.equals(id, vnoEntity.id) && Objects.equals(name, vnoEntity.name) && Objects.equals(type, vnoEntity.type) && Objects.equals(version, vnoEntity.version) && Objects.equals(startTime, vnoEntity.startTime) && Objects.equals(endTime, vnoEntity.endTime);
    }

}
