package com.fang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.fang.model.InterfaceInfo;

public interface InterfaceInfoDao {

	@Select("select * from interfaceinfo")
	List<InterfaceInfo> queryAll();
}
