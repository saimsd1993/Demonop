package com.commerce.qa.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.bson.Document;
public class MongoDBTestListener implements ITestListener{

	MongoCollection<Document>webCollection;
	MongoClient mongoClient;
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		String classname=result.getMethod().getRealClass().getName();
		
		Document d1=new Document();
		d1.append("methodname", methodname);
		d1.append("classname", classname);
		d1.append("status", "PASS");
		List<Document> docsList = new ArrayList<Document>();
        docsList.add(d1);
		webCollection.insertMany(docsList);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		String classname=result.getMethod().getRealClass().getName();
		
		Document d1=new Document();
		d1.append("methodname", methodname);
		d1.append("classname", classname);
		d1.append("status", "FAIL");
		List<Document> docsList = new ArrayList<Document>();
        docsList.add(d1);
		webCollection.insertMany(docsList);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
      Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = mongoClient.getDatabase("newautoDB");
		// create collection and insert documents:
		webCollection = database.getCollection("live");
		
	}

	//@Override
	//public void onFinish(ITestContext context) {
		//mongoClient.close();
		
	//}
 
	
	
	
}
