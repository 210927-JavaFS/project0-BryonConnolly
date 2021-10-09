package com.bryonconnolly.revature.project0.models.animals;

import static java.lang.System.out;

public abstract class Animal {
	
		protected int i;
		
		public Animal(){
			/*private*/i++;//private would not be accessible in subclasses
			out.println("animal created");
		}

		public void make_a_sound(){
			out.println(this.toString()+" made " + "\"animal sound\"");

		}

		static {
			out.println("animal static block");
		}

}
