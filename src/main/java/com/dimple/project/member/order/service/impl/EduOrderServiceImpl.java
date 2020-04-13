package com.dimple.project.member.order.service.impl;

import com.dimple.project.member.order.mapper.EduOrderMapper;
import com.dimple.project.member.order.entity.EduOrder;
import com.dimple.project.member.order.service.EduOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (EduOrder)表服务实现类
 *
 * @author 刘登辉
 * @since 2020-03-10 22:36:40
 */
@Service
public class EduOrderServiceImpl implements EduOrderService {
    @Autowired
    private EduOrderMapper eduOrderMapper;
    
    @Override
    public List<EduOrder> selectEduOrder(EduOrder eduOrder) {
        return eduOrderMapper.selectEduOrder(eduOrder);
    }
    
    @Override
    public int insertEduOrder(EduOrder eduOrder) {
        return eduOrderMapper.insertEduOrder(eduOrder);
    }
    
    @Override
    public int updateEduOrder(EduOrder eduOrder) {
        return eduOrderMapper.updateEduOrder(eduOrder);
    }
    
    @Override
    public int deleteEduOrderByIds(Integer[] ids) {
        return eduOrderMapper.deleteEduOrderByIds(ids);
    }
    
     @Override
    public int deleteEduOrderById(Integer id) {
        return eduOrderMapper.deleteEduOrderById(id);
    }

}