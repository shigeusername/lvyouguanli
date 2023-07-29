package com.example.project.service;


import com.example.project.dao.AdministratorDao;
import com.example.project.entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdministratorDaoServiceImpl")
public class AdministratorDaoServiceImpl implements AdministratorDaoService {
    @Autowired
    AdministratorDao administratorDao;

    @Override
    public int add(Administrator administrator) {
        return administratorDao.add(administrator);
    }

    @Override
    public int delete(int id) {
        return administratorDao.delete(id);
    }

    @Override
    public int update(Administrator administrator) {
        return administratorDao.update(administrator);
    }

    @Override
    public List<Administrator> findAdministratorByName(String name) {
        return administratorDao.findAdministratorByName(name);
    }

    @Override
    public int findTotalNumber() {
        return administratorDao.findTotalNumber();
    }

    @Override
    public List<Administrator> findAll(int index, int pagesize) {
        index=(index-1)*pagesize;
        return administratorDao.findAll(index,pagesize);
    }

    @Override
    public Administrator findAdministratorById(int id) {
        return administratorDao.findAdministratorById(id);
    }

    @Override
    public List<Administrator> findAdministratorByAffiliatedEnterprise(int affiliated_enterprise) {
        return administratorDao.findAdministratorByAffiliatedEnterprise(affiliated_enterprise);
    }
}
