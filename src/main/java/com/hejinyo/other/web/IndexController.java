package com.hejinyo.other.web;

import com.hejinyo.core.common.utils.PageParam;
import com.hejinyo.other.mapper.TableIpMapper;
import com.hejinyo.other.domain.TableIp;
import com.hejinyo.other.service.ITableIpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
    @Resource
    TableIpMapper dao;

    @Resource(name = "tableIpServiceImpl")
    ITableIpService service;

    @RequestMapping(value = "/ip")
    public String helloWorld(HttpServletRequest request) {
        String currPageStr = request.getParameter("page");
        int currPage = 1;
        try {
            currPage = Integer.parseInt(currPageStr);
        } catch (Exception e) {
        }

        // 获取总记录数
        int rowCount = service.getRowCount();
        PageParam pageParam = new PageParam();
        pageParam.setRowCount(rowCount);

        if (pageParam.getTotalPage() < currPage) {
            currPage = pageParam.getTotalPage();
        }
        pageParam.setCurrPage(currPage);
        pageParam = service.getIpListByPage(pageParam);
        request.setAttribute("pageParam", pageParam);
        return "page/index";
    }

    @RequestMapping("/ip/to_add")
    public String to_add(Model model) {
        model.addAttribute("result", "请添加数据！");
        return "/page/to_add";
    }

    @RequestMapping("/ip/add")
    public String add(Model model, @Validated TableIp tableIp, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> allError = bindingResult.getAllErrors();
            for(ObjectError o: allError){
                System.out.println(o.getDefaultMessage());
            }
            model.addAttribute("validated", bindingResult.getAllErrors());
            model.addAttribute("result", "数据不合法，添加失败！");
        } else {
            int count = service.addTable_Ip(tableIp);
            if (count > 0) {
                model.addAttribute("result", "添加成功！");
            } else {
                model.addAttribute("result", "数据库，添加失败！");
            }
        }
        return "/page/to_add";
    }
}
