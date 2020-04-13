package com.dimple.project.robot.robot.service;

import com.dimple.project.robot.robot.domain.RobotUser;

import java.util.List;

/**
 * @className: IJobLogService
 * @description: 定时任务调度日志信息信息 服务层
 * @auther: Dimple
 * @Date: 2019/3/13
 * @Version: 1.1
 */
public interface RobotUserService {
    /***
     * 根据条件查询机器人列表
     * @param robot
     * @return
     */
    List<RobotUser> selectRobotUserList(RobotUser robot);

    /***
     * 查询未到期机器人
     * @return
     */
    List<RobotUser> selectTimeRobotUserList();
    /***
     * 新增机器人
     * @param robot
     * @return
     */
    int insertRobotUser(RobotUser robot);

    /**
     * 删除机器人
     * @param ids
     */
    int deleteRobotUserByIds(Integer[] ids);

    /**
     * 根据id查询机器人
     * @param id
     * @return
     */
    RobotUser selectRobotUserById(int id);;

    /***
     * 更新机器人信息
     * @param robot
     * @return
     */
    int updateRobotUser(RobotUser robot);
    /***
     * 更新机器人token
     * @param robot
     * @return
     */
    int updateRobotUserToken(RobotUser robot);
}
