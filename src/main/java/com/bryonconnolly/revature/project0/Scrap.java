/**
 *  THIS FILE JUST FOR EXPERIMENTING AND LEARNING THE LANGUAGE AND TOOLS
 */
package com.bryonconnolly.revature.project0;
//    📦
//₧
//127 ⌂
//₧ Alt+ 158
//U+00A0	\u00A0	&#160;	&nbsp;	non-breaking space
//�?�
//!
//¤
//µ
//$
//☺
//😀  U+01F600  \ud83d\ude00
//📦 \ud83d\udce6     	U+1F4E6
/*
import static java.lang.System.err;
import static java.lang.System.out;
import static java.lang.System.in;
*/
import static java.lang.System.*;
import java.util.Scanner;
import java.awt.Toolkit;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;


//TODO Implement worthwhile parts of this scrap sheet


public class Scrap {


	static {
		System.out.println("in static block");
	}//end of static block



	public static void main2(String[] args) {

		byte number = -128;
		System.out.println(number);


		// About Block Scope:
		{
		  String variable_in_block;
		  variable_in_block = "Scope!";  /* No Problems Here */
		}
		//variable_in_block = "Scope!";  /* Will Not Compile */


		out.println("using static import");


		AnEmptyStatement: ; // any statement can have a label
		iteration: while(true){// usually on a loop or a switch
			break iteration;
		}// end iteration



		Animal[] animals = new Animal[7];
		animals[0] = new Ant();
		animals[1] = new Bee();
		animals[2] = new Cat();
		animals[3] = new Dog();
		animals[4] = new Elk();
		animals[5] = new Fly();
		animals[6] = new Gnu();
		for(Animal animal : animals){
			animal.make_a_sound();
		}

/*

		Ant ant;
		Bee bee;
		Cat cat;
		Dog dog;
		Elk elk;
		Fly fly;
		Gnu gnu;

*/


//================================================================================

		Gnu gnu = new Gnu();//NEW

//================================================================================





		out.println("LEARN UPCASTING AND DOWNCASTING");
		err.println("LEARN UPCASTING AND DOWNCASTING");


		Animal beast = gnu;



        	//ring the bell
        	java.awt.Toolkit.getDefaultToolkit().beep();

		//color enum tests
/*
        	System.out.print(Color.BLACK_BOLD);
        	System.out.println("Black_Bold");
        	System.out.print(Color.RESET);

        	System.out.print(Color.YELLOW);
        	System.out.print(Color.BLUE_BACKGROUND);
        	System.out.println("YELLOW & BLUE");
        	System.out.print(Color.RESET);

	       	System.out.print(Color.YELLOW);
        	System.out.print("YELLOW");
        	System.out.println(Color.RESET);

*/
		for(ANSI_Escape_Sequence c : ANSI_Escape_Sequence.values()) {
			out.print(c.code);
			out.println(c);//i.e. c.toString()
			out.print(ANSI_Escape_Sequence.RESET.code);
		}
		err.println("MAYBE JUST ADD A SET COLOR AND RESET METHOD TO ENUM");
		



/*********INCOMPLETE********************
		Scanner scanner = new Scanner(in);
		out.println("Pick a color:");
		String input = scanner.nextLine();

		switch(input) {
		  case "Cyan":
	
			break;
		  case "Magenta":
	
			break;
		  case "Yellow":
	
			break;
		  case "Black":

			break;
		  default:
			err.println("unrecognized process color");
		}
*********************************************/


		for(ANSI_Escape_Sequence c: ANSI_Escape_Sequence.values()){
			out.print(c.code+"_");
		}




		out.println();
		out.println(ANSI_Escape_Sequence.RESET.code);
		out.println();


		StringBuilder sb = new StringBuilder("Bryon Connolly");
		sb.append("!");
		sb.insert(5, " J.");
		out.println(sb);

		//arrays
		int[] int_array = new int[3];//array contains default values (0)
		int[] int_array_2 = {1,2,3};//array created with values


		//------------------------------------------------------------
		//------------------------------------------------------------
		//------------------------------------------------------------
		//Throwables: Exceptions and Errors (these are actual objects)
		//------------------------------------------------------------
		//--- Exceptions can be recovered from, Errors not so much ---
		//------------------------------------------------------------
		//
		//	Exceptions can be Checked or Unchecked (aka Runtime)
		//
		//	Checked Exceptions: these are anticipated as always possible and not something Java can prevent, like FileNotFound / IOException
		//		[Checked by the compiler to ensure they are handled (when they are thrown at runtime)]
		//
		//	Unchecked Exceptions (RuntimeExceptions):  these are not anticipated if the code is perfectly written.  
		//		They can be avoided if you take them into account 
		//		while designing the logic 
		//		so handling is not required, 
		//		therefore the compiler does not check for them
		//		examples include: NullPointer, ArrayIndexOutOfBounds
		//
		//------------------------------------------------------------



        	java.awt.Toolkit.getDefaultToolkit().beep();

		Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
		toolkit.beep();
        	out.println(toolkit.getScreenSize());
        	out.println(toolkit.getScreenResolution());





		// trying out java.awt.Robot
		Robot robot;
		try {
			robot = new Robot();
		} catch(AWTException e) {
			robot = null;
			err.println("Exception encountered creating new robot!");
			err.println(e);
		}
		out.println("robot.toString() --> " + robot.toString());
		robot.keyPress(KeyEvent.VK_H);
		robot.keyRelease(KeyEvent.VK_H);
		robot.keyPress(KeyEvent.VK_I);
		robot.keyRelease(KeyEvent.VK_I);
		int x = 1280;
		int y = 720;
		robot.mouseMove(x,y);
		out.println("this pixel is "+robot.getPixelColor(1280,720));





		try{
			throw new NewException("MESSAGE");

		} catch(NewException e){
			//out.println(e);
			e.printStackTrace();
		} finally {
			out.println("finally");
		}


//		throw new NewException(); [is checked] so must be caught or declared
//		throw new NewRuntimeException(); [is unchecked] and works fine
// THE SECOND LINE WORKS - ONLY COMMENTED SO PROGRAM CAN CONTINUE ON--------->


		//---------[Abstract Class]----------->


		Implementation implementation = new Implementation();
		implementation.doSomething();//defined in extended child of Abstract
		implementation.doSomethingElse();//defined in the ABStract parent class




	}//end main

}//end class Scrap


