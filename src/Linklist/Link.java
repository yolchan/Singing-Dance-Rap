package Linklist;

//链表的节点

public class Link {
	 	public Object data;   //自身存储的数据
	 	public Link next;		//下一个节点
	 	
	 	
	 	
	 	public  Link(Object data)
	 	{
	 		this.data=data;
	 	}
	 	
	 	
	 	public void displayLink(){
	 		System.out.print(this.data+"->");
	 	}
	
	
	
	
}
