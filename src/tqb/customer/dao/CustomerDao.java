package tqb.customer.dao;

import java.util.List;

import tqb.base.BaseDao;
import tqb.customer.entity.Customer;

public interface CustomerDao extends BaseDao<Customer> {

	/*List<Customer> findAll();

	void add(Customer customer);

	Customer findByCid(int cid);

	void delete(Customer customer);

	void update(Customer customer);*/

	int getTotalCount();

	List<Customer> getPageList(int begin, int pageSize);

	int getQueryCount(String custName);

	List<Customer> getQueryList(int begin, int pageSize, String custName);

	List<Customer> moreCondition(Customer customer);

	List customerLevelStatistics();

	List customerSourceStatistics();

}
