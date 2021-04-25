package com.example.demo2;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//模拟多线程文件下载
public class TestCallable implements Callable<Boolean> {
    private String url;
    private String filePath;

    @Override
    public Boolean call()  {
        DownloadUtil.download(url,filePath);
        System.out.println(filePath+"下载成功");
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建目标对象
        TestCallable thread02=new TestCallable("https://img-blog.csdnimg.cn/20200321123752653.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1dfTWVuZ19I,size_16,color_FFFFFF,t_70","1.png");
        TestCallable thread03=new TestCallable("https://img-blog.csdnimg.cn/20200321123752653.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1dfTWVuZ19I,size_16,color_FFFFFF,t_70","2.png");
        TestCallable thread04=new TestCallable("https://img-blog.csdnimg.cn/20200321123752653.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1dfTWVuZ19I,size_16,color_FFFFFF,t_70","3.png");

        //创建执行服务
        ExecutorService executorService= Executors.newFixedThreadPool(3);


        //提交执行
        Future<Boolean> future1=executorService.submit(thread02);
        Future<Boolean> future2= executorService.submit(thread03);
        Future<Boolean> future3= executorService.submit(thread04);


        //获取执行结果
        boolean flag1=future1.get();
        boolean flag2= future2.get();
        boolean flag3= future3.get();
        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);

        //关闭服务
        executorService.shutdownNow();
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
