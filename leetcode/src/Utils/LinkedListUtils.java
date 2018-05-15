package Utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import Type.ListNode;

public class LinkedListUtils<K> {
	Class<K> cls;

	public LinkedListUtils(Class<K> cls) {
		this.cls = cls;
	}

	/**
	*
	* sort a linked list
	* by: tjlcast
	*
	* */
	public ListNode sortLinkedList(ListNode data) {
		
		ListNode root = new ListNode(-1) ;
		while(data != null) {
			//	get an item from list
			ListNode cur = data ;
			data = data.next ;
			
			//	insert into current position 
			ListNode temp=root ;
			for(; temp.next!=null&&temp.next.val<cur.val; temp=temp.next) ; // find the position => temp
			cur.next = temp.next.next ;
			temp.next = cur ;
		}
		return root.next ;
	}



	/**
	*
	* print a linked list
	* by: tjlcast
	*
	* */
	public void printLinkedList(K root) {
		
		try {
			Method methodGetNext = cls.getMethod("getNext");
			while (root != null) {
				System.out.println(root.toString());
				root = ((K) methodGetNext.invoke(root)) ;
			}
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (InvocationTargetException e) {
			System.out.println(e);
		}
		
	}

	/**
	* tips: return the list without head node (begin with the first useful node )
	* how: ListNode listNode = new LinkedListUtils<ListNode>(ListNode.class).buildLinkedList(arr);
	* */
	public K buildLinkedList(int[] data) {

		Constructor<K> declaredConstructor;

		try {
			declaredConstructor = (Constructor<K>) cls.getDeclaredConstructor(Integer.class);
			Method methodSetNext = cls.getMethod("setNext", cls);
			Method methodGetNext = cls.getMethod("getNext");

			K root = declaredConstructor.newInstance(-1);
			K cur = root;
			for (Integer i : data) {
				K temp = declaredConstructor.newInstance(i);
				methodSetNext.invoke(cur, temp);
				cur = temp;
			}

			@SuppressWarnings("unchecked")
			K ans = (K) methodGetNext.invoke(root);

			// output
			System.out.println("generate an new list:");
			this.printLinkedList(ans);

			return ans;
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println(e);
		} catch (InstantiationException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} catch (InvocationTargetException e) {
			System.out.println(e);
		}
		return null;
	}
}
