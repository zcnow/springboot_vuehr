package com.lazyc.vuehr.mapper;

import com.lazyc.vuehr.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    public List<Menu> getAllMenus();

    public List<Menu> getAllMenusWithRole();
}
