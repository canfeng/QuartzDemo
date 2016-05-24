package com.fang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fang.dao.InterfaceInfoDao;
import com.fang.model.InterfaceInfo;

@Service
public class InterfaceInfoService {

	@Autowired
	private InterfaceInfoDao interfaceInfoDao;
	
	public List<InterfaceInfo> queryAll(){
		return interfaceInfoDao.queryAll();
	}
	
}
