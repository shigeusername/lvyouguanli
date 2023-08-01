package com.example.project.service;

import com.example.project.dao.TourismEnterpriseDao;
import com.example.project.entity.TourismEnterprise;
import com.example.project.entity.VO.ConciseTourismEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("TourismEnterpriseDaoServiceImpl")
public class TourismEnterpriseDaoServiceImpl implements TourismEnterpriseDaoService{
    @Autowired
    TourismEnterpriseDao tourismEnterpriseDAO;

    /*@Override
    public int addAttractions(TourismEnterprise tourismEnterprise) {
        return tourismEnterpriseDAO.addAttractions(tourismEnterprise);
    }

    @Override
    public int addHotels(TourismEnterprise tourismEnterprise) {
        return tourismEnterpriseDAO.addHotels(tourismEnterprise);
    }

    @Override
    public int addAgency(TourismEnterprise tourismEnterprise) {
        return tourismEnterpriseDAO.addAgency(tourismEnterprise);
    }*/

    @Override
    public int addTourismEnterprise(TourismEnterprise tourismEnterprise) {
        return tourismEnterpriseDAO.addTourismEnterprise(tourismEnterprise);
    }

    @Override
    public int delete(int id) {
        return tourismEnterpriseDAO.delete(id);
    }

    @Override
    public int update(TourismEnterprise tourismEnterprise) {
        return tourismEnterpriseDAO.update(tourismEnterprise);
    }

    @Override
    public TourismEnterprise findTourismEnterpriseByName(String name) {
        return tourismEnterpriseDAO.findTourismEnterpriseByName(name);
    }

    @Override
    public int findTotalNumberOfAttractions() {
        return tourismEnterpriseDAO.findTotalNumberOfAttractions();
    }

    @Override
    public int findTotalNumberOfHotels() {
        return tourismEnterpriseDAO.findTotalNumberOfHotels();
    }

    @Override
    public int findTotalNumberOfAgency() {
        return tourismEnterpriseDAO.findTotalNumberOfAgency();
    }

    @Override
    public List<TourismEnterprise> findPageAttractions(int index, int pagesize) {
        index=(index-1)*pagesize;
        return tourismEnterpriseDAO.findPageAttractions(index,pagesize);
    }

    @Override
    public List<TourismEnterprise> findPageHotels(int index, int pagesize) {
        index=(index-1)*pagesize;
        return tourismEnterpriseDAO.findPageHotels(index,pagesize);
    }

    @Override
    public List<TourismEnterprise> findPageAgency(int index, int pagesize) {
        index=(index-1)*pagesize;
        return tourismEnterpriseDAO.findPageAgency(index,pagesize);
    }

    @Override
    public List<ConciseTourismEnterprise> findThreeAttractions() {
        return tourismEnterpriseDAO.findThreeAttractions();
    }

    @Override
    public List<ConciseTourismEnterprise> findThreeHotels() {
        return tourismEnterpriseDAO.findThreeHotels();
    }

    @Override
    public List<ConciseTourismEnterprise> findThreeAgency() {
        return tourismEnterpriseDAO.findThreeAgency();
    }

    @Override
    public List<ConciseTourismEnterprise> findAllAttractions() {
        return tourismEnterpriseDAO.findAllAttractions();
    }

    @Override
    public List<ConciseTourismEnterprise> findAllHotels() {
        return tourismEnterpriseDAO.findAllHotels();
    }

    @Override
    public List<ConciseTourismEnterprise> findAllAgency() {
        return tourismEnterpriseDAO.findAllAgency();
    }

    @Override
    public TourismEnterprise findTourismEnterpriseById(int id) {
        return tourismEnterpriseDAO.findTourismEnterpriseById(id);
    }

    //根据投诉表修改企业的诚信分数 shao
    @Override
    public int updateCreditByComplaint(int eid,double fen){return tourismEnterpriseDAO.updateCreditByComplaint(eid,fen);}

    @Override
    public List<Map<String, Object>> selectAllTourismEnterprise() {
        return tourismEnterpriseDAO.selectAllTourismEnterprise();
    }
}
