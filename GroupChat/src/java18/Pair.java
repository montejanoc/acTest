package java18;

public class Pair<Type0, Type1> {
	
	private Type0 value0;
	private Type1 value1;
	
	private Pair(Type0 obj1, Type1 obj2) {
		this.value0 = obj1;
		this.value1 = obj2;
	}

	public static <Type0, Type1> Pair with(Type0 obj0, Type1 obj1) {
		return new Pair<Type0, Type1>(obj0, obj1);
	}
	
	public Type0 getValue0() { return value0;}
	public Type1 getValue1() { return value1;}
	
	
}
