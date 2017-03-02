package java18;

public class Optional<Type> {

	private Type obj;
	
	private Optional(Type obj) {
		this.obj = obj;
	}
	
	public static <Type> Optional<Type> of(Type notNull) {
		if (notNull == null) {
			throw new RuntimeException("Tried to enter a null value into an Optional without using \"ofNullable\"");
		}
		
		return new Optional<Type>(notNull);
	}
	
	public static <Type> Optional<Type> ofNullable(Type possibleNull) {
		return new Optional<Type>(possibleNull);
	}
	
	public boolean isPresent() {
		return obj != null;
	}
	
	public Type get() {
		return obj;
	}
	
//	public static void main(String[] args)  {
//		System.out.println("Testing my Optional");
//		
//		Integer notNull = 1;
//		Integer defNull = null;
//		
//		Optional<Integer> optInt = Optional.of(notNull);
//		
//		if (optInt.isPresent()) {
//			System.out.println("NotNull is present. Hazzzaaaa");
//		}
//		
//		optInt = Optional.ofNullable(defNull);
//		if ( ! optInt.isPresent()) {
//			System.out.println("DefNull is not present. Winning");
//		}
//		
//		optInt = Optional.of(defNull);
//	}
}
