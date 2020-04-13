package com.dimple.project.member.speed.service;


import com.dimple.project.member.speed.entity.EduSpeed;
import java.util.List;

/**
 * (EduSpeed)表服务接口
 *
 * @author 刘登辉
 * @since 2020-03-04 18:48:27
 */
public interface EduSpeedService{

    /***
     * 根据条件查询数据列表
     * @param eduSpeed
     * @return
     */
    List<EduSpeed> selectEduSpeed(EduSpeed eduSpeed);
    
    /***
     * 新增
     * @param eduSpeed
     * @return
     */
    int insertEduSpeed(EduSpeed eduSpeed);

    /***
     * 修改
     * @param eduSpeed
     * @return
     */
    int updateEduSpeed(EduSpeed eduSpeed);

    /***
     * 批量删除
     * @param ids
     * @return
     */
    int deleteEduSpeedByIds(Integer[] ids);
    
    /***
     * 通过id删除
     * @param id
     * @return
     */
    int deleteEduSpeedById(Integer id);
}