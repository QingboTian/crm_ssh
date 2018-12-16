package tqb.linkman.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import tqb.linkman.dao.LinkManDao;
import tqb.linkman.entity.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao {

	@Override
	public void add(LinkMan linkman) {
		this.getHibernateTemplate().save(linkman);
	}

	@SuppressWarnings("all")
	@Override
	public List<LinkMan> findAll() {
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
		return list;
	}

	@Override
	public void delete(LinkMan linkman) {
		this.getHibernateTemplate().delete(linkman);
	}

	@SuppressWarnings("all")
	@Override
	public LinkMan findByLid(Integer lkm_id) {
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan where lkm_id=?", lkm_id);
		return list.get(0);
	}

	@Override
	public void update(LinkMan linkman) {
		this.getHibernateTemplate().update(linkman);
	}

	@Override
	public List<LinkMan> moreCondition(LinkMan linkman) {
		// 创建离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		// 判断(不为null且不为空字符串)
		if (linkman.getLkm_name() != null && !linkman.getLkm_name().trim().equals("")){
			criteria.add(Restrictions.like("lkm_name", "%" + linkman.getLkm_name() + "%"));
		}
		if (linkman.getLkm_gender() != null && !linkman.getLkm_gender().trim().equals("")){
			criteria.add(Restrictions.eq("lkm_gender", linkman.getLkm_gender()));
		}
		if (linkman.getCustomer().getCid() != null && !linkman.getCustomer().getCid().toString().trim().equals("")){
			criteria.add(Restrictions.eq("customer.cid", linkman.getCustomer().getCid()));
		}
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	
}
