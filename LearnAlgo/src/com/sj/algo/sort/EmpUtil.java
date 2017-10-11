package com.sj.algo.sort;

import java.util.Comparator;
import java.util.Random;

public class EmpUtil {

	public Emp[] emps;
	
	public void setEmps(Emp[] emps) {
		this.emps = emps;
	}
	public Emp[] getEmps() {
		return emps;
	}
	
	public static void main(String[] args) {
		EmpUtil eu = new EmpUtil();
		
		eu.setEmps(new Emp[50]);
		
		fillEmps(eu);
		
		System.out.println("Before sorting:");
		displayEmps(eu);
		
		sortEmps(eu, SortStrategy.QUICK);
		
		System.out.println("After sorting:");
		displayEmps(eu);
		
		
	}
	
	private static void fillEmps(EmpUtil eu) {
		Emp[] emps = eu.getEmps();
		Random r = new Random(1000);
		for(int i=0; i<emps.length; i++){
			emps[i] = new Emp(""+(i+1), r.nextInt(100));
		}
	}
	
	private static void displayEmps(EmpUtil eu) {
		Emp[] emps = eu.getEmps();
		for(int i=0; i<emps.length; i++){
			System.out.println(emps[i]);
		}
	}
	
	private static void sortEmps(EmpUtil eu, SortStrategy strategy) {
		Comparator<Emp> comp = new Comparator<Emp>() {

			@Override
			public int compare(Emp o1, Emp o2) {
				if(o1==o2)
					return 0;
				
				if(o1==null || o2==null)
					throw new IllegalArgumentException("Exception for "+o1+", "+o2);
				
				if(o1.salary== o2.salary)
					return 0;//return o1.name.compareTo(o2.name);
				
				return o1.salary>o2.salary?1:-1;
			}
		};
		
		Sort<Emp> sortImpl = SortFactory.getSortImpl(strategy, eu.getEmps(), comp);
		sortImpl.sort();
	}
	
}
