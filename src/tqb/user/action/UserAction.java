package tqb.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import tqb.user.entity.User;
import tqb.user.service.UserService;

@SuppressWarnings("all")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	User userform = new User();

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		return userform;
	}
	
	/*
	 * 登录方法
	 */
	public String login() throws Exception {
		System.out.println(userform);
		User user = userService.login(userform);
		if(user != null){
			//将用户保存到session域中
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user);
			//返回成功值
			return "loginSuccess";
		}else{
			//保存错误信息
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("msg", "用户名或密码错误，请重新输入！");
			//保存表单user
			request.setAttribute("user", userform);
			return "loginFalse";	
		}
	}
	
}
