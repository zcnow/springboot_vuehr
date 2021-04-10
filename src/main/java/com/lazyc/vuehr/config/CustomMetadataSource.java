package com.lazyc.vuehr.config;

import com.lazyc.vuehr.pojo.Menu;
import com.lazyc.vuehr.pojo.Role;
import com.lazyc.vuehr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/*这个类的作用，主要是根据用户传来的请求地址，分析出请求需要的角色*/
//URL Filter
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) {
        String requestUrl = ((FilterInvocation)o).getRequestUrl();
        List<Menu> allMenu = menuService.getAllMenusWithRole();
        for (Menu menu: allMenu) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)
            && menu.getRoles().size() > 0) {
                List<Role> roles = menu.getRoles();
                String[] str = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                   str[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        return  SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

}
