package com.example.phuong.vno.dao;

import com.example.phuong.vno.model.entity.VnoEntity;
import java.util.List;

// Communicate with Database
public interface VnoDAO {

    List<VnoEntity> getVnos();

    VnoEntity getVno(Integer id);

    void addVno(VnoEntity vnoEntity);

    void deleteVno(Integer id);

    void updateVno(VnoEntity vnoEntity);
}
