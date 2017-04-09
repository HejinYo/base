package com.hejinyo.core.common.exception;

import com.hejinyo.core.common.utils.JsonRetrun;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ExceptionController {

    @RequestMapping(value = "/404")
    public ModelAndView error_404(HttpServletRequest request, HttpServletResponse response) {
        return exceptionReturn(request, response, 404);
    }

    @RequestMapping(value = "/500")
    public ModelAndView error_500(HttpServletRequest request, HttpServletResponse response) {
        return exceptionReturn(request, response, 500);
    }

    private ModelAndView exceptionReturn(HttpServletRequest request, HttpServletResponse response, int code) {
        String accept = request.getHeader("accept");//指定客户端能够接收的内容类型
        String content = request.getHeader("content-type");//请求的与实体对应的MIME信息
        String getHeaderX = request.getHeader("X-Requested-With");//Jquery AJAX特有的一个参数
        if (accept != null && !(accept.indexOf("application/json") > -1 ||
                (getHeaderX != null && getHeaderX.indexOf("XMLHttpRequest") > -1) ||
                (content != null && content.indexOf("application/json") > -1))) {
            String page = "common/404";
            String message = "页面没有找到！";
            if (HttpStatus.INTERNAL_SERVER_ERROR.value() == code) {
                page = "common/error";
                message = "服务器内部发生错误！";
            }
            ModelAndView mv = new ModelAndView(page);
            mv.addObject("message", message);
            return mv;
        } else {
            response.setCharacterEncoding("UTF-8"); //设置编码格式
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);//设置ContentType，返回内容的MIME类型
            response.setHeader("Cache-Control", "no-cache");//告诉所有的缓存机制是否可以缓存及哪种类型
            String json = JsonRetrun.exceptionToString(1, "请求连接不存在");
            if (HttpStatus.INTERNAL_SERVER_ERROR.value() == code) {
                json = JsonRetrun.exceptionToString(1, "服务器内部发生错误！");
            }
            try {
                response.getWriter().write(json);
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
