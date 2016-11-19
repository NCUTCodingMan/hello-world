package com.rain.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ServiceHandler implements InvocationHandler {
	private Object obj;
	public ServiceHandler(Object obj){
		this.obj = obj;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {	
		for(Object obj : args){
			System.out.println(obj.toString());
		}
		return method.invoke(obj, args);
	}
	public static void main(String[] args) throws Exception {
		ServiceImpl service = new ServiceImpl();
		Service proxy = (Service)Proxy.newProxyInstance(Service.class.getClassLoader(), new Class[]{Service.class}, new ServiceHandler(service));
		proxy.doSomething("hello world");
	}
}

interface Service{
	void doSomething(String s);
}

class ServiceImpl implements Service{
	public void doSomething(String s) {
		System.out.println("something happen..." + s);
	}
}