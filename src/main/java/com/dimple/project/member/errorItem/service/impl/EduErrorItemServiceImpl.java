package com.dimple.project.member.errorItem.service.impl;

import com.dimple.project.member.errorItem.mapper.EduErrorItemMapper;
import com.dimple.project.member.errorItem.entity.EduErrorItem;
import com.dimple.project.member.errorItem.service.EduErrorItemService;
import com.dimple.project.member.itemBank.entity.EduItemBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (EduErrorItem)表服务实现类
 *
 * @author 刘登辉
 * @since 2020-04-04 00:44:25
 */
@Service
public class EduErrorItemServiceImpl implements EduErrorItemService {
    @Autowired
    private EduErrorItemMapper eduErrorItemMapper;
    
    @Override
    public List<EduErrorItem> selectEduErrorItem(EduErrorItem eduErrorItem) {
        return eduErrorItemMapper.selectEduErrorItem(eduErrorItem);
    }

    @Override
    public List<EduItemBank> selectEduErrorItemAll(int userId, int chapter, int section, int subjectNumber) {
        return eduErrorItemMapper.selectEduErrorItemAll(userId,chapter,section,subjectNumber);
    }

    @Override
    public int insertEduErrorItem(EduErrorItem eduErrorItem) {
        return eduErrorItemMapper.insertEduErrorItem(eduErrorItem);
    }
    
    @Override
    public int updateEduErrorItem(EduErrorItem eduErrorItem) {
        return eduErrorItemMapper.updateEduErrorItem(eduErrorItem);
    }
    
    @Override
    public int deleteEduErrorItemByIds(Integer[] ids) {
        return eduErrorItemMapper.deleteEduErrorItemByIds(ids);
    }


    @Override
    public int deleteEduErrorItemList(int userId, int chapter, int section, int subjectNumber) {
        return eduErrorItemMapper.deleteEduErrorItemList(userId,chapter,section,subjectNumber);
    }
    
     @Override
    public int deleteEduErrorItemById(Integer id) {
        return eduErrorItemMapper.deleteEduErrorItemById(id);
    }

}