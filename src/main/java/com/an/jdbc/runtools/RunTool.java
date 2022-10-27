package com.an.jdbc.runtools;


import com.an.jdbc.utils.Person;


public class RunTool {
	

	void print(Person pn) {
		if(pn.getPk()==0) {
			if(pn.getId()==null) {
				System.out.println("No Data...");
				System.out.println("-----------");
			}else {
				System.out.println("ID  :"+pn.getId());
				System.out.println("Pass:"+pn.getPass());
				System.out.println("-----------");
			}
		}else {
			System.out.println("Pk  :"+pn.getPk());
			System.out.println("ID  :"+pn.getId());
			System.out.println("Pass:"+pn.getPass());
			System.out.println("-----------");
		}
	}

}
