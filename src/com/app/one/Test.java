package com.app.one;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String args[]) throws ParseException {
	List<Double>data=new ArrayList<Double>();
	data.add(100.0);
	data.add(200.0);
	data.add(50.0);
	data.add(300.0);
	
	Double d1=data.get(0);
	for(int i=0;i<data.size();i++)
	{
		if(d1>data.get(i))
			d1=data.get(i);
	}
	System.out.println("Greater Number "+d1);
	

		
	}
}
