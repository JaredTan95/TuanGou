package spittr.utils;

public class PageQueryParam {
    private int pageNumber = 1;
	private int pageSize = 6;
	//开始检索的地方
	private int indexNum;
	//总的页数
	private int pageCount ;	
	public int getIndexNum() {
		this.indexNum =(this.pageNumber-1)*this.pageSize;
		return indexNum;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}