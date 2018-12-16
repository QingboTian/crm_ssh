package tqb.linkman.dao;

import java.util.List;

import tqb.linkman.entity.LinkMan;

public interface LinkManDao {

	void add(LinkMan linkman);

	List<LinkMan> findAll();

	void delete(LinkMan linkman);

	LinkMan findByLid(Integer lkm_id);

	void update(LinkMan linkman);

	List<LinkMan> moreCondition(LinkMan linkman);

}
