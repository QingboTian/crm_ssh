package tqb.customer.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import tqb.customer.entity.Customer;
import tqb.customer.service.CustomerService;
import tqb.linkman.entity.LinkMan;
import tqb.page.entity.PageBean;

@SuppressWarnings("all")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private CustomerService customerService;
	Customer customer = new Customer();

	// 属性封装
	private LinkMan linkman;

	public LinkMan getLinkman() {
		return linkman;
	}

	public void setLinkman(LinkMan linkman) {
		this.linkman = linkman;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	// 跳转到添加客户页面
	public String toAddPage() throws Exception {
		return "toAddPage";
	}

	// 显示列表
	public String list() throws Exception {
		/* List<Customer> customerList = customerService.list(); */
		paging();
		/*
		 * ServletActionContext.getRequest().setAttribute("page", customerList);
		 */
		return "list";
	}

	// 添加客户
	public String add() throws Exception {
		customerService.add(customer);
		return "add";
	}

	// 删除客户
	public String delete() throws Exception {
		int cid = customer.getCid();
		customerService.delete(cid);
		return "delete";
	}

	// 到修改页面
	public String toEditPage() throws Exception {
		int cid = customer.getCid();
		Customer cust = customerService.toEditPage(cid);
		ServletActionContext.getRequest().setAttribute("customer", cust);
		return "toEditPage";
	}

	// 修改数据
	public String edit() throws Exception {
		customerService.edit(customer);
		return "edit";
	}

	// 分页
	public String paging() throws Exception {
		// 获取当前页面位置
		String cp = ServletActionContext.getRequest().getParameter("currentPage");
		int currentPage = Integer.parseInt(cp);
		// false 表示非条件查询得到的结果
		PageBean<Customer> page = customerService.paging(currentPage);
		ServletActionContext.getRequest().setAttribute("page", page);
		return NONE;
	}

	// 查询用户
	public String query() throws Exception {
		String custName = customer.getCustName();
		// 获取当前页面位置
		String cp = ServletActionContext.getRequest().getParameter("currentPage");
		int currentPage = Integer.parseInt(cp);
		// 表示条件查询
		boolean queryFlag = true;
		// 筛选框不为空
		if (custName != null && !"".equals(custName)) {
			PageBean page = customerService.query(currentPage, custName);
			ServletActionContext.getRequest().setAttribute("page", page);
			ServletActionContext.getRequest().setAttribute("custName", custName);
		} else {// 为空，直接调用list方法
			list();
		}
		return "query";
	}
	
	// 跳转到多条件查询页面
	public String toMoreCondition() throws Exception {
		return "toMoreCondition";
	}
	
	// 多条件查询
	public String moreCondition() throws Exception {
		List<Customer> customerList = customerService.moreCondition(customer);
		ServletActionContext.getRequest().setAttribute("customer", customer);
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		return "moreCondition";
	}
	
	// 客户级别统计
	public String customerLevelStatistics() throws Exception {
		List list = customerService.customerLevelStatistics();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "customerLevelStatistics";
	}
	
	public String customerSourceStatistics() throws Exception {
		List list = customerService.customerSourceStatistics();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "customerSourceStatistics";
	}
}
