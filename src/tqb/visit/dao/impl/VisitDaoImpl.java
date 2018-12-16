package tqb.visit.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import tqb.visit.dao.VisitDao;
import tqb.visit.entity.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VisitDao {

	@Override
	public void add(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	@SuppressWarnings("all")
	@Override
	public List<Visit> findAll() {
		List<Visit> list = (List<Visit>) this.getHibernateTemplate().find("from Visit");
		return list;
	}

	@Override
	public Visit findByVid(int vid) {
		@SuppressWarnings("unchecked")
		List<Visit> list = (List<Visit>) this.getHibernateTemplate().find("from Visit where vid=?", vid);
		return list.get(0);
	}

	@Override
	public void update(Visit visit) {
		this.getHibernateTemplate().update(visit);
	}

	@Override
	public void delete(Visit visit) {
		this.getHibernateTemplate().delete(visit);
	}
	
}
