package Dao;

import java.util.ArrayList;


public class ResultObject<T> {
	private boolean success;
	private ArrayList<T> objArray;
	private T obj;
	private String message;
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<T> getObjArray() {
		return objArray;
	}
	public void setObjArray(ArrayList<T> objArray) {
		this.objArray = objArray;
	}
	public T getObj() {
		return obj;
	}
	public void setObj(T obj) {
		this.obj = obj;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	

}
