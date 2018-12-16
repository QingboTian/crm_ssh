package tqb.visit.entity;

import tqb.customer.entity.Customer;
import tqb.user.entity.User;

public class Visit {
	private Integer vid;
	private String time; // 拜访时间
	private String content;// 拜访内容

	private User user;
	private Customer customer;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
