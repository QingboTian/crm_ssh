package tqb.customer.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.Transformers;

import tqb.base.BaseDaoImpl;
import tqb.customer.dao.CustomerDao;
import tqb.customer.entity.Customer;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	/*@SuppressWarnings("all")
	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		return customerList;
	}*/

	/*@Override
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}*/

	/*@SuppressWarnings("all")
	@Override
	public Customer findByCid(int cid) {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where cid=?", cid);
		return list.get(0);
	}*/

	/*@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}*/

	/*@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}*/

	@SuppressWarnings("all")
	@Override
	public int getTotalCount() {
		// 调用hibernateTemplate里面的find方法实现
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer");
		// 从list中把值得到
		if (list != null && list.size() != 0) {
			Object obj = list.get(0);
			// 变成int类型
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	@Override
	public List<Customer> getPageList(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	// 条件查询出的数据总数
	@SuppressWarnings("all")
	@Override
	public int getQueryCount(String custName) {
		List<Object> list = (List<Object>) this.getHibernateTemplate()
				.find("select count(*) from Customer where custName like ?", "%" + custName + "%");
		// 从list中把值得到
		if (list != null && list.size() != 0) {
			Object obj = list.get(0);
			// 变成int类型
			Long lobj = (Long) obj;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	// 条件查询出的数据
	@SuppressWarnings("all")
	@Override
	public List<Customer> getQueryList(int begin, int pageSize, String custName) {
		// 得到sessionFactory
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		// 得到session对象
		Session session = sessionFactory.getCurrentSession();
		// 设置分页信息
		Query query = session.createQuery("from Customer where custName like ?");
		query.setParameter(0, "%" + custName + "%");
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<Customer> list = query.list();
		return list;
	}

	@Override
	public List<Customer> moreCondition(Customer customer) {
		/*
		 * 第一种方式
		 */
		String hql = "from Customer where 1=1";
		List<String> list = new ArrayList<String>();
		// 判断传过来的数据是否为null或者是否为空字符串
		if (customer.getCustName() != null && !customer.getCustName().trim().equals("")){
			hql += " and custName=?";
			list.add(customer.getCustName());
		}
		if (customer.getCustLevel() != null && !customer.getCustLevel().trim().equals("")){
			hql += " and custLevel=?";
			list.add(customer.getCustLevel());
		}
		if (customer.getCustSource() != null && !customer.getCustSource().trim().equals("")){
			hql += " and custSource=?";
			list.add(customer.getCustSource());
		}
		List<Customer> list2 = (List<Customer>) this.getHibernateTemplate().find(hql, list.toArray());
		return list2;
	}

	@Override
	public List customerLevelStatistics() {
		// 使用普通sql语句进行查询
		String sql = "select count(*) num, custLevel from t_customer group by custLevel";
		SQLQuery query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = query.list();
		return list;
	}

	@Override
	public List customerSourceStatistics() {
		// 使用普通sql语句进行查询
		String sql = "select count(*) num, custSource from t_customer group by custSource";
		SQLQuery query = this.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		query.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = query.list();
		return list;
	}
}
