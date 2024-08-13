package com.yojulab.study_springboot.service;

import com.yojulab.study_springboot.dao.CarCompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CarCompanyService {
    @Autowired
    CarCompanyDao carCompanyDao;

    public Map carCompanyList() {
        HashMap result = new HashMap<>();
        String sqlMapId = "CarCompany.getAllList";
        result.put("resultList", carCompanyDao.getList(sqlMapId)); // 표현된 레코드 정보
        return result;
    }

    public Object carCompanySearchList(Map dataMap) {
        HashMap result = new HashMap<>();
        String sqlMapId = "CarCompany.getSearchList";
        result.put("resultList", carCompanyDao.getSearchList(sqlMapId, dataMap)); // 표현된 레코드 정보
        return result;
    }
}
