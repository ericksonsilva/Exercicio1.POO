package poo.sca;

public class SCAException extends Exception{
	
	public SCAException(){
		super();
	}
	
	public SCAException(String msg){
		super(msg);
	}

	public SCAException(String msg, Throwable o) {
		super(msg,o);
	}

}
