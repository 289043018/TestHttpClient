package com.hand.TestHttpClient;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Testpost {
	public static void main(String[] args) {
		new Post().start();
	}
}
class Post extends Thread{
	
	HttpClient client = HttpClients.createDefault();
	
	@Override
	public void run() {
		HttpPost post = new HttpPost("http://fanyi.youdao.com/openapi.do");
		try {
			
			//keyfrom=httpget-test&key=1709900495&type=data&doctype=<doctype>&version=1.1&q=要翻译的文本
			
			
			java.util.List<BasicNameValuePair> parameters = new ArrayList<>();
			parameters.add(new BasicNameValuePair("keyfrom", "httpget-test"));
			parameters.add(new BasicNameValuePair("key", "1709900495"));
			parameters.add(new BasicNameValuePair("type", "data"));
			parameters.add(new BasicNameValuePair("doctype", "xml"));
			parameters.add(new BasicNameValuePair("version", "1.1"));
			parameters.add(new BasicNameValuePair("q", "welcome"));
			
			
			
			post.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8") );
			HttpResponse response =  client.execute(post);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, "UTF-8");
			
			System.out.println(result);
			
			
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}