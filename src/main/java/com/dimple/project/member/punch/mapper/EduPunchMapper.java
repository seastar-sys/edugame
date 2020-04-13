package com.dimple.project.member.punch.mapper;



import com.dimple.project.member.punch.entity.EduPunch;
import java.util.List;

/**
 * (EduPunch)表数据库访问层
 *
 * @author 刘登辉
 * @since 2020-03-30 18:03:34
 */
public interface EduPunchMapper{

    /***
     * 根据条件查询数据列表
     * @param eduPunch
     * @return
     */
    List<EduPunch> selectEduPunch(EduPunch eduPunch);

    /***
     * 根据用户id查询打卡记录
     * @param id
     * @return
     */
    List<String> selectEduPuncHistory(int id);


    
    /***
     * 新增
     * @param eduPunch
     * @return
     */
    int insertEduPunch(EduPunch eduPunch);

    /***
     * 修改
     * @param eduPunch
     * @return
     */
    int updateEduPunch(EduPunch eduPunch);

    /***
     * 删除
     * @param ids
     * @return
     */
    int deleteEduPunchByIds(Integer[] ids);
    
    /***
     * 通过id删除
     * @param id
     * @return
     */
    int deleteEduPunchById(Integer id);

}