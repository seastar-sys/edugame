package com.dimple.project.member.speed.service.impl;

import com.dimple.project.member.speed.mapper.EduSpeedMapper;
import com.dimple.project.member.speed.entity.EduSpeed;
import com.dimple.project.member.speed.service.EduSpeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (EduSpeed)表服务实现类
 *
 * @author 刘登辉
 * @since 2020-03-04 18:48:27
 */
@Service
public class EduSpeedServiceImpl implements EduSpeedService {
    @Autowired
    private EduSpeedMapper eduSpeedMapper;
    
    @Override
    public List<EduSpeed> selectEduSpeed(EduSpeed eduSpeed) {
        return eduSpeedMapper.selectEduSpeed(eduSpeed);
    }
    
    @Override
    public int insertEduSpeed(EduSpeed eduSpeed) {
        return eduSpeedMapper.insertEduSpeed(eduSpeed);
    }
    
    @Override
    public int updateEduSpeed(EduSpeed eduSpeed) {
        return eduSpeedMapper.updateEduSpeed(eduSpeed);
    }
    
    @Override
    public int deleteEduSpeedByIds(Integer[] ids) {
        return eduSpeedMapper.deleteEduSpeedByIds(ids);
    }
    
     @Override
    public int deleteEduSpeedById(Integer id) {
        return eduSpeedMapper.deleteEduSpeedById(id);
    }

}