package com.rain.server;

import javax.xml.ws.Endpoint;

import com.rain.service.impl.FactoryServiceImpl;

/**
 * EndPoint 发布Web Service
 * */
public class SoapServer {
	public static void main(String[] args) {
		// 发布服务
		// SEI 实现类对象 -- FactoryServiceImpl
		Endpoint.publish("http://127.0.0.1:8080/factoryService", new FactoryServiceImpl());
	}
}
