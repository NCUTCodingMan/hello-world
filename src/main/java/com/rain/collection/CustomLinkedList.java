package com.rain.collection;

public class CustomLinkedList {
	private CustomLinkedList next;
	private int data;
	
	public static CustomLinkedList init(CustomLinkedList customLinkedLists,int[] array){
		int length = array.length;
		CustomLinkedList p = customLinkedLists;
		for(int i = 0;i < length;i ++){
			CustomLinkedList customLinkedList = new CustomLinkedList();
			customLinkedList.data = array[i];
			p.next = customLinkedList;
			p = p.next;
		}
		return customLinkedLists;
	}
	
	public static CustomLinkedList init(int[] array){
		int length = array.length;
		CustomLinkedList header = new CustomLinkedList();
		CustomLinkedList p = header;
		for(int i = 0;i < length;i ++){
			CustomLinkedList customLinkedList = new CustomLinkedList();
			customLinkedList.data = array[i];
			p.next = customLinkedList;
			p = p.next;
		}
		return header;
	}
	
	public static void main(String[] args) {
		CustomLinkedList customLinkedLists = new CustomLinkedList();
		customLinkedLists = CustomLinkedList.init(customLinkedLists, new int[]{1,2,3,4,5,6,7,8,9,10});
		while(customLinkedLists.next != null){
			System.out.print(customLinkedLists.data + "\t");
			customLinkedLists = customLinkedLists.next;
		}
		
		System.out.println("\n");
		
		CustomLinkedList header = CustomLinkedList.init(new int[]{10,11,12,13,14,15,16,17,18,19,20});
		while(header.next != null){
			System.out.print(header.data + "\t");
			header = header.next;
		}
	}
}
