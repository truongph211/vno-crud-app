package com.example.phuong.vno.service.impl;

import com.example.phuong.vno.dao.VnoDAO;
import com.example.phuong.vno.model.entity.VnoEntity;
import com.example.phuong.vno.service.VnoService;
import com.example.phuong.vno.util.VnoUtil;
import com.example.phuong.vno.vo.VnoVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VnoServiceImpl implements VnoService {

    private final VnoDAO m_vnoDAO;

    public VnoServiceImpl(VnoDAO vnoDAO) {
        this.m_vnoDAO = vnoDAO;
    }

    // cho nay minh ko tra ra truc tiep VnoEntity, ma minh se convert sang VO

    @Override
    public List<VnoVO> getVnos() {
        List<VnoEntity> entities = m_vnoDAO.getVnos();
//        return CollectionUtils.isEmpty(entities)
//                ? new ArrayList<>()
//                : entities.stream().map(VnoVO::new).collect(Collectors.toList());

        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }
        List<VnoVO> modelVOs = new ArrayList<>();
        for (VnoEntity model : entities) {
            modelVOs.add(new VnoVO(model));
        }
        return modelVOs;
    }


    @Override
    public VnoVO getVno(Integer id) {
        VnoEntity entity = m_vnoDAO.getVno(id);
        return entity != null ? new VnoVO(entity) : null;
    }

    @Override
    public void addVno(VnoVO vnoVO) throws Exception {

        // cho phep user set data cho tat ca cac fields trong entity luon
        // vd: co field password, vay user co quyen edit truc tiep luon
        // tuong tu voi updateVno
        // id la ma~ tu tang, cho nen de no tu tang, minh ko co set vao

// StringUtils.isEmpty() hàm này có tác dung check duoc null or empty.
//        if (vnoVO == null || StringUtils.isEmpty(vnoVO.getName()) || StringUtils.isEmpty(vnoVO.getType())) {
//            assert vnoVO != null;
//            throw new Exception("Invalid Vno " + vnoVO.toString());
//        }

        VnoEntity entity = new VnoEntity(vnoVO.getName(), vnoVO.getType(),
                Double.parseDouble(vnoVO.getVersion()), VnoUtil.convertToTimestamp(vnoVO.getStartTime()), VnoUtil.convertToTimestamp(vnoVO.getEndTime()));
        m_vnoDAO.addVno(entity);
    }

    @Override
    public void deleteVno(Integer id) throws Exception {
        VnoEntity vnoEntityFromDB = m_vnoDAO.getVno(id);
        if (vnoEntityFromDB == null) {
            System.out.println("Vno with id=" + id + " does not exists");
            throw new Exception("Vno with id=" + id + " does not exists");
        } else {
            m_vnoDAO.deleteVno(id);
        }
    }

    @Override
    public void updateVno(VnoVO vnoVO) throws Exception {
        VnoEntity vnoEntityFromDB = m_vnoDAO.getVno(vnoVO.getId());
        if (vnoEntityFromDB == null) {
            // khi update vno, ma vno ko co minh cho log lai thoi
            // return ra cai error message, de ben cho restful bat lai
            System.out.println("Vno with id = " + vnoVO.getId() + " does not exists");
            // khi ko tim thay vno thi no se quang ra exception
            throw new Exception("Vno with id = " + vnoVO.getId() + " does not exists");
        } else {
            // get data trong VO roi apply vao entity
//            if (!StringUtils.isEmpty(vnoVO.getName())) {
//                vnoEntityFromDB.setName(vnoVO.getName());
//            }
//            if (!StringUtils.isEmpty(vnoVO.getName())) {
//                vnoEntityFromDB.setType(vnoVO.getType());
//            }
            vnoEntityFromDB.setName(vnoVO.getName());
            vnoEntityFromDB.setType(vnoVO.getType());
            vnoEntityFromDB.setVersion(Double.parseDouble(vnoVO.getVersion()));

//            vnoEntityFromDB.setStartTime(vnoVO.getStartTime());
            // vd startime minh se lay current_time, nen ko cho nguoi dung update
            // ko cho user update nhung fields ma minh ko cho phep
            vnoEntityFromDB.setEndTime(VnoUtil.convertToTimestamp(vnoVO.getEndTime()));

            // save lai entity
            m_vnoDAO.updateVno(vnoEntityFromDB);
        }
    }
}

