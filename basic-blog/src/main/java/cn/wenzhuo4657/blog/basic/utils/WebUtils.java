package cn.wenzhuo4657.blog.basic.utils;

import cn.wenzhuo4657.blog.basic.Enum.AppHttpCodeEnum;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @className: WebUtils
 * @author: wenzhuo4657
 * @date: 2024/7/29 14:26
 * @Version: 1.0
 * @description:
 * 手动发送信息响应，
 * 通过HttpServletResponse（封装到java程序的响应对象）来发送信息，
 */
@Slf4j
public class WebUtils {

  /**
     *  des:  发送字符串信息给前端
     * */
    public  static void renderString(HttpServletResponse response,String str){
        try {
            response.setStatus(AppHttpCodeEnum.SUCCESS.getCode());
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

      /**
         *  des: 设置请求头，用于导出excel
         * */
    public static void setDownLoadHeader(String filename, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fname = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment; filename=" + fname);
    }
}