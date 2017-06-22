package com.rain.sftp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class ChannelPipe {
	private static String LOGIN_NAME = "root";
	private static String FTP_IP = "10.5.83.201";
	private static int FTP_PORT = 22;
	private static String PASSWORD = "Business123";
	public static void main(String[] args) throws JSchException {
	    ChannelSftp sftp = null;
	    JSch jsch = new JSch();
	    Session sshSession = jsch.getSession(LOGIN_NAME, FTP_IP, FTP_PORT);
	    sshSession.setPassword(PASSWORD);
	    sshSession.setConfig("StrictHostKeyChecking", "no");
	    sshSession.connect();
	    Channel channel = sshSession.openChannel("sftp");
	    channel.connect();
	    sftp = (ChannelSftp) channel;
	    try {
	    	String fileName = "20161108020201.dmp";
	    	String localPath = "D:/";
	    	// 改变路径
			sftp.cd("/home/bakup/data");
            // 下载文件
			sftp.get(fileName,localPath);
		} catch (SftpException e) {
			e.printStackTrace();
		}	    
	    
	    // 输入输出流存取文件     
	    /*
	    InputStream is = sftp.get("/home/bakup/data/20161108020201.dmp");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    
	    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("1.dmp"))));
	    String s = null;
	    while((s = reader.readLine()) != null){
	    	writer.write(s);
	    }
	    
	    reader.close();
	    writer.close();
	    */
	    
	    sshSession.disconnect();
	}
}
