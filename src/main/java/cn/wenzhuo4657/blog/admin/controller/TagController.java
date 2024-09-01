package cn.wenzhuo4657.blog.admin.controller;

import cn.wenzhuo4657.blog.admin.Enum.Code;
import cn.wenzhuo4657.blog.admin.dao.TagMapper;
import cn.wenzhuo4657.blog.admin.domain.enity.Tag;
import cn.wenzhuo4657.blog.admin.domain.vo.EditTagDto;
import cn.wenzhuo4657.blog.admin.domain.vo.TagVo;
import cn.wenzhuo4657.blog.admin.service.TagService;
import cn.wenzhuo4657.blog.basic.annotation.PrintLog;
import cn.wenzhuo4657.blog.basic.domain.ResponseResult;
import cn.wenzhuo4657.blog.basic.utils.BeancopyUtils;
import cn.wenzhuo4657.blog.basic.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @className: TagController
 * @author: wenzhuo4657
 * @date: 2024/8/31 10:00
 * @Version: 1.0
 * @description:
 */
@RestController
@RequestMapping("/content/tag")
@Api("标签")
public class TagController {

    private TagMapper tagMapper;

    private TagService tagService;

    public TagController(TagMapper tagMapper, TagService tagService) {
        this.tagMapper = tagMapper;
        this.tagService = tagService;
    }



    @GetMapping("/list")
    @ApiOperation(value = "获取可用标签列表")
    @PrintLog
    public ResponseResult  getTagList(@RequestParam("pageNum") Integer pageNum,
                                    @RequestParam("pageSize") Integer pageSize,
                                    TagVo tagVo) {
        return  tagService.getlist(pageNum,pageSize,tagVo);
    }

    @PostMapping()
    @ApiOperation(value = "新增标签")
    @PrintLog
    public ResponseResult  InsertTag(@RequestBody TagVo tagVo) {
        return  tagService.insertTag(tagVo);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除标签")
    @PrintLog
    public ResponseResult  delTag( @PathVariable("id") Integer id) {
        tagMapper.deleteById(id);
        return  ResponseResult.okResult();
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "获取标签信息")
    @PrintLog
    public ResponseResult<EditTagDto>  getTag(@PathVariable("id") Integer id) {
        Tag tag = tagMapper.selectById(id);
        EditTagDto  dto = BeancopyUtils.copyBean(tag, EditTagDto.class);
        return  ResponseResult.okResult(dto);
    }

    @PutMapping()
    @ApiOperation(value = "修改标签信息")
    @PrintLog
    public ResponseResult<EditTagDto>  setTag(@RequestBody EditTagDto dto) {
        Tag tag = BeancopyUtils.copyBean(dto, Tag.class);
         tagMapper.updateById(tag);
        return  ResponseResult.okResult();
    }

    @GetMapping("/listAllTag")
    @ApiOperation(value = "获取所有可用标签列表")
    @PrintLog
    public ResponseResult<TagVo>  getTagList() {
        return  tagService.getAllTag();
    }




}