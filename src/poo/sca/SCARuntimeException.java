package poo.sca;

public class SCARuntimeException extends RuntimeException{
	
	public SCARuntimeException(){
		super();
	}
	
	public SCARuntimeException(String msg){
		super(msg);
	}

	public SCARuntimeException(String msg, Throwable o) {
		super(msg,o);
	}

}
