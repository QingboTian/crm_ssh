package tqb.customer.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tqb.customer.dao.CustomerDao;
import tqb.customer.entity.Customer;
import tqb.page.entity.PageBean;

@Transactional
public class CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customer> list() {
		return customerDao.findAll();
	}

	public void add(Customer customer) {
		customerDao.add(customer);
	}

	public void delete(int cid) {
		Customer customer = customerDao.findById(cid);
		if (customer != null) {
			customerDao.delete(customer);
		}
	}

	public void edit(Customer customer) {
		customerDao.update(customer);
	}

	public Customer toEditPage(int cid) {
		Customer customer = customerDao.findById(cid);
		return customer;
	}

	// 全部数据的分页方法
	public PageBean<Customer> paging(int currentPage) {
		// 封装PageBean
		PageBean<Customer> page = new PageBean<Customer>();
		// 当前页
		page.setCurrentPage(currentPage);
		// 每页大小
		int pageSize = 10;
		page.setPageSize(pageSize);
		// 总记录数
		int totalCount = customerDao.getTotalCount();
		page.setTotalCount(totalCount);
		// 总页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = (totalCount / pageSize) + 1;
		}
		page.setTotalPage(totalPage);
		// 开始位置
		int begin = (currentPage - 1) * pageSize;
		page.setBegin(begin);
		// 每页记录的list集合
		List<Customer> list = customerDao.getPageList(begin, pageSize);
		page.setList(list);
		return page;
	}

	public PageBean<Customer> query(int currentPage, String custName) {
		// 封装PageBean
		PageBean<Customer> page = new PageBean<Customer>();
		// 当前页
		page.setCurrentPage(currentPage);
		// 每页大小
		int pageSize = 10;
		page.setPageSize(pageSize);
		// 总记录数
		int totalCount = customerDao.getQueryCount(custName);
		page.setTotalCount(totalCount);
		// 总页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = (totalCount / pageSize) + 1;
		}
		page.setTotalPage(totalPage);
		// 开始位置
		int begin = (currentPage - 1) * pageSize;
		page.setBegin(begin);
		// 每页记录的list集合
		List<Customer> list = customerDao.getQueryList(begin, pageSize, custName);
		System.out.println(list);
		page.setList(list);
		return page;
	}

	public List<Customer> moreCondition(Customer customer) {
		return customerDao.moreCondition(customer);
	}

	public List customerLevelStatistics() {
		return customerDao.customerLevelStatistics();
	}

	public List customerSourceStatistics() {
		return customerDao.customerSourceStatistics();
	}

}
