package Linklist;
//链表的构造
public class LinkList {

	//第一个链节点
	private Link first;
	
	//每当你新建一个链表，会将头节点赋值为null
	public LinkList(){
		this.first=null;
	}
	
	//判断链表是否为空
	public  boolean isEmpty(){
		return (this.first==null);
	}
	
	
	//插入一个数据
	public void insertFirst(Object data)
	{
		Link linkFirst=new Link(data);//新建一个节点
		linkFirst.next=this.first;//
		this.first=linkFirst;
	}
	
	
	//删除一个节点及其中数据
	public void deleteFirst(){
		this.first=this.first.next;//用下一个节点将当前节点覆盖
	}
	
	//遍历显示
	public void displayLinkList(){
		Link current=this.first;
		while(current!=null){
			current.displayLink();
			current=current.next;
		}
	}
	
}
