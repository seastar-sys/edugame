package com.dimple.project.member.member.service.impl;

import com.dimple.project.member.member.domain.MemberUser;
import com.dimple.project.member.member.mapper.MemberUserMapper;
import com.dimple.project.member.member.service.MemberUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: JobLogServiceImpl
 * @description: 定时任务调度日志信息 服务层
 * @auther: Dimple
 * @Date: 2019/3/13
 * @Version: 1.1
 */
@Service
public class MemberUserServiceImpl implements MemberUserService {
    @Autowired
    private MemberUserMapper robotUserMapper;

    /***
     * 查询机器人列表
     * @param robot
     * @return
     */
    @Override
    public List<MemberUser> selectRobotUserList(MemberUser robot) {
        return robotUserMapper.selectRobotUserList(robot);
    }

    /***
     * 查询未到期机器人
     * @return
     */
    @Override
    public List<MemberUser> selectTimeRobotUserList() {
        return robotUserMapper.selectTimeRobotUserList();
    }
    /***
     * 新增机器人
     * @param robot
     * @return
     */
    @Override
    public int insertRobotUser(MemberUser robot) {
        return robotUserMapper.insertRobotUser(robot);
    }
    /**
     * 删除机器人
     * @param ids
     */
    @Override
    public int deleteRobotUserByIds(Integer[] ids) {
        return robotUserMapper.deleteRobotUserByIds(ids);
    }

    /**
     * 根据id查询机器人
     * @param id
     * @return
     */
    @Override
    public MemberUser selectRobotUserById(int id) {
        return robotUserMapper.selectRobotUserById(id);
    }

    /***
     * 更新机器人信息
     * @param robot
     * @return
     */
    @Override
    public int updateRobotUser(MemberUser robot) {
        return robotUserMapper.updateRobotUser(robot);
    }

    /***
     * 更新机器人token
     * @param robot
     * @return
     */
    @Override
    public int updateRobotUserToken(MemberUser robot) {
        return robotUserMapper.updateRobotUserToken(robot);
    }
}
