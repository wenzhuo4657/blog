package cn.wenzhuo4657.blog.basic.domain.query;

import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import cn.wenzhuo4657.blog.basic.exception.SystemException;

/**
 * @className: ArticleQuery
 * @author: wenzhuo4657
 * @date: 2024/8/13 13:06
 * @Version: 1.0
 * @description:
 */
public class ArticleQuery extends  PageQuery{
    private Long viewCount;

    private String isComment;

    private Integer delFlag;




    public ArticleQuery(Long viewCount, String isComment, Integer delFlag) {
        this.viewCount=viewCount;
        this.isComment=isComment;
        this.delFlag=delFlag;
    }
    public  static ArticleQueryBuilder builder() {
        return  new ArticleQueryBuilder();
    }

    public  static class  ArticleQueryBuilder{
        public ArticleQueryBuilder() {
        }

        /**
          * 最低访问量
          */
         private Long viewCount=-1L;

         /**
          * 是否允许评论 1是，0否
          */
         private String isComment;

         /**
          * 删除标志（0代表未删除，1代表已删除）
          */
         private Integer delFlag;



         public  ArticleQueryBuilder isComment(int comment){
             this.isComment=String.valueOf(comment);
             return  this;
         }
         public ArticleQueryBuilder viewCount(Long viewCount){
             this.viewCount=viewCount;
             return  this;
         }
         public ArticleQueryBuilder delFlag(int delFlag){
             this.delFlag=delFlag;
             return  this;
         }

         public ArticleQuery build(){
             if (viewCount==-1L){
                 throw  new SystemException("缺少必要参数，viewCount");
             }
             return new ArticleQuery(viewCount,isComment,delFlag);
         }

    }


}