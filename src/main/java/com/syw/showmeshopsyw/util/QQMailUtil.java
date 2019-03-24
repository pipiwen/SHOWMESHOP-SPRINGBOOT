package com.syw.showmeshopsyw.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class QQMailUtil {
    public static void QQmail(String subject,String name,String context)throws Exception{
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        /*
         * 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host /
         * mail.user / mail.from
         */
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.debug", "true");//遇到最多的坑就是下面这行，不加要报“A secure connection is requiered”错。
        props.put("mail.smtp.starttls.enable", "true");
        // 发件人的账号
        props.put("mail.user", "670314725@qq.com");
        // 访问SMTP服务时需要提供的密码
        props.put("mail.password", "aaxawnbzfnwvbcfb");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);
        // 设置收件人
        InternetAddress to = new InternetAddress("1109841198@qq.com");
        message.setRecipient(MimeMessage.RecipientType.TO, to);
        // 设置抄送，抄送和密送如果不写正确的地址也要报错。最好注释不用。
        //InternetAddress cc = new InternetAddress("");
        //message.setRecipient(RecipientType.CC, cc);
        //设置密送，其他的收件人不能看到密送的邮件地址
        //InternetAddress bcc = new InternetAddress("");
        //message.setRecipient(RecipientType.CC, bcc);
        // 设置邮件标题
        message.setSubject(subject);
        // 设置邮件的内容体
        message.setContent("name: "+name+"<br/>"+"  "+context, "text/html;charset=UTF-8");
        // 发送邮件
        Transport.send(message);
    }

}
