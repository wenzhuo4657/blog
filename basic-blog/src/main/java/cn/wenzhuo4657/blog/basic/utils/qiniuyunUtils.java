package cn.wenzhuo4657.blog.basic.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @className: qiniuyunUtils
 * @author: wenzhuo4657
 * @date: 2024/8/31 15:02
 * @Version: 1.0
 * @description:
 */
public class qiniuyunUtils {
    public static String upload(MultipartFile img, String path) {

        Configuration cfg = new Configuration(Region.autoRegion());

        UploadManager uploadManager = new UploadManager(cfg);

        String accessKey = "33hzmmqPOwSsWXDjOVPI_8Vxd8CIEYxIuX-4d-Xm";
        String secretKey = "1yX5LrMf15Y93IpVgB6gVF8tn2DUg1Qq2g7VO_zc";
        String bucket = "blog123412";
        String key = path;


        try {
            InputStream s = img.getInputStream();
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(s, key, upToken, null, null);
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return "blog.wenzhuo4657.cn/" + key;
            } catch (QiniuException ex) {
                ex.printStackTrace();
                if (ex.response != null) {
                    System.err.println(ex.response);
                    try {
                        String body = ex.response.toString();
                        System.err.println(body);
                    } catch (Exception ignored) {
                    }
                }
            }
        } catch (Exception ex) {
            //ignore
        }
        return "上传失败";
    }
}

