package com.gray.controller;

import com.gray.dao.FunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 创建Controller
 * Created by gray on 2017/5/7.
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final FunctionMapper functionMapper;

    @Autowired
    public DashboardController(FunctionMapper functionMapper) {
        this.functionMapper = functionMapper;
    }

    @GetMapping("/{module}.html")
    public String toIndex(Model model, @PathVariable String module) {
        model.addAttribute("functions", functionMapper.selectAll());
        //model
        model.addAttribute("module", module);
        return "dashboard/main";
    }

}
