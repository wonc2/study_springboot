package com.yojulab.study_springboot.controller;

import com.yojulab.study_springboot.service.CarCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/carcompany/")
public class CarCompanyController {
    @Autowired
    CarCompanyService carCompanyService;

    @GetMapping("/car_company")
    public ModelAndView carCompany(ModelAndView modelAndView) {
        Object result = carCompanyService.carCompanyList();
        modelAndView.addObject("result", result);

        modelAndView.setViewName("/WEB-INF/views/carcompany/car_company.jsp");
        return modelAndView;
    }

    @GetMapping("/car_company_search")
    public ModelAndView carCompanySearch(@RequestParam Map params, ModelAndView modelAndView) {
        Object result = carCompanyService.carCompanySearchList(params);
        modelAndView.addObject("result", result);
        modelAndView.addObject("params", params);

        modelAndView.setViewName("/WEB-INF/views/carcompany/car_company_search.jsp");
        return modelAndView;
    }
}
