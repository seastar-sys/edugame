package com.dimple.project.member.errorItem.mapper;



import com.dimple.project.member.errorItem.entity.EduErrorItem;
import com.dimple.project.member.itemBank.entity.EduItemBank;

import java.util.List;

/**
 * (EduErrorItem)表数据库访问层
 *
 * @author 刘登辉
 * @since 2020-04-04 00:44:26
 */
public interface EduErrorItemMapper{

    /***
     * 根据条件查询数据列表
     * @param eduErrorItem
     * @return
     */
    List<EduErrorItem> selectEduErrorItem(EduErrorItem eduErrorItem);

    /***
     * 获取错题集关联题目信息
     * @param userId
     * @param chapter
     * @param section
     * @param subjectNumber
     * @return
     */
    List<EduItemBank> selectEduErrorItemAll(int userId, int chapter, int section, int subjectNumber);
    /***
     * 新增
     * @param eduErrorItem
     * @return
     */
    int insertEduErrorItem(EduErrorItem eduErrorItem);

    /***
     * 修改
     * @param eduErrorItem
     * @return
     */
    int updateEduErrorItem(EduErrorItem eduErrorItem);

    /***
     * 删除
     * @param ids
     * @return
     */
    int deleteEduErrorItemByIds(Integer[] ids);

    /***
     * 删除错题记录
     * @param userId
     * @param chapter
     * @param section
     * @param subjectNumber
     * @return
     */
    int deleteEduErrorItemList(int userId, int chapter, int section, int subjectNumber);
    
    /***
     * 通过id删除
     * @param id
     * @return
     */
    int deleteEduErrorItemById(Integer id);

}