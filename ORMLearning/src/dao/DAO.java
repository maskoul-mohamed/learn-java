package dao;
import java.util.List;

public interface DAO<T> {
	T get(long id);
	List<T> getAll();
	int add(T t);
	void delete(T t);
	void update(T t, String[] params);
}
