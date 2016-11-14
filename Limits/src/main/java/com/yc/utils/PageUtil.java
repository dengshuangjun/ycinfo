package com.yc.utils;

public class PageUtil {
	private int pageNo;
	private int pageSize;
	private int totalSize;
	private int totalPage;
	private int sta;
	
	
	
	@Override
	public String toString() {
		return "PageUtil [pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalSize=" + totalSize + ", totalPage=" + totalPage
				+ ", sta=" + sta + "]";
	}

	public int getPageNo() {
		return pageNo;
	}
	
	public int getSta() {
		return sta;
	}

	public void setSta(int sta) {
		this.sta = sta;
	}

	public void setPageNo(int pageNo) {
		if(pageNo<=0){
			this.pageNo=1;
		}else if(this.totalPage!=0&&pageNo>this.totalPage){
			this.pageNo=this.totalPage;
		}else{
			this.pageNo = pageNo;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize<=0){
			this.pageSize=5;
		}else{
			this.pageSize = pageSize;

		}
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		if(totalSize<0){
			this.totalSize=0;
		}else{
			this.totalSize = totalSize;

		}
	}

	public int getTotalPage() {
		totalPage=this.totalSize%this.pageSize==0?this.totalSize/this.pageSize:this.totalSize/this.pageSize+1;
		return totalPage;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pageNo;
		result = prime * result + pageSize;
		result = prime * result + totalPage;
		result = prime * result + totalSize;
		result = prime * result + sta;
		
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageUtil other = (PageUtil) obj;
		if (pageNo != other.pageNo)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (totalPage != other.totalPage)
			return false;
		if (totalSize != other.totalSize)
			return false;
		if (sta != other.sta)
			return false;
		return true;
	}
	
	
	
}
