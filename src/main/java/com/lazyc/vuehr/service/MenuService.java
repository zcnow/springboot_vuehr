package com.lazyc.vuehr.service;

import com.lazyc.vuehr.mapper.MenuMapper;
import com.lazyc.vuehr.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@CacheConfig(cacheNames="menus_cache")
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }
}
