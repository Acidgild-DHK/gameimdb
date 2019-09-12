package dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IDao<T> {
	
	Optional<T> get(String id);
	Collection<T> getAll();
	Collection<T> getAll(List<DaoUtil.DaoMap> hm, boolean and, int likeGtLt);
	String save(T t);
	void update(T t);
	void delete(T t);
}