class Animal {

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


}// Animal class

class Ant extends Animal {
	
	public Ant() {
		i++;
	}
	
	@Override
	protected void finalize(){
		//called automatically by garbage collector or can be requested with System.gc()
		out.println("Ant Finalized");
	}
}
class Bee extends Animal {}
class Cat extends Animal {}
class Dog extends Animal {}
class Elk extends Animal {}
class Fly extends Animal {}
class Gnu extends Animal {

	public Gnu(){
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


enum ANSI_Escape_Sequence {

    //Color end string, color reset
    RESET("\033[0m"),

    // Regular Colors. Normal color, no bold, background color etc.
    BLACK("\033[0;30m"),    // BLACK
    RED("\033[0;31m"),      // RED
    GREEN("\033[0;32m"),    // GREEN
    YELLOW("\033[0;33m"),   // YELLOW
    BLUE("\033[0;34m"),     // BLUE
    MAGENTA("\033[0;35m"),  // MAGENTA
    CYAN("\033[0;36m"),     // CYAN
    WHITE("\033[0;37m"),    // WHITE

    // Bold
    BLACK_BOLD("\033[1;30m"),   // BLACK
    RED_BOLD("\033[1;31m"),     // RED
    GREEN_BOLD("\033[1;32m"),   // GREEN
    YELLOW_BOLD("\033[1;33m"),  // YELLOW
    BLUE_BOLD("\033[1;34m"),    // BLUE
    MAGENTA_BOLD("\033[1;35m"), // MAGENTA
    CYAN_BOLD("\033[1;36m"),    // CYAN
    WHITE_BOLD("\033[1;37m"),   // WHITE

    // Underline
    BLACK_UNDERLINED("\033[4;30m"),     // BLACK
    RED_UNDERLINED("\033[4;31m"),       // RED
    GREEN_UNDERLINED("\033[4;32m"),     // GREEN
    YELLOW_UNDERLINED("\033[4;33m"),    // YELLOW
    BLUE_UNDERLINED("\033[4;34m"),      // BLUE
    MAGENTA_UNDERLINED("\033[4;35m"),   // MAGENTA
    CYAN_UNDERLINED("\033[4;36m"),      // CYAN
    WHITE_UNDERLINED("\033[4;37m"),     // WHITE

    // Background
    BLACK_BACKGROUND("\033[40m"),   // BLACK
    RED_BACKGROUND("\033[41m"),     // RED
    GREEN_BACKGROUND("\033[42m"),   // GREEN
    YELLOW_BACKGROUND("\033[43m"),  // YELLOW
    BLUE_BACKGROUND("\033[44m"),    // BLUE
    MAGENTA_BACKGROUND("\033[45m"), // MAGENTA
    CYAN_BACKGROUND("\033[46m"),    // CYAN
    WHITE_BACKGROUND("\033[47m"),   // WHITE

    // High Intensity
    BLACK_BRIGHT("\033[0;90m"),     // BLACK
    RED_BRIGHT("\033[0;91m"),       // RED
    GREEN_BRIGHT("\033[0;92m"),     // GREEN
    YELLOW_BRIGHT("\033[0;93m"),    // YELLOW
    BLUE_BRIGHT("\033[0;94m"),      // BLUE
    MAGENTA_BRIGHT("\033[0;95m"),   // MAGENTA
    CYAN_BRIGHT("\033[0;96m"),      // CYAN
    WHITE_BRIGHT("\033[0;97m"),     // WHITE

    // Bold High Intensity
    BLACK_BOLD_BRIGHT("\033[1;90m"),    // BLACK
    RED_BOLD_BRIGHT("\033[1;91m"),      // RED
    GREEN_BOLD_BRIGHT("\033[1;92m"),    // GREEN
    YELLOW_BOLD_BRIGHT("\033[1;93m"),   // YELLOW
    BLUE_BOLD_BRIGHT("\033[1;94m"),     // BLUE
    MAGENTA_BOLD_BRIGHT("\033[1;95m"),  // MAGENTA
    CYAN_BOLD_BRIGHT("\033[1;96m"),     // CYAN
    WHITE_BOLD_BRIGHT("\033[1;97m"),    // WHITE

    // High Intensity backgrounds
    BLACK_BACKGROUND_BRIGHT("\033[0;100m"),     // BLACK
    RED_BACKGROUND_BRIGHT("\033[0;101m"),       // RED
    GREEN_BACKGROUND_BRIGHT("\033[0;102m"),     // GREEN
    YELLOW_BACKGROUND_BRIGHT("\033[0;103m"),    // YELLOW
    BLUE_BACKGROUND_BRIGHT("\033[0;104m"),      // BLUE
    MAGENTA_BACKGROUND_BRIGHT("\033[0;105m"),   // MAGENTA
    CYAN_BACKGROUND_BRIGHT("\033[0;106m"),      // CYAN
    WHITE_BACKGROUND_BRIGHT("\033[0;107m");     // WHITE

    final String code;

    ANSI_Escape_Sequence(String code) {
        this.code = code;
    }
/*
    @Override
    public String toString() {
        return code;
    }
*/
}




class NewException extends Throwable{//? or Exception???? IOException?

	NewException() {
		super();
	}

	NewException(String message){
		super(message);
	}
}

class NewRuntimeException extends RuntimeException{

	NewRuntimeException() {
		super();
	}

	NewRuntimeException(String message){
		super(message);
	}
}



abstract class Abstract{

	abstract void doSomething();

	void doSomethingElse(){
		out.println("This method is defined in the abstract class Abstract");
	}
}

class Implementation extends Abstract{
	public void doSomething(){
		out.println("This method is defined in the non-abstract class Implementation ");
	}

}






