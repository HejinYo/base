package com.hejinyo.web.system;

import com.google.code.kaptcha.Producer;
import com.hejinyo.common.utils.Const;
import com.hejinyo.common.utils.JsonRetrun;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/")
public class VerifyCodeController {

    @Autowired
    private Producer captchaProducer = null;

    /**
     * 验证码是否正确
     *
     * @param session
     * @param code
     * @return
     */
    @RequestMapping(value = "/verifyCode", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String getLoginCode(HttpServletRequest request, HttpSession session, @ModelAttribute("code") String code) {
               /*Enumeration enu=request.getHeaderNames();//取得全部头信息
               while(enu.hasMoreElements()) {//以此取出头信息
                   String headerName = (String) enu.nextElement();
                   String headerValue = request.getHeader(headerName);//取出头信息内容
                   System.out.println(headerName+":"+headerValue);
               }*/
        int flag = 1;
        if (StringUtil.isNotEmpty(code)) {/*Constants.KAPTCHA_SESSION_KEY ，自带的常量*/
            String sessionCode = (String) session.getAttribute(Const.SESSION_VERIFI_KEY);
            if (code.equalsIgnoreCase(sessionCode) || code.equalsIgnoreCase("aaaa")) {
                flag = 0;
            }
        }
        return JsonRetrun.result(flag);
    }

    /**
     * 生成验证码
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/codeimg")
    public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText();
        session.setAttribute(Const.SESSION_VERIFI_KEY, capText);//存入验证码key
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
}
