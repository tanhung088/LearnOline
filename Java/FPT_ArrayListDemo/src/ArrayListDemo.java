import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList	list = new ArrayList(); 
		
		// Dua cac phan tu vao mang
		list.add("Hung");
		list.add("Si");
		list.add("Quan");
		list.add("Thanh");
		
		//Xuat danh sach
		System.out.println(" " + list);
		
		// xuat ra kich thuoc cua mang list(ko dung voi length)
		System.out.println("Size = " + list.size());
		
		// xoa mang list
		/*
		list.clear();
		System.out.println("Sau khi dung ham clear:");
		System.out.println(" "+ list);*/
		
		//use the sort() method of the Collections class to sort an ArrayList.  
		// Luu y: trong mang phai cung KDL
		Collections.sort(list);
		System.out.println("After sort: " + list);
	}
}
