package tqb.visit.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tqb.visit.dao.VisitDao;
import tqb.visit.entity.Visit;

@Transactional
public class VisitService {
	private VisitDao visitDao;
	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}
	
	public void add(Visit visit) {
		visitDao.add(visit);
	}

	public List<Visit> list() {
		return visitDao.findAll();
	}

	public Visit findByVid(int vid) {
		return visitDao.findByVid(vid);
	}

	public void edit(Visit visit) {
		visitDao.update(visit);
	}

	public void delete(int vid) {
		//  查找
		Visit visit = visitDao.findByVid(vid);
		visitDao.delete(visit);
	}
	
}	
