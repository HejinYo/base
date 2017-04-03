package com.hejinyo.mapper.other;

import com.hejinyo.mapper.BaseMapper;
import com.hejinyo.pojo.other.Jzt_Gps;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jzt_GpsMapper")
public interface Jzt_GpsMapper extends BaseMapper {
    //查询列表
    List<Jzt_Gps> getJzt_GpsList();

    //增加数据
    int addJzt_Gps(Jzt_Gps jzt_gps);

    //删除数据
    int delJzt_Gps(Jzt_Gps jzt_gps);

}
