package com.rain.jvm;

import java.util.ArrayList;

public class HeapOutofMemory {
	public void testHeap(){
        ArrayList list = new ArrayList ();
		for(;;){
              list.add(new HeapOutofMemory());
          }
    }
	public static void main(String[] args) {   	       
		HeapOutofMemory  t  = new HeapOutofMemory ();
	    t.testHeap();   
	}
}
