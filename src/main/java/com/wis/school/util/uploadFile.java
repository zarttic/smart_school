/**
 * @Description
 * @author liyajun
 * @create 2022-09-27 18:49
 */

package com.wis.school.util;

import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 上传文件
 *
 * @author liyaj
 * @date 2022/09/27
 */
public class uploadFile {
    /**
     * 最大限制为20M
     */
    private static final int MAX_SIZE = 20971520;
    /**
     * 限制文件上传的类型
     */
    private static final String[] suffixes = new String[]{".png", ".PNG", ".jpg", ".JPG", ".jpeg", ".JPEG", ".gif", ".GIF", ".bmp", ".BMP"};
    /**
     * 存储文件上传失败错误信息
     */
    private static Map<String,Object> error_result = new HashMap<>();

    /**
     * 头像上传
     */
    private static Map<String,Object> upload_result = new HashMap<>();

    /**
     * 上传照片
     *
     * @param photo 照片
     * @param path  路径
     * @return {@link Map}<{@link String},{@link Object}>
     */
    public static Map<String,Object> uploadPhoto(MultipartFile photo,String path){
        String originalName = photo.getOriginalFilename();
        File filePath = new File(path);
        //文件路径不存在 就新建一个
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        /*
          文件过大
         */
        if (photo.getSize() > MAX_SIZE){
            error_result.put("success",false);
            error_result.put("msg", "上传的图片大小不能超过20M");
            return error_result;
        }
        /*
          限制上传文件的类型
         */
        SuffixFileFilter suffixFileFilter = new SuffixFileFilter(suffixes);
        if (!suffixFileFilter.accept(new File(path + originalName))){
            error_result.put("success",false);
            error_result.put("msg","文件类型上传错误");
            return error_result;
        }
        return null;

    }

    /**
     * 得到上传结果
     *
     * @param photo        照片
     * @param dirPath      dir路径
     * @param portraitPath 照片路径
     * @return {@link Map}<{@link String},{@link Object}>
     */
    public static Map<String,Object> getUploadResult(MultipartFile photo,String dirPath,String portraitPath){
        if (!photo.isEmpty() && photo.getSize() > 0){
            String originName = photo.getOriginalFilename();
            Map<String,Object> error_result = uploadFile.uploadPhoto(photo,dirPath);
            if (error_result != null) {
                return error_result;
            }
            String newPhotoName = UUID.randomUUID()+"__"+originName;
            try {
                photo.transferTo(new File(dirPath + newPhotoName));
                upload_result.put("success", true);
                upload_result.put("portraitPath", portraitPath + newPhotoName);
            }catch (IOException e){
                e.printStackTrace();
                upload_result.put("success", false);
                upload_result.put("msg", "服务器发生异常,上传失败.");
                return upload_result;
            }

        }
        else {
            upload_result.put("success", false);
            upload_result.put("msg", "未找到指定图片");
        }
        return upload_result;
    }

}
