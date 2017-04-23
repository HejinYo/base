package com.hejinyo.core.domain.pojo;

import lombok.Data;

/**
 * @author : HejinYo   hejinyo@gmail.com
 * @date : 2017/4/22 12:11
 * @Description : 功能表实体类
 */

@Data
public class SysFunction {
    private String resCode;//资源编码
    private String funcCode;//权限编码
    private String funcName;//功能名称
    private String funcUrl;//功能URL
}
