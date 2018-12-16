package tqb.linkman.web.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import tqb.customer.entity.Customer;
import tqb.customer.service.CustomerService;
import tqb.linkman.entity.LinkMan;
import tqb.linkman.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	// 文件
	private File upload;
	// 文件名
	private String uploadFileName;
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public File getUpload() {
		return upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}

	// 模型驱动
	LinkMan linkman = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkman;
	}

	// 跳转到添加联系人页面
	public String toAddPage() throws Exception {
		// 将全部的客户名称保存到req域中
		List<Customer> customerList = customerService.list();
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		return "toAddPage";
	}
	
	// 添加联系人
	public String add() throws Exception {
		linkManService.add(linkman);
		if( upload!= null){
			/*String root = ServletActionContext.getRequest().getRealPath("/WEB-INF/files");*/
			File descFile = new File("E:\\img" + "\\" + uploadFileName);
			FileUtils.copyFile(upload, descFile);
		}
		return "add";
	}

	// 联系人列表
	public String list() throws Exception {
		List<LinkMan> list = linkManService.list();
		ServletActionContext.getRequest().setAttribute("linkmanList", list);
		return "list";
	}
	
	/*public String checkFileSize() throws Exception {
		String string = ServletActionContext.getRequest().getParameter("fileSize");
		System.out.println(string);
		return NONE;
	}*/
	
	// 删除联系人
	public String delete() throws Exception {
		linkManService.delete(linkman);
		return "delete";
	}
	
	// 跳转到修改联系人信息页面
	public String toEditPage() throws Exception {
		List<Customer> list = customerService.list();
		ServletActionContext.getRequest().setAttribute("customerList", list);
		LinkMan link = linkManService.findByLid(linkman.getLkm_id());
		ServletActionContext.getRequest().setAttribute("linkman", link);
		return "toEditPage";
	}
	
	// 编辑（修改）
	public String edit() throws Exception {
		linkManService.edit(linkman);
		return "edit";
	}
	
	public String toMoreCondition() throws Exception {
		// 得到customerList
		List<Customer> list = customerService.list();
		ServletActionContext.getRequest().setAttribute("customerList", list);
		return "toMoreCondition";
	}
	
	public String moreCondition() throws Exception {
		List<LinkMan> list = linkManService.moreCondition(linkman);
		ServletActionContext.getRequest().setAttribute("linkmanList", list);
		ServletActionContext.getRequest().setAttribute("linkman", linkman);
		List<Customer> customerList = customerService.list();
		ServletActionContext.getRequest().setAttribute("customerList", customerList);
		return "moreCondition";
	}
}
