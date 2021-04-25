package com.example.demo1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
//模拟多线程文件下载
public class TestThread02 extends  Thread{
    private String url;
    private String filePath;

    @Override
    public void run() {
        DownloadUtil.download(url,filePath);
        System.out.println(filePath+"下载成功");
    }


    public static void main(String[] args) {
        TestThread02 thread02=new TestThread02("https://img-blog.csdnimg.cn/20200321123752653.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1dfTWVuZ19I,size_16,color_FFFFFF,t_70","1.png");
        TestThread02 thread03=new TestThread02("https://img-blog.csdnimg.cn/20200321123752653.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1dfTWVuZ19I,size_16,color_FFFFFF,t_70","2.png");
        TestThread02 thread04=new TestThread02("https://img-blog.csdnimg.cn/20200321123752653.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1dfTWVuZ19I,size_16,color_FFFFFF,t_70","3.png");
        thread02.start();
        thread03.start();
        thread04.start();
    }

}



class DownloadUtil{

    public static void download(String url,String filePath){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
