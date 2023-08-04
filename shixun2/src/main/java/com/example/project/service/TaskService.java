package com.example.project.service;

import com.example.project.entity.TourismEnterprise;
import com.example.project.entity.Warning;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TaskService {

    public Boolean Flag = true;

    @Async("taskExecutor")
    public void doTask(TourismEnterpriseDaoServiceImpl tourismEnterpriseDaoService, WarningDaoServiceImpl warningDaoService) throws Exception {
        this.Flag = true;
        while (Flag) {
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<TourismEnterprise> tourismEnterprises = tourismEnterpriseDaoService.selectAllTourismAndHotel();
            for (TourismEnterprise enterprise : tourismEnterprises) {
                if (enterprise.getCurrent_people() * 1.0 / enterprise.getCapacity() > 0.8) {
                    Warning warning = new Warning(enterprise.getName() + "当前人数已达最大容量的80%", 0, "0", new Timestamp(System.currentTimeMillis()), "监控人数");
                    warningDaoService.AddWarning(warning);
                }
                if (enterprise.getCurrent_parking() * 1.0 / enterprise.getParking_space() > 0.8) {
                    Warning warning = new Warning(enterprise.getName() + "80%的停车位已被使用", 0, "0", new Timestamp(System.currentTimeMillis()), "监控停车位");
                    warningDaoService.AddWarning(warning);
                }
            }
            long end = System.currentTimeMillis();
            Thread.sleep(6000000);
            System.out.println("完成任务耗时：" + (end - start) / 1000 + "秒");
            System.out.println(Flag);
        }
        System.out.println(("结束"));
    }

    @Async("taskExecutor")
    public void closeTask() {
        this.Flag = false;
    }

}
