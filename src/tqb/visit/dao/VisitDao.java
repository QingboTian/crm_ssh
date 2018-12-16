package tqb.visit.dao;

import java.util.List;

import tqb.visit.entity.Visit;

public interface VisitDao {

	void add(Visit visit);

	List<Visit> findAll();

	Visit findByVid(int vid);

	void update(Visit visit);

	void delete(Visit visit);

}
