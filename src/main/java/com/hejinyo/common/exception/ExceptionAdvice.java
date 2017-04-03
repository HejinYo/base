package com.hejinyo.common.exception;

import com.hejinyo.common.utils.JsonRetrun;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class ExceptionAdvice {// ResponseEntityExceptionHandler
    private static Logger logger = LogManager.getLogger(ExceptionAdvice.class.getName());

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        return exceptionReturn(ex, request, "客户端请求的语法错误！");
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        return exceptionReturn(ex, request, "客户端请求中的方法被禁止！");
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object handleHttpMediaTypeNotSupportedException(Exception ex, HttpServletRequest request) {
        return exceptionReturn(ex, request, "服务器无法处理请求附带的媒体格式！");
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public Object e(Exception ex, HttpServletRequest request) {
        return exceptionReturn(ex, request, "系统内部发生错误！");
    }

    /**
     * 根据不同的请求特点 ， 返回视图 或者 json 错误提示
     *
     * @param ex
     * @param request
     * @param message
     * @return
     */
    private Object exceptionReturn(Exception ex, HttpServletRequest request, String message) {
        String accept = request.getHeader("accept");//指定客户端能够接收的内容类型
        String content = request.getHeader("content-type");//请求的与实体对应的MIME信息
        String getHeaderX = request.getHeader("X-Requested-With");//Jquery AJAX特有的一个参数
        if (accept != null && !(accept.indexOf("application/json") > -1 ||
                (getHeaderX != null && getHeaderX.indexOf("XMLHttpRequest") > -1) ||
                (content != null && content.indexOf("application/json") > -1))) {
            String page = "common/500";
            ModelAndView mv = new ModelAndView(page);
            mv.addObject("excode", 1);
            mv.addObject("message", message);
            return mv;
        } else {
            logger.debug(ex.toString(), ex);//日志记录，ModelAndView 不用设置。
            return JsonRetrun.exception(1, message);
        }
    }

    /**
     * 获取异常的详细情况String(包括异常类和位置等debug信息，可以存放到数据库)
     *
     * @param ex
     * @return
     */
    private String exceptionInfo(Exception ex) {
        PrintWriter pw = null;
        StringWriter sw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }
}
