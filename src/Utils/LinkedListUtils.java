package Utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LinkedListUtils<K> {
	Class<K> cls;

	public LinkedListUtils(Class<K> cls) {
		this.cls = cls;
	}

	@SuppressWarnings("unchecked")
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
