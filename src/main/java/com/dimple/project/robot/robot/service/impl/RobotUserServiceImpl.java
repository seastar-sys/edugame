package com.dimple.project.robot.robot.service.impl;

import com.dimple.common.utils.text.Convert;
import com.dimple.project.robot.robot.domain.RobotUser;
import com.dimple.project.robot.robot.mapper.RobotUserMapper;
import com.dimple.project.robot.robot.service.RobotUserService;
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
public class RobotUserServiceImpl implements RobotUserService {
    @Autowired
    private RobotUserMapper robotUserMapper;

    /***
     * 查询机器人列表
     * @param robot
     * @return
     */
    @Override
    public List<RobotUser> selectRobotUserList(RobotUser robot) {
        return robotUserMapper.selectRobotUserList(robot);
    }

    /***
     * 查询未到期机器人
     * @return
     */
    @Override
    public List<RobotUser> selectTimeRobotUserList() {
        return robotUserMapper.selectTimeRobotUserList();
    }
    /***
     * 新增机器人
     * @param robot
     * @return
     */
    @Override
    public int insertRobotUser(RobotUser robot) {
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
    public RobotUser selectRobotUserById(int id) {
        return robotUserMapper.selectRobotUserById(id);
    }

    /***
     * 更新机器人信息
     * @param robot
     * @return
     */
    @Override
    public int updateRobotUser(RobotUser robot) {
        return robotUserMapper.updateRobotUser(robot);
    }

    /***
     * 更新机器人token
     * @param robot
     * @return
     */
    @Override
    public int updateRobotUserToken(RobotUser robot) {
        return robotUserMapper.updateRobotUserToken(robot);
    }
}
