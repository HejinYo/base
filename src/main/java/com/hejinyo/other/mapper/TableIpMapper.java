package com.hejinyo.other.mapper;

import com.hejinyo.core.mapper.BaseMapper;
import com.hejinyo.other.domain.TableIp;
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
