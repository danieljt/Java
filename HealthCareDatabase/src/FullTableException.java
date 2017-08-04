
public class FullTableException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	FullTableException(int size){
		super(String.format("Size: %d", size));
	}

}
