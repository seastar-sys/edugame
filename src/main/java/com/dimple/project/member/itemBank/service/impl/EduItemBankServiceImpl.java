package com.dimple.project.member.itemBank.service.impl;

import com.dimple.project.member.itemBank.mapper.EduItemBankMapper;
import com.dimple.project.member.itemBank.entity.EduItemBank;
import com.dimple.project.member.itemBank.service.EduItemBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * (EduItemBank)表服务实现类
 *
 * @author 刘登辉
 * @since 2020-03-31 15:43:42
 */
@Service
public class EduItemBankServiceImpl implements EduItemBankService {
    @Autowired
    private EduItemBankMapper eduItemBankMapper;
    
    @Override
    public List<EduItemBank> selectEduItemBank(EduItemBank eduItemBank) {
        return eduItemBankMapper.selectEduItemBank(eduItemBank);
    }
    
    @Override
    public int insertEduItemBank(EduItemBank eduItemBank) {
        return eduItemBankMapper.insertEduItemBank(eduItemBank);
    }
    
    @Override
    public int updateEduItemBank(EduItemBank eduItemBank) {
        return eduItemBankMapper.updateEduItemBank(eduItemBank);
    }
    
    @Override
    public int deleteEduItemBankByIds(Integer[] ids) {
        return eduItemBankMapper.deleteEduItemBankByIds(ids);
    }
    
     @Override
    public int deleteEduItemBankById(Integer id) {
        return eduItemBankMapper.deleteEduItemBankById(id);
    }

}