package cn.wenzhuo4657.blog.basic.Enum;

public interface HttpEnum {

    ;
    String  traceId="traceId";

    String redis_user="userID:  ";

  /**
     *  des: 文章状态码（0已发布，1草稿）
     * */
    int articleStatusP =0;
    int articleStatusH =1;


      /**
         *  des: 文章分裂状态码（0可用，1禁用）
         * */
    int categoryStatusP =0;
    int categoryStatusH =1;

      /**
         *  des: redis中文章浏览量key前缀
         * */
    String article_viewCount ="article_viewCount";

      /**
         *  des: 评论列表类型（0表文章，1表友链）
       *  且注意，友链的article被置为1
         * */
    int comment_Article =0 ;
    int comment_LiNK =1 ;
}
