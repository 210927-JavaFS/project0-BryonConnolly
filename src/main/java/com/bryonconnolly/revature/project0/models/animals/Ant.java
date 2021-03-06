package com.bryonconnolly.revature.project0.models.animals;

import static java.lang.System.out;

public class Ant extends Animal {

	public Ant() {// would be implicitly called (added by the compiler) even if not written
		super();// would be implicitly called (added by the compiler) even if not written
		i++;
	}

	@Override
	protected void finalize() {
		// called automatically by garbage collector or can be requested with
		// System.gc()
		out.println("Ant Finalized");
	}
}