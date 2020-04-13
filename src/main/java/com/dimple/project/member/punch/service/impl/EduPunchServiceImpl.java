package com.dimple.project.member.punch.service.impl;

import com.dimple.project.member.punch.mapper.EduPunchMapper;
import com.dimple.project.member.punch.entity.EduPunch;
import com.dimple.project.member.punch.service.EduPunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (EduPunch)表服务实现类
 *
 * @author 刘登辉
 * @since 2020-03-30 18:03:34
 */
@Service
public class EduPunchServiceImpl implements EduPunchService {
    @Autowired
    private EduPunchMapper eduPunchMapper;
    
    @Override
    public List<EduPunch> selectEduPunch(EduPunch eduPunch) {
        return eduPunchMapper.selectEduPunch(eduPunch);
    }

    @Override
    public List<String> selectEduPuncHistory(int id) {
        return eduPunchMapper.selectEduPuncHistory(id);
    }

    @Override
    public int insertEduPunch(EduPunch eduPunch) {
        return eduPunchMapper.insertEduPunch(eduPunch);
    }
    
    @Override
    public int updateEduPunch(EduPunch eduPunch) {
        return eduPunchMapper.updateEduPunch(eduPunch);
    }
    
    @Override
    public int deleteEduPunchByIds(Integer[] ids) {
        return eduPunchMapper.deleteEduPunchByIds(ids);
    }
    
     @Override
    public int deleteEduPunchById(Integer id) {
        return eduPunchMapper.deleteEduPunchById(id);
    }

}