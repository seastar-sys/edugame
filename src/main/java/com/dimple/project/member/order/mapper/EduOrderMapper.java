package com.dimple.project.member.order.mapper;



import com.dimple.project.member.order.entity.EduOrder;
import java.util.List;

/**
 * (EduOrder)表数据库访问层
 *
 * @author 刘登辉
 * @since 2020-03-10 22:36:41
 */
public interface EduOrderMapper{

    /***
     * 根据条件查询数据列表
     * @param eduOrder
     * @return
     */
    List<EduOrder> selectEduOrder(EduOrder eduOrder);
    
    
    /***
     * 新增
     * @param eduOrder
     * @return
     */
    int insertEduOrder(EduOrder eduOrder);

    /***
     * 修改
     * @param eduOrder
     * @return
     */
    int updateEduOrder(EduOrder eduOrder);

    /***
     * 删除
     * @param ids
     * @return
     */
    int deleteEduOrderByIds(Integer[] ids);
    
    /***
     * 通过id删除
     * @param id
     * @return
     */
    int deleteEduOrderById(Integer id);

}