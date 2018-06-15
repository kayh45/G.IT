package com.plani.cms.dto;
public class Paging {
    private int page=1; //현재 페이지
    private int totalCount; //전체 게시글수
    private int beginPage;    //출력 시작
    private int endPage;    //출력 끝
    private int displayRow = 10;    //한 페이지에 몇 개 row
    private int displayPage = 10;    //한 페이지에 몇 개 페이지
    boolean prev; //prev 버튼이 보일지/안 보일지
    boolean next; //총 페이지 수가 10개 넘는 경우만 true
    
    public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
        //이걸 꼭 호출해야 paging이 가능하기 때문에
        //이걸 호출하면 자동으로 paging() 함수 호출하도록 설정
        this.totalCount = totalCount;
        paging();
    }
    private void paging(){
        //displayPage = 10(고정값)
        //prev,next,beginPage,endPage 를 계산해서 만든다.
        endPage = ((page+(displayPage-1))/displayPage)*displayPage;
        beginPage = endPage - (displayPage-1);
        
        //글이 32개라면 필요한 페이지는 4개
        //32/10 = 3.2 올림해서 4
        int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
        if(totalPage<endPage){
            endPage = totalPage;
            next=false;
        }else{
            next=true;
        }
        prev=(beginPage == 1)?false:true;
    }
}