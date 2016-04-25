package com.lanyuan.mapper;

import java.util.List;

import com.lanyuan.entity.ResourceRepoFormMap;
import com.lanyuan.mapper.base.BaseMapper;


public interface ResourceRepoMapper extends BaseMapper{

	public List<ResourceRepoFormMap> findUserPage(ResourceRepoFormMap resourceRepoForMap);
	
}
