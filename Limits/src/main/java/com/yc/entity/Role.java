package com.yc.entity;


import java.io.Serializable;
import java.util.List;

/**
 * Created by dello on 2016/7/27.
 */
public class Role  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3566166441693958855L;


    private int rid;
    private String rname;
    private String addtime;
    private String updatetime;
    
    private List<Function> functions;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", addtime=" + addtime
				+ ", updatetime=" + updatetime + "]";
	}
    
}