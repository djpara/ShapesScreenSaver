package main.se450.collections;

public class ShapeTuplet<T1, T2>
{
	private T1 t1;
	private T2 t2;

	public ShapeTuplet(T1 t1, T2 t2){
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public T1 getT1()
	{
		return t1;
	}
	
	public T2 getT2()
	{
		return t2;
	}
	
}
