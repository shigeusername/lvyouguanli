package com.example.project.controller;

import com.example.project.service.TaskService;
import com.example.project.service.TourismEnterpriseDaoServiceImpl;
import com.example.project.service.WarningDaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Qualifier("taskExecutor")
    @Autowired
    private Executor taskExecutor;
    @Autowired
    private TourismEnterpriseDaoServiceImpl tourismEnterpriseDaoService;
    @Autowired
    private WarningDaoServiceImpl warningDaoService;
    @GetMapping("start")
    public void start() throws Exception {
        //这里会执行你开启的任务 然后业务是在后台运行的
        taskService.doTask(tourismEnterpriseDaoService,warningDaoService);
    }
    //这里我们可以通过接口实时观看效果 具体效果如下图
    @GetMapping("start/asyncExceutor")
    public Map getThreadInfo() {
        Map map = new HashMap();
        Object[] myThread = {taskExecutor};
        for (Object thread : myThread) {
            ThreadPoolTaskExecutor threadTask = (ThreadPoolTaskExecutor) thread;
            ThreadPoolExecutor threadPoolExecutor = threadTask.getThreadPoolExecutor();
            System.out.println("提交任务数" + threadPoolExecutor.getTaskCount());
            System.out.println("完成任务数" + threadPoolExecutor.getCompletedTaskCount());
            System.out.println("当前有" + threadPoolExecutor.getActiveCount() + "个线程正在处理任务");
            System.out.println("还剩" + threadPoolExecutor.getQueue().size() + "个任务");
            map.put("提交任务数-->", threadPoolExecutor.getTaskCount());
            map.put("完成任务数-->", threadPoolExecutor.getCompletedTaskCount());
            map.put("当前有多少线程正在处理任务-->", threadPoolExecutor.getActiveCount());
            map.put("还剩多少个任务未执行-->", threadPoolExecutor.getQueue().size());
            map.put("当前可用队列长度-->", threadPoolExecutor.getQueue().remainingCapacity());
        }
        return map;
    }
}