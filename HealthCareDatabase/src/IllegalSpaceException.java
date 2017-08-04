
public class IllegalSpaceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	IllegalSpaceException(int index, int size) {
		super(String.format("Index: %d, Size: %d",
		index, size));
	}
}
