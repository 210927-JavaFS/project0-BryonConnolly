package com.bryonconnolly.revature.project0.models.animals;

import static java.lang.System.out;

public class Gnu extends Animal {

	public Gnu(){// would be implicitly called (added by the compiler) even if not written
		super();// would be implicitly called (added by the compiler) even if not written
		out.println("gnu created");
	}

	@Override
	public String toString(){
		return "A gnu";
	}

	@Override
	public void make_a_sound(){
		out.println(this.toString()+" made " + "\"a new sound\"");

	}

/**************************************INCOMPLETE******************
	@Override
	boolean equals(Object other) {

	}
**************************************************************/
}//Gnu