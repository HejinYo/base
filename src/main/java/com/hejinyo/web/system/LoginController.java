package com.hejinyo.web.system;

import com.hejinyo.pojo.system.Sys_User;
import com.hejinyo.common.utils.Const;
import com.hejinyo.common.utils.JsonRetrun;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
     * shiro formAuthenticationFilter基于表单验证登录，登录完成，跳转到登录前的页面
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/login_from")
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "system/login_from";
    }

    /**
     * 执行登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String login(HttpSession session, @RequestBody String json) {
       /* JSONObject jsonObject = JSONObject.fromObject(json);
                String verifi = jsonObject.getString("verifi");
                String username = jsonObject.getString("username");
                String password = Tools.loginDecoder(username, jsonObject.getString("loginpw"));

                if ("admin".equals(username)) {
                    session.removeAttribute(Const.SESSION_VERIFI_KEY);//验证码失效
                    session.setAttribute(Const.SESSION_USER_INFO, username);
                    return JsonRetrun.result(0, "登录成功！");
                } else {
                    return JsonRetrun.result(1, "登录失败！");
                }*/
        JSONObject jsonObject = JSONObject.fromObject(json);
        String username = jsonObject.getString("username");
        UsernamePasswordToken token = new UsernamePasswordToken(username, "123456");
        Subject subject = SecurityUtils.getSubject();

        String error = null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            error = "用户名/密码错误";
        } catch (IncorrectCredentialsException e) {
            error = "用户名/密码错误";
        } catch (AuthenticationException e) {
            //其他错误，比如锁定，如果想单独处理请单独catch处理
            e.printStackTrace();
            error = "其他错误：" + e.getMessage();
        }
        if (error != null) {//出错了，返回登录页面
            return JsonRetrun.result(1, "登录失败！" + error);
        } else {//登录成功
            Sys_User sys_user = (Sys_User) subject.getPrincipal();
            return JsonRetrun.result(0, "登录成功！" + sys_user.getReal_name());
        }
    }

    /**
     * 注销登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute(Const.SESSION_USER_INFO);
        return "to_login";
    }

    /**
     * 验证成功，返回主界面
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView loginPost(HttpServletRequest request, HttpSession session) {
        /*String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
                if (Tools.isNull(sessionCode).equals(code)) {
                    session.removeAttribute(Constants.KAPTCHA_SESSION_KEY);
                }*/
        ModelAndView mv = new ModelAndView();
        mv.setViewName("system/home");
        return mv;
    }
}
