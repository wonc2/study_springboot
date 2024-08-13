package com.yojulab.study_springboot.service;

import com.yojulab.study_springboot.dao.SharedDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class CarCompanyService {
    @Autowired
    SharedDao sharedDao;

    public Map carCompanyList(Map dataMap) {
        HashMap result = new HashMap<>();
        String sqlMapId = "CarCompany.getAllList";
        result.put("resultList", sharedDao.getList(sqlMapId, dataMap)); // 표현된 레코드 정보
        return result;
    }

    public Object carCompanySearchList(Map dataMap) {
        HashMap result = new HashMap<>();
        String sqlMapId = "CarCompany.getSearchList";
        result.put("resultList", sharedDao.getList(sqlMapId, dataMap)); // 표현된 레코드 정보
        return result;
    }

    public Object deleteAtList(String uniqueId, Map dataMap) {
        dataMap.put("CI_PK", uniqueId);

        HashMap result = new HashMap();
        result.put("deleteCount", this.delete(dataMap));

        // 삭제하고 리스트 받아와서 내리는용 ?
        result.putAll(this.carCompanyList(dataMap));
        return result;
    }

    public Object delete(Map dataMap) {
        String sqlMapId = "CarCompany.deleteCarFk";
        sharedDao.delete(sqlMapId, dataMap);
        sqlMapId = "CarCompany.deleteCarPk";
        Object result = sharedDao.delete(sqlMapId, dataMap);

        return result;
    }

    public Object selectDetail(String CI_PK, Map dataMap) {
        String sqlMapId = "CarCompany.selectDetail";
        dataMap.put("CI_PK", CI_PK);

        Object result = sharedDao.getOne(sqlMapId, dataMap);
        return result;
    }
}