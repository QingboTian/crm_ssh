package tqb.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class clazz2;
	
	public BaseDaoImpl() {
		// 调用运行时类
		Class clazz = this.getClass();	
		// 获得参数化类型
		ParameterizedType pType = (ParameterizedType) clazz.getGenericSuperclass();
		// 得到实际类型参数<T>中的T
		Type[] actualTypeArguments = pType.getActualTypeArguments();
		Class clazz2 = (Class) actualTypeArguments[0];
		this.clazz2 = clazz2;
	}

	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@SuppressWarnings("all")
	@Override
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from " + clazz2.getSimpleName());
	}

	@SuppressWarnings("all")
	@Override
	public T findById(int id) {
		return (T) this.getHibernateTemplate().get(clazz2, id);
	}
	
}
