package com.dimple.project.member.user.service.impl;

import com.dimple.project.member.user.mapper.EduUserMapper;
import com.dimple.project.member.user.entity.EduUser;
import com.dimple.project.member.user.service.EduUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (EduUser)表服务实现类
 *
 * @author 刘登辉
 * @since 2020-03-10 17:57:12
 */
@Service
public class EduUserServiceImpl implements EduUserService {
    @Autowired
    private EduUserMapper eduUserMapper;
    
    @Override
    public List<EduUser> selectEduUser(EduUser eduUser) {
        return eduUserMapper.selectEduUser(eduUser);
    }
    
    @Override
    public int insertEduUser(EduUser eduUser) {
        return eduUserMapper.insertEduUser(eduUser);
    }
    
    @Override
    public int updateEduUser(EduUser eduUser) {
        return eduUserMapper.updateEduUser(eduUser);
    }
    
    @Override
    public int deleteEduUserByIds(Integer[] ids) {
        return eduUserMapper.deleteEduUserByIds(ids);
    }
    
     @Override
    public int deleteEduUserById(Integer id) {
        return eduUserMapper.deleteEduUserById(id);
    }

}