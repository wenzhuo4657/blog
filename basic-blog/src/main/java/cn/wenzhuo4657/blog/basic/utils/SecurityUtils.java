package cn.wenzhuo4657.blog.basic.utils;

import cn.wenzhuo4657.blog.basic.domain.enity.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @className: SecurityUtils
 * @author: wenzhuo4657
 * @date: 2024/8/15 14:44
 * @Version: 1.0
 * @description:
 */
public class SecurityUtils {

      /**
         *  des: 指定用户id为1为管理员
         * */

    public  static  boolean isAdmin(){
        return  getUserId()==1?true:false;
    }



    public  static Long getUserId(){
        return  getLoginUser().getUser().getId();
    }

    public static LoginUser getLoginUser() {
        return  (LoginUser)getAuthentication().getPrincipal();
    }

    public  static Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

}