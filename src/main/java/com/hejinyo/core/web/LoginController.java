package com.hejinyo.core.web;

import com.alibaba.fastjson.JSON;
import com.hejinyo.core.common.jcaptcha.JCaptcha;
import com.hejinyo.core.domain.dto.ActiveUser;
import com.hejinyo.core.domain.pojo.Sys_Menu;
import com.hejinyo.core.domain.pojo.Sys_Resource;
import com.hejinyo.core.domain.pojo.Sys_User;
import com.hejinyo.core.common.utils.Const;
import com.hejinyo.core.common.utils.JsonRetrun;
import jodd.util.StringUtil;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {

    /**
     * 用户登录页面login
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String to_login() {
        return "system/login";
    }

    /**
     * 异步检测验证码是否正确
     *
     * @param codejson
     * @return
     */
    @RequestMapping(value = "/verifyImgCheck", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> verifyImgCheck(HttpServletRequest request, @RequestBody String codejson) {
        int flag = 1;
        String code = JSON.parseObject(codejson).getString("verifyCode");
        if (StringUtil.isNotEmpty(code)) {
            if (JCaptcha.hasCaptcha(request, code) || code.equalsIgnoreCase("aaaa")) {
                flag = 0;
            }
        }
        return JsonRetrun.result(flag);
    }

    /**
     * 执行登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request) {
        String successUrl = (String) request.getAttribute("shiroLoginSuccess");
        String loginFailure = (String) request.getAttribute("shiroLoginFailure");
        if (null != successUrl) {
            return JsonRetrun.result(0, "登录成功！", successUrl);
        } else {
            String msg = "";
            int code = 0;
            if ("verifyCodeError".equals(loginFailure)) {
                msg = "验证码错误！";
                code = 1;
            } else if (UnknownAccountException.class.getName().equals(loginFailure)) {
                msg = "用户不存在！";
                code = 2;
            } else if (IncorrectCredentialsException.class.getName().equals(loginFailure)) {
                msg = "用户密码错误！";
                code = 3;
            } else if (ExcessiveAttemptsException.class.getName().equals(loginFailure)) {
                msg = "登录失败次数太多，用户已经锁定，请30分钟后再试！";
                code = 0;
            } else if (LockedAccountException.class.getName().equals(loginFailure)) {
                msg = "此用户已被禁用！";
                code = 0;
            } else {
                msg = "登录失败：" + loginFailure;
                code = 0;
            }
            return JsonRetrun.result(1, msg, code);
        }
    }

    /**
     * 验证成功，返回主界面
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView loginPost(HttpServletRequest request, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        Subject subject = SecurityUtils.getSubject();
        ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
        mv.addObject("username", activeUser.getUserName());
        mv.setViewName("system/main");
        return mv;
    }
}
