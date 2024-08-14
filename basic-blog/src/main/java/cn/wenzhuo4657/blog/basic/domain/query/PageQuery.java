package cn.wenzhuo4657.blog.basic.domain.query;

/**
 * @className: PageQuery
 * @author: wenzhuo4657
 * @date: 2024/8/13 13:34
 * @Version: 1.0
 * @description:
 */
public class PageQuery {

    private  int  offset=0;
    private  int nums=10;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }
}