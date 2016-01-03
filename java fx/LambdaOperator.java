/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationstart;

/**
 *
 * @author phempel
 */
public class LambdaOperator {

    //LambdaOperator operator = new LambdaOperator();
    //operator.operate(operand1, operand2, operation));
    //add sub mul div
		
      //with type declaration
      MathOperation add = ( a, b) -> a + b;
		
      //with out type declaration
      MathOperation sub = (a, b) -> a - b;
		
      //with return statement along with curly braces
      MathOperation mul = (a, b) -> { return a * b; };
		
      //without return statement and without curly braces
      MathOperation div = (a, b) -> a / b;
	
   interface MathOperation {
      double operation(double a, double b);
   }

   double operate(double a, double b, MathOperation mathOperation){
      return mathOperation.operation(a, b);
   }
}