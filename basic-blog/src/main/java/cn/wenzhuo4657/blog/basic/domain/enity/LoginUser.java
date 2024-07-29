package cn.wenzhuo4657.blog.basic.domain.enity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className: LoginUser
 * @author: wenzhuo4657
 * @date: 2024/6/16 13:57
 * @Version: 1.0
 * @description:
 */

@Data
public class LoginUser implements UserDetails {
    private UserH user;
    private List<String> permissions;

    public LoginUser() {
    }

    public LoginUser(UserH user, List<String> permissions) {
        this.user = user;
        this.permissions = permissions;
    }

    @JSONField(serialize = false)
    private List<SimpleGrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(authorities!=null){
            return authorities;
        }
        authorities = permissions.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }
      /**
         *  des:
       *  指示用户的帐户是否已过期。过期的帐户无法进行身份验证。
       * 返回值:
       * 如果用户的帐户有效（即未过期）， true ；如果不再有效（即已过期）， false
         * */

      private Boolean isAccountNonExpired=true;
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
  /**
     *  des:
   *  指示用户是否被锁定或解锁。锁定的用户无法进行身份验证。
   * 返回值:
   * 如果用户未被锁定则true ，否则false
     * */
  private Boolean  isAccountNonLocked=true;
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

      /**
         *  des:
       *  指示用户的凭证（密码）是否已过期。过期的凭证会阻止身份验证。
       * 返回值:
       * 如果用户的凭证有效（即未过期），则为true ；如果不再有效（即已过期）， false
         * */
      private  Boolean isCredentialsNonExpired=true;
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }
  /**
     *  des:
   *  指示用户是已启用还是已禁用。已禁用的用户无法通过身份验证。
   * 返回值:
   * 如果用户已启用， true ，否则false
     * */
  private  Boolean isEnabled=true;
    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}