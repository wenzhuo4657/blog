package cn.wenzhuo4657.blog.admin.service.impl;

import cn.wenzhuo4657.blog.admin.Enum.Code;
import cn.wenzhuo4657.blog.admin.dao.RoleMapper;
import cn.wenzhuo4657.blog.admin.domain.enity.Role;
import cn.wenzhuo4657.blog.admin.domain.enity.Tag;
import cn.wenzhuo4657.blog.admin.domain.vo.PageVo;
import cn.wenzhuo4657.blog.admin.domain.vo.RoleVo;
import cn.wenzhuo4657.blog.admin.service.RoleService;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.domain.vo.pageVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 86147
* @description 针对表【sys_role(角色信息表)】的数据库操作Service实现
* @createDate 2024-08-29 15:11:10
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {
    private  RoleMapper roleMapper;

    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<String> getRoleById(Long id) {
        if (Code.Mysql_admin_id.equals(id)){
            List list=new ArrayList<>();
            list.add("admin");
            return  list;

        }
        return roleMapper.getRoleById(id);
    }

    @Override
    public pageVo getPageVo(Integer pageNum, Integer pageSize, RoleVo vo) {
        PageHelper.startPage(pageNum, pageSize);
        List<Role>  list=roleMapper.selectByRolevo(vo);
        PageInfo info=new PageInfo<>(list);
        pageVo volist=new pageVo(info.getList(),info.getTotal());
        return volist;
    }
}




