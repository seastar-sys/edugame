package com.dimple.project.member.member.service;

import com.dimple.project.member.member.domain.MemberUser;

import java.util.List;

/**
 * @className: IJobLogService
 * @description: 定时任务调度日志信息信息 服务层
 * @auther: Dimple
 * @Date: 2019/3/13
 * @Version: 1.1
 */
public interface MemberUserService {
    /***
     * 根据条件查询机器人列表
     * @param robot
     * @return
     */
    List<MemberUser> selectRobotUserList(MemberUser robot);

    /***
     * 查询未到期机器人
     * @return
     */
    List<MemberUser> selectTimeRobotUserList();
    /***
     * 新增机器人
     * @param robot
     * @return
     */
    int insertRobotUser(MemberUser robot);

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
    MemberUser selectRobotUserById(int id);;

    /***
     * 更新机器人信息
     * @param robot
     * @return
     */
    int updateRobotUser(MemberUser robot);
    /***
     * 更新机器人token
     * @param robot
     * @return
     */
    int updateRobotUserToken(MemberUser robot);
}
