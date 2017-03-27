package by.vls.admin.dao;

public class DaoException extends Exception{
	public DaoException(String message, Throwable e){
		super(message);
		initCause(e);
	}
	public DaoException(String message){
		super(message);
	}
}
