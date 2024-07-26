package com.powernode.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/7/11 23:33
 * @description:
 */
@Controller
public class FirstController {
    @RequestMapping(value = "/fileup",method = RequestMethod.POST)
    public String toUp(@RequestParam("filename") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //获取的是请求参数的名字
        String name = multipartFile.getName();
        System.out.println(name);
        // 这个获取的才是真正的名字
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(originalFilename);

        //接下来就是看在javase当中的io功底了
        InputStream inputStream = multipartFile.getInputStream();
        BufferedInputStream bfinput=new BufferedInputStream(inputStream);

        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("upload");
        File file=new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        File toFile=new File(file.getAbsoluteFile()+"/"+ UUID.randomUUID().toString() +originalFilename.substring(originalFilename.lastIndexOf('.')));

        BufferedOutputStream bfout=new BufferedOutputStream(new FileOutputStream(toFile));
        byte[] bytes=new byte[1024*10];
        int len=0;
        while ((len=bfinput.read(bytes))!=-1){
            bfout.write(bytes,0,len);
        }
        bfinput.close();
        bfout.close();
        return "ok";
    }

}
