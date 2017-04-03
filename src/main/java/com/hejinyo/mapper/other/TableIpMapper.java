package com.hejinyo.mapper.other;

import com.hejinyo.mapper.BaseMapper;
import com.hejinyo.pojo.other.TableIp;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface TableIpMapper extends BaseMapper {

	public int getRowCount();

	public List<TableIp> selectByParams(Map<String, Object> params);

	public List<TableIp> fetchByParams(Map<String, Object> params);

	public int addTable_Ip(TableIp tableIp);

}
