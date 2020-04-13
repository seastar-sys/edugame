package com.dimple.project.member.speed.mapper;



import com.dimple.project.member.speed.entity.EduSpeed;
import java.util.List;

/**
 * (EduSpeed)表数据库访问层
 *
 * @author 刘登辉
 * @since 2020-03-04 18:48:27
 */
public interface EduSpeedMapper{

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
     * 删除
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