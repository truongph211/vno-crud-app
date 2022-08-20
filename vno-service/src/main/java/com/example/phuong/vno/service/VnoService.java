package com.example.phuong.vno.service;

import com.example.phuong.vno.vo.VnoVO;

import java.util.List;

// Business logic ,call DAO
public interface VnoService {

    List<VnoVO> getVnos();

    VnoVO getVno(Integer id);

    void addVno(VnoVO vnoEntity) throws Exception;

    void deleteVno(Integer id) throws Exception;

    void updateVno(VnoVO vnoEntity) throws Exception;
}
