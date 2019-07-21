package Linklist;

public class text {

	
	
	public static void action(){
		LinkList linkList=new LinkList();
		linkList.insertFirst(1);
		linkList.insertFirst("two");
		linkList.insertFirst(3.14);
		linkList.insertFirst("hello");
		linkList.insertFirst("OK");
		
		System.out.println("第一次遍历");
		linkList.displayLinkList();
		
		System.out.println();
		System.out.println("删除两个node");
		linkList.deleteFirst();
		linkList.deleteFirst();
		
		System.out.println("第二次遍历");
		linkList.displayLinkList();
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		action();
	}
	
	
	

}
