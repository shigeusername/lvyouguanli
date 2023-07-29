package com.example.project.dao;

import com.example.project.entity.Warning;

import java.util.List;

public interface WarningDao {
    List<Warning> findAllWarning();

    Warning findWarningById();

    List<Warning> findAllWarningNeedCope();

    List<Warning> findAllWarningNoRequired();

    List<Warning> findAllWarningCoping();

    List<Warning> findAllWarningDone();

    int AddWarning(Warning Warning);

    int DeleteWarningById(int id);

    int DeleteWarningCoped();

    int UpdateWarning(Warning Warning);
}
