package tqb.base;

import java.util.List;

public interface BaseDao<T> {
	
	// 添加
	public void add(T t);
	
	// 删除
	public void delete(T t);
	
	// 更新（修改）
	public void update(T t);
	
	// 查询所有
	public List<T> findAll();
	
	// 通过id查询
	public T findById(int id);
}
