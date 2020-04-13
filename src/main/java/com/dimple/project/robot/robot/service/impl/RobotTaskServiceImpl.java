package com.dimple.project.robot.robot.service.impl;

import com.dimple.project.robot.robot.domain.RobotTask;
import com.dimple.project.robot.robot.domain.RobotUser;
import com.dimple.project.robot.robot.mapper.RobotTaskMapper;
import com.dimple.project.robot.robot.service.RobotTaskService;
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
public class RobotTaskServiceImpl implements RobotTaskService {
    @Autowired
    private RobotTaskMapper robotTaskMapper;
    /***
     * 查询最近一条task信息
     * @param groupid
     * @return
     */
    @Override
    public RobotTask selectRobotTask(String groupid) {
        return robotTaskMapper.selectRobotTask(groupid);
    }


    /***
     * 查询该task是否存在
     * @param task
     * @return
     */
    @Override
    public List<RobotTask> selectRobotTaskRepeat(RobotTask task) {
        return robotTaskMapper.selectRobotTaskRepeat(task);
    }
    /***
     * 新增task
     * @param task
     * @return
     */
    @Override
    public int insertRobotTask(RobotTask task) {
        return robotTaskMapper.insertRobotTask(task);
    }

    /***
     * 更新task
     * @param task
     * @return
     */
    @Override
    public int updateRobotTask(RobotTask task) {
        return robotTaskMapper.updateRobotTask(task);
    }

    /***
     * 根据id查询task
     * @param id
     * @return
     */
    @Override
    public RobotTask selectRobotTaskById(String id) {
        return robotTaskMapper.selectRobotTaskById(id);
    }
    /***
     * 更新logs次数
     * @param task
     * @return
     */
    @Override
    public int addRobotTaskLogs(RobotTask task) {
        return robotTaskMapper.addRobotTaskLogs(task);
    }
    /***
     *查询 0 ，1状态 且入库时间为30秒内的入库信息
     */
    @Override
    public List<RobotTask> timeRobotTaskList() {
        return robotTaskMapper.timeRobotTaskList();
    }

}
