package com.rain.init;

public class ClassLoaderDemo {
	public static void main(String[] args) throws Exception {
//		ClassLoaderDemo cl = new ClassLoaderDemo();
//		cl.getClass().getClassLoader().loadClass("com.rain.init.Crumble");
		MyClassLoader mcl = new MyClassLoader();
		mcl.loadClass("com.rain.init.Crumble");
		System.out.println(Crumble.class.getClassLoader() instanceof MyClassLoader);
	}
}

class Crumble{
	static{
		System.out.println("Crumble has been inited");
	}
}

class MyClassLoader extends ClassLoader{
	
}
