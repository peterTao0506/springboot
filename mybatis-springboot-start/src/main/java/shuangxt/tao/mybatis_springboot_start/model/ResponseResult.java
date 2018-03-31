package shuangxt.tao.mybatis_springboot_start.model;


/**
 * 
 * @author peter
 *
 */
public class ResponseResult {
	private String code;
	private String msg;
	private Object data;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public static ResponseResult failed(String code, String msg) {
		ResponseResult response = new ResponseResult();
		response.setCode(code);
		response.setMsg(msg);
		return response;
	}

	public static ResponseResult succeed(String code, String msg, Object data) {
		ResponseResult response = new ResponseResult();
		response.setCode(code);
		response.setMsg(msg);
		response.setData(data);
		return response;
	}
}

