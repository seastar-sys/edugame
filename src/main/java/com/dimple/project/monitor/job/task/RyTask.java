package com.dimple.project.monitor.job.task;

import com.dimple.project.robot.robot.service.RobotTaskService;
import com.dimple.project.robot.robot.service.RobotUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className: RyTask
 * @description: 定时任务调度测试
 * @auther: Dimple
 * @Date: 2019/3/13
 * @Version: 1.1
 */
@Component("ryTask")
public class RyTask {
    @Autowired
    private RobotUserService robotUserService;
    @Autowired
    private RobotTaskService robotTaskService;

    /***
     *定时执行消息发送
     * @param params
     */
    public void ryParams(String params) {
        System.out.println("数据下发");
    }
    /***
     * 定时执行数据入库
     */
    public void ryNoParams() {

    }
}
