package cn.wenzhuo4657.blog.basic.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVo {

    private  String token;
    private  UserInfoVo userInfo;
}
