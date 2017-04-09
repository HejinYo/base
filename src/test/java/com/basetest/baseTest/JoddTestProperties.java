package com.basetest.baseTest;

import com.hejinyo.core.common.utils.Tools;
import jodd.props.Props;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class JoddTestProperties {
    private static Logger log = LogManager.getLogger(JoddTestDate.class.getName());
    @Test
    public void propExam() {
            /*
             *  读取prop文件中的属性值
             */
        Props p = Tools.getProps("D:/java/IDEA/base/src/main/resources/properties/application.properties");
        String story = p.getValue("db.driver");
        log.warn(story);
        log.warn(p.getValue("db.username"));
        p.setValue("db.xman", "cc");
        log.warn(p.getValue("db.xman"));
    }
}
