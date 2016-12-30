package com.taesu.fyl.mail;

import com.taesu.fyl.account.dto.AccountForInsert;
import com.taesu.fyl.encoder.UserIdEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by kim on 2016-12-29.
 */
@Service
public class MailService {
    @Value("${naver.mail.fromuser}") String username;

    @Autowired
    @Qualifier("google")
    private JavaMailSender g_mailSender;

    @Autowired
    @Qualifier("naver")
    private JavaMailSender n_mailSender;



    public void sendMailForAccountAuthenticationByNaver(AccountForInsert account, String callBack){

        MimeMessage mimeMessage = n_mailSender.createMimeMessage();
        try{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setSubject("[FYL]계정 인증 안내");

            String userIdEncode = account.getAuthToken();

            String htmlContent   = "<h3>회원가입 계정 인증 안내</h3>";
            htmlContent         += "<p>회원가입 절차를 진행하기 위해 아래 URL로 접속하여 인증이 필요하니다.</p>";
            htmlContent         += "<form method='POST' action='"+callBack+"/accounts/"+account.getUserId()+"/"+userIdEncode+"/authentication'>";
            htmlContent         += "<input type='hidden' name='_method' value='put' />";
            htmlContent         += "<button>링크로</button>";
            htmlContent         += "</form>";
            //htmlContent+= "<a href='"+callBack+"/accounts/"+account.getUserId()+"/"+userIdEncode+"/authentication'>test</a>";

            messageHelper.setText(htmlContent, true);
            messageHelper.setFrom(username);
            messageHelper.setTo(account.getUserEmail());

            n_mailSender.send(mimeMessage);
        } catch (Exception e){
            e.printStackTrace();
        }

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(username);                  //naver는 반드시 붙여줘야 함
//        message.setTo("dlxotn12345@naver.com");
//        message.setSubject("계정 인증 안내");
//        message.setText("인증이 필요");
//        n_mailSender.send(message);
    }

    public void sendMailForAccountAuthenticationByNGoogle(AccountForInsert account, String callBack){
        MimeMessage mimeMessage = g_mailSender.createMimeMessage();
        try{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setSubject("[FYL] 계정 인증 안내");

            String userIdEncode = account.getAuthToken();

            String htmlContent   = "<h3>회원가입 계정 인증 안내</h3>";
            htmlContent         += "<form method='POST' action='"+callBack+"/accounts/"+account.getUserId()+"/"+userIdEncode+"/authentication'>";
            htmlContent         += "<input type='hidden' name='_method' value='put' />";
            htmlContent         += "<button>링크로</button>";
            htmlContent         += "</form>";

            messageHelper.setText(htmlContent, true);
            messageHelper.setFrom(username);
            messageHelper.setTo(account.getUserEmail());

            n_mailSender.send(mimeMessage);
        } catch (Exception e){
            e.printStackTrace();
        }

//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("dlxotn12345@naver.com");
//        message.setSubject("계정 인증 안내");
//        message.setText("인증이 필요");
//        g_mailSender.send(message);
    }
}
