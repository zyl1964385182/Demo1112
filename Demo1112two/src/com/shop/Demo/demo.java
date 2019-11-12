package com.shop.Demo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        System.out.println(".............................");
    }

    @Test
    public void fun(){
        Scanner input=new Scanner(System.in);
        //先得到一个权限管理器工厂类
        IniSecurityManagerFactory ini = new IniSecurityManagerFactory("classpath:shiro-first.ini");
        //通过工厂得到一个权限管理器实例
        SecurityManager instance = ini.getInstance();
        //将securityManager设置到当前运行环境中
        SecurityUtils.setSecurityManager(instance);
        //创建实体Subject
        Subject subject = SecurityUtils.getSubject();
        //模拟从客户端提交过来的用户的用户名和密码，封装认证信息
        UsernamePasswordToken token = new UsernamePasswordToken("mahuateng","234567");
        //认证提交
        subject.login(token);
        //判断是否认证通过
        boolean is = subject.isAuthenticated();
        System.out.println("是否通过认证："+is);
    }



    @Test
    public void fun2(){
        //Scanner input=new Scanner(System.in);
        //先得到一个权限管理器工厂类
        IniSecurityManagerFactory ini = new IniSecurityManagerFactory("classpath:shiro-first.ini");
        //通过工厂得到一个权限管理器实例
        SecurityManager instance = ini.getInstance();
        //将securityManager设置到当前运行环境中
        SecurityUtils.setSecurityManager(instance);
        //创建实体Subject
        Subject subject = SecurityUtils.getSubject();
        //模拟从客户端提交过来的用户的用户名和密码，封装认证信息
        UsernamePasswordToken token = new UsernamePasswordToken("mahuateng","234567");
        //认证提交
        subject.login(token);
        //判断是否认证通过
        boolean is = subject.isAuthenticated();
        System.out.println("是否通过认证："+is);
        //注销认证
        subject.logout();
        is=subject.isAuthenticated();
        System.out.println("是否通过认证："+is);
    }
}
