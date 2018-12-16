package tqb.visit.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import tqb.customer.entity.Customer;
import tqb.customer.service.CustomerService;
import tqb.user.entity.User;
import tqb.user.service.UserService;
import tqb.visit.entity.Visit;
import tqb.visit.service.VisitService;

public class VisitAction extends ActionSupport implements ModelDriven<Visit> {
	private VisitService visitService;
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}

	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 模型驱动
	Visit visit = new Visit();
	public Visit getModel() {
		return visit;
	}
	
	// 到添加页面
	public String toAddPage() throws Exception {
		List<Customer> list = customerService.list();
		ServletActionContext.getRequest().setAttribute("customerList", list);
		List<User> userlist = userService.list();
		ServletActionContext.getRequest().setAttribute("userList", userlist);
		// 得到当前系统时间
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ServletActionContext.getRequest().setAttribute("date",df.format(date));
		return "toAddPage";
	}
	
	// 添加记录
	public String add() throws Exception {
		visitService.add(visit);
		return "add";
	}
	
	// 列表
	public String list() throws Exception {
		List<Visit> list = visitService.list();
		ServletActionContext.getRequest().setAttribute("visitList", list);
		return "list";
	}
	
	// 到编辑页面
	public String toEditPage() throws Exception {
		List<Customer> customerList = customerService.list();
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		List<User> userList = userService.list();
		ServletActionContext.getRequest().setAttribute("userList", userList);
		int vid = Integer.parseInt(ServletActionContext.getRequest().getParameter("vid"));
		// 通过vid查找
		Visit visit = visitService.findByVid(vid);
		ServletActionContext.getRequest().setAttribute("visit", visit);
		return "toEditPage";
	}
	
	// 修改
	public String edit() throws Exception {
		visitService.edit(visit);
		return "edit";
	}
	
	// 删除
	public String delete() throws Exception {
		int vid = Integer.parseInt(ServletActionContext.getRequest().getParameter("vid"));
		visitService.delete(vid);
		return "delete";
	}
}
