package com.dimple.project.member.user.mapper;



import com.dimple.project.member.user.entity.EduUser;
import java.util.List;

/**
 * (EduUser)表数据库访问层
 *
 * @author 刘登辉
 * @since 2020-03-10 17:57:13
 */
public interface EduUserMapper{

    /***
     * 根据条件查询数据列表
     * @param eduUser
     * @return
     */
    List<EduUser> selectEduUser(EduUser eduUser);
    
    
    /***
     * 新增
     * @param eduUser
     * @return
     */
    int insertEduUser(EduUser eduUser);

    /***
     * 修改
     * @param eduUser
     * @return
     */
    int updateEduUser(EduUser eduUser);

    /***
     * 删除
     * @param ids
     * @return
     */
    int deleteEduUserByIds(Integer[] ids);
    
    /***
     * 通过id删除
     * @param id
     * @return
     */
    int deleteEduUserById(Integer id);

}