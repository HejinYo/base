package com.basetest.baseTest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CurrentTimeReadFileTest {
    private long lastTimeFileSize = 0;  //上次文件大小

    public void realtimeShowLog(File logFile) throws IOException{
        //指定文件可读可写
        final RandomAccessFile randomFile = new RandomAccessFile(logFile,"rw");
        //启动一个线程每10秒钟读取新增的日志信息
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleWithFixedDelay(new Runnable(){
            public void run() {
                try {
                    //获得变化部分的
                    randomFile.seek(lastTimeFileSize);
                    String tmp = "";
                    while( (tmp = randomFile.readLine())!= null) {
                        System.out.println(new String(tmp.getBytes("ISO8859-1")));
                    }
                    lastTimeFileSize = randomFile.length();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws Exception {
        CurrentTimeReadFileTest currentTimeReadFileTest = new CurrentTimeReadFileTest();
        final File tmpLogFile = new File("D:\\1.txt");
        currentTimeReadFileTest.realtimeShowLog(tmpLogFile);
    }

}
