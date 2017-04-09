package com.hejinyo.other.service;


import com.hejinyo.core.common.utils.PageParam;
import com.hejinyo.other.domain.TableIp;

public interface ITableIpService {

	public int getRowCount();
	public PageParam getIpListByPage(PageParam pageParam);
	public String printIp(String number, String country, String isp);

    public int addTable_Ip(TableIp tableIp);
}
