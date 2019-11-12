package com.shop.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class test {
    @Test
    public void fun(){
        Md5Hash hash=new Md5Hash("888","abc",3);
        System.out.println("md5加密后的内容："+hash);//a6b1420040aec1d208a25f893b0cde38
    }
}
