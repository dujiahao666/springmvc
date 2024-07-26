package com.powernode.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

/**
 * @author 杜嘉豪
 * @version 1.0
 * @create 2024/5/30 9:27
 * @description:文件上传：浏览器端向服务器端发送文件，最终服务器将文件保存到服务器上。
 */
@Controller
public class FileController {
    @PostMapping("/fileup")
    public String fileup(@RequestParam("fileName") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //获取的是请求参数的名字
        String name = multipartFile.getName();
        //获取的是文件的真实名字
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(name);
        System.out.println(originalFilename);

        //接下里就是看在javase当中的功底了
        //一边读，一边写
        //读什么？写什么？
        //读客户端传过来的文件，写道服务器上
        //输入流
        InputStream inputStream = multipartFile.getInputStream();
        BufferedInputStream bis=new BufferedInputStream(inputStream);

        ServletContext application = request.getServletContext();
        String realPath = application.getRealPath("upload");
        File file=new File(realPath);
        if(!file.exists()){
            file.mkdirs();
        }
        //File destFile=new File(file.getAbsoluteFile()+"/"+originalFilename);
        File destFile=new File(file.getAbsoluteFile()+"/"+ UUID.randomUUID().toString() +originalFilename.substring(originalFilename.lastIndexOf('.')));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(destFile.getAbsoluteFile()));
        byte[] bytes=new byte[1024*10];
        int readCount=0;
        while ((readCount= bis.read(bytes))!=-1){
            bos.write(bytes,0,readCount);
        }
        bis.close();
        bos.close();

        return "ok";
    }



    @GetMapping("/download")
    public ResponseEntity<byte[]> downloadFile( HttpServletRequest request) throws IOException {
        File file = new File(request.getServletContext().getRealPath("/upload") + "/avatar.png");
        // 创建响应头对象
        HttpHeaders headers = new HttpHeaders();
        // 设置响应内容类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        // 设置下载文件的名称
        headers.setContentDispositionFormData("attachment", file.getName());
        // 下载文件
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(Files.readAllBytes(file.toPath()), headers, HttpStatus.OK);
        return entity;
    }

}
