package com.dimple.project.member.itemBank.mapper;



import com.dimple.project.member.itemBank.entity.EduItemBank;
import java.util.List;

/**
 * (EduItemBank)表数据库访问层
 *
 * @author 刘登辉
 * @since 2020-03-31 15:43:42
 */
public interface EduItemBankMapper{

    /***
     * 根据条件查询数据列表
     * @param eduItemBank
     * @return
     */
    List<EduItemBank> selectEduItemBank(EduItemBank eduItemBank);
    
    
    /***
     * 新增
     * @param eduItemBank
     * @return
     */
    int insertEduItemBank(EduItemBank eduItemBank);

    /***
     * 修改
     * @param eduItemBank
     * @return
     */
    int updateEduItemBank(EduItemBank eduItemBank);

    /***
     * 删除
     * @param ids
     * @return
     */
    int deleteEduItemBankByIds(Integer[] ids);
    
    /***
     * 通过id删除
     * @param id
     * @return
     */
    int deleteEduItemBankById(Integer id);

}