package com.lazyc.vuehr.mapper;

import com.lazyc.vuehr.pojo.Hr;
import com.lazyc.vuehr.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HrMapper {
    public Hr loadUserByUsername(String s);

    public List<Role> getHrRolesById(Long id);
}
