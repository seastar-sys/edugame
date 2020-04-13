package com.dimple.project.member.history.mapper;



import com.dimple.project.member.history.entity.EduHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * (EduHistory)表数据库访问层
 *
 * @author 刘登辉
 * @since 2020-03-30 14:20:16
 */
public interface EduHistoryMapper{

    /***
     * 查询当天学习记录
     * @param userId
     * @return
     */
    List<EduHistory> selectEduHistoryTody(Integer userId);

    /***
     * 根据条件查询数据列表
     * @param eduHistory
     * @return
     */
    List<EduHistory> selectEduHistory(EduHistory eduHistory);

    /***
     * 查询当天学习情况
     * @param id 用户id
     * @return
     */
    Map<String,Object> selectEduHistoryStudy(int id);


    /***
     * 查询所有学习情况
     * @param id 用户id
     * @return
     */
    Map<String,Object> selectEduHistoryStudyCount(int id);




    /***
     * 查询前十名
     * @return
     */
    List<Map<String,Object>> selectEduHistoryStudyRanking();


    /***
     * 新增
     * @param eduHistory
     * @return
     */
    int insertEduHistory(EduHistory eduHistory);

    /***
     * 修改
     * @param eduHistory
     * @return
     */
    int updateEduHistory(EduHistory eduHistory);

    /***
     * 删除
     * @param ids
     * @return
     */
    int deleteEduHistoryByIds(Integer[] ids);
    
    /***
     * 通过id删除
     * @param id
     * @return
     */
    int deleteEduHistoryById(Integer id);

    /***
     * 获取当前打关卡信息
     * @param id
     * @return
     */
    Map<String, Object> getGradeState(@Param("id")Integer id, @Param("chapter")int chapter, @Param("section")int section);
}