package com.example.project.dao;

import com.example.project.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdministratorDao {
    //新增数据
    int add(Administrator administrator);

    //删除数据
    int delete(int id);

    //更新数据
    int update(Administrator administrator);

    //根据姓名查找
    List<Administrator> findAdministratorByName(String name);

    //查找企业管理人员的总数
    int findTotalNumber();

    //查找每一页的管理人员信息
    List<Administrator> findAll(int index, int pagesize);

    //根据id查找管理人员
    Administrator findAdministratorById(int id);

    //根据affiliated_enterprise查找与该企业相关的管理人员
    List<Administrator> findAdministratorByAffiliatedEnterprise(int affiliated_enterprise);
}
