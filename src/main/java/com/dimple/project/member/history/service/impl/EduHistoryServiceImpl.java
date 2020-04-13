package com.dimple.project.member.history.service.impl;

import com.dimple.project.member.history.mapper.EduHistoryMapper;
import com.dimple.project.member.history.entity.EduHistory;
import com.dimple.project.member.history.service.EduHistoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * (EduHistory)表服务实现类
 *
 * @author 刘登辉
 * @since 2020-03-30 14:20:16
 */
@Service
public class EduHistoryServiceImpl implements EduHistoryService {
    @Autowired
    private EduHistoryMapper eduHistoryMapper;

    @Override
    public Map<String, Object> getGradeState(@Param("id")Integer id, @Param("chapter")int chapter, @Param("section")int section) {
        return eduHistoryMapper.getGradeState(id,chapter,section);
    }

    @Override
    public List<EduHistory> selectEduHistoryTody(Integer userId) {
        return eduHistoryMapper.selectEduHistoryTody(userId);
    }

    @Override
    public List<EduHistory> selectEduHistory(EduHistory eduHistory) {
        return eduHistoryMapper.selectEduHistory(eduHistory);
    }

    @Override
    public Map<String,Object> selectEduHistoryStudy(int id) {
        return eduHistoryMapper.selectEduHistoryStudy(id);
    }

    @Override
    public Map<String,Object> selectEduHistoryStudyCount(int id) {
        return eduHistoryMapper.selectEduHistoryStudyCount(id);
    }

    @Override
    public List<Map<String,Object>> selectEduHistoryStudyRanking() {
        return eduHistoryMapper.selectEduHistoryStudyRanking();
    }

    @Override
    public int insertEduHistory(EduHistory eduHistory) {
        return eduHistoryMapper.insertEduHistory(eduHistory);
    }
    
    @Override
    public int updateEduHistory(EduHistory eduHistory) {
        return eduHistoryMapper.updateEduHistory(eduHistory);
    }
    
    @Override
    public int deleteEduHistoryByIds(Integer[] ids) {
        return eduHistoryMapper.deleteEduHistoryByIds(ids);
    }
    
     @Override
    public int deleteEduHistoryById(Integer id) {
        return eduHistoryMapper.deleteEduHistoryById(id);
    }

}