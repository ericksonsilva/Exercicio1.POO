package poo.sca.io;

public class SCAPersistenciaException extends Exception{
	
	public SCAPersistenciaException(){
		super();
	}
	
	public SCAPersistenciaException(String msg){
		super(msg);
	}

	public SCAPersistenciaException(String msg, Throwable o) {
		super(msg,o);
	}
		
}
