package generics;

public interface GList <T>{

	public void add(T o);
	public void insert(int index, T o);
	public T remove(int index);
	public T get(int index);
	public int size();
	
}
