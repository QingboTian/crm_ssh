package tqb.linkman.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tqb.customer.dao.CustomerDao;
import tqb.customer.entity.Customer;
import tqb.linkman.dao.LinkManDao;
import tqb.linkman.entity.LinkMan;

@Transactional
public class LinkManService {
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	
	//注入CustomerDao
	private CustomerDao customerDao;
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	public void add(LinkMan linkman) {
		linkManDao.add(linkman);
	}

	public List<LinkMan> list() {
		List<LinkMan> list = linkManDao.findAll();
		/*for (LinkMan linkMan : list) {
			Integer cid = linkMan.getCustomer().getCid();
			//通过cid查询客户
			Customer customer = customerDao.findByCid(cid);
			linkMan.setCustomer(customer);
		}*/
		return list;
	}

	public void delete(LinkMan linkman) {
		linkManDao.delete(linkman);
	}

	public LinkMan findByLid(Integer lkm_id) {
		LinkMan linkman = linkManDao.findByLid(lkm_id);
		/*Integer cid = linkman.getCustomer().getCid();
		Customer customer = customerDao.findByCid(cid);
		linkman.setCustomer(customer);*/
		return linkman;
	}

	public void edit(LinkMan linkman) {
		linkManDao.update(linkman);
	}

	public List<LinkMan> moreCondition(LinkMan linkman) {
		return linkManDao.moreCondition(linkman);
	}
	
}
