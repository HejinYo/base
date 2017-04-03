package com.hejinyo.service.other;


import com.hejinyo.common.utils.PageParam;
import com.hejinyo.pojo.other.TableIp;

public interface ITableIpService {

	public int getRowCount();
	public PageParam getIpListByPage(PageParam pageParam);
	public String printIp(String number, String country, String isp);

    public int addTable_Ip(TableIp tableIp);
}
