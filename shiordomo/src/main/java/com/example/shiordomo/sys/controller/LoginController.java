package com.example.shiordomo.sys.controller;


import com.example.shiordomo.sys.domain.Loginfo;
import com.example.shiordomo.sys.service.LoginfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shiordomo.sys.common.ActiverUser;
import com.example.shiordomo.sys.common.ResultObj;
import com.example.shiordomo.sys.common.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginfoService loginfoService;
	@RequestMapping("login")
	public ResultObj login(String loginname,String pwd,String captcha) {
		//获取当前对象
		Subject subject = SecurityUtils.getSubject();
		String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute(CaptchaController.KEY_CAPTCHA);
		System.out.println(sessionCaptcha);
		captcha = WebUtils.getRequest().getParameter("captchaCode");
		System.out.println(captcha);
		if ( null == captcha || !captcha.equalsIgnoreCase(sessionCaptcha) ) {
			System.out.println("验证码错误");
			return ResultObj.LOGIN_ERROR_CODE;
		} else {

			System.out.println("验证码正确");
			//令牌存放账号密码
			AuthenticationToken token = new UsernamePasswordToken(loginname, pwd);
			try {
				subject.login(token);
				ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
				//将对象账号密码存放到session中

				WebUtils.getSession().setAttribute("user", activerUser.getUser());

				//记录登录日志 使用localhost显示为0:0:0:0:0:0:0:1,使用127.0.0.1则为正常
				Loginfo lf = new Loginfo();
				lf.setLoginname(activerUser.getUser().getName() + "-" + activerUser.getUser().getLoginname());
				lf.setLoginip(WebUtils.getRequest().getRemoteAddr());
				lf.setLogintime(new Date());
				loginfoService.save(lf);

				return ResultObj.LOGIN_SUCCESS;
			} catch (AuthenticationException e) {
				e.printStackTrace();
				return ResultObj.LOGIN_ERROR_PASS;
			}
		}
	}
}

