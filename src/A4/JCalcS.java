// Dafne Culha - 260785524 - ECSE 202 Assignment 4

package A4;

import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

public class JCalcS extends ConsoleProgram {

	// A method to determine if the string is an operator or not.
	// Returns true if it is an operator, false if it is an operand.
	public boolean isOperator(String str) {
		if (str.equals("+") || str.equals("-")|| str.equals("/") || str.equals("*")|| str.equals("^") || str.equals("(") || str.equals(")"))
			return true;

		else return false;
	}

	// A method to build the precedence table.
	// Returns higher values of integers if the operators have higher precedences.
	public int getPrecedence (String str) {	
		if (str.equals("/") || str.equals("*")) return 3;
		else if (str.equals("+") || str.equals("-")) return 2;
		else return 1;
	}

	// A method to determine if the operator is left associative or not.
	// Returns true if the operator is left associative, false if not.

	public boolean isLeftAssociative (String str) {

		if (str.equals("+") || str.equals("-")|| str.equals("/") || str.equals("*")|| str.equals("(") || str.equals(")"))
			return true;

		else return false;
	}

	// Create a method to evaluate the postfix expression.
	public void EvaluatePostfix (Queue postfix_input) {

		// Construct a stack to store the results.
		Stack result = new Stack();

		int number_of_evaluations = 0; // to count the number of evaluations initialize a variable to 0 

		// Check if the input queue (postfix expression) is empty.
		while (!postfix_input.isEmpty()) {

			// if not empty, dequeue from the queue.
			String str = postfix_input.dequeue();

			//Check if the string is an operand or an operator.
			if (!isOperator(str)) {
				// If operand, add to result stack;	
				result.push(str);
			}

			else {
				// If operator, pop twice from the stack (as we are only working with binary operators)
				String str1 = result.pop(); //first pop

				String str2 = result.pop(); //second pop

				String Eval;

				// Evaluation will be equal to <2nd pop> <operator> <1st pop>
				Eval = "<" + str2+str+str1 + ">";
				number_of_evaluations++; //increase the variable number_of_evaluations by 1
				
				// Print the evaluation line.
				println("Eval" + number_of_evaluations +"= " + Eval);
				
				// Then change the variable Eval so it can be displayed as Evalnumber_of_evaluations in the next lines of evaluations
				Eval = ("Eval"+ number_of_evaluations);
				
				// Push the evaluation back to the stack
				result.push(Eval);
			} 
		}
	}

	public void run() {

		// Tell the user what the program does.
		println("Infix to Postfix Interpreter \n");

		// Prompt the user to enter a line of operators and operands. 
		// Use the code provided to break the line of string into tokens of operands and operators.

		while (true) {
			String str = readLine("Enter expression (blank line to exit): ");
			if (str.equals("")) break;
			StringTokenizer st = new StringTokenizer(str,"+-*/",true); 

			// Construct a queue (output_queue) to store the operands and operators.
			// And a stack (operator_stack) to store the operators before the condition to be added to the output queue comes.

			Queue output_queue = new Queue();
			Stack operator_stack = new Stack();

			while (st.hasMoreTokens()) {
				//println("-->"+st.nextToken());

				String token = st.nextToken();

				// Determine if the token is an operator or not. 
				if(isOperator(token)) {

					// Get the precedence of the token.
					int prec_token = getPrecedence(token);

					// Check if the stack is empty or not.
					if (operator_stack.top != null) {

						// If it is not empty,

						// Compare the precedence of the top operator currently on the stack and the precedence of the token.
						// While the top of the stack has higher precedence or has equal precedence and is left associative.
						while ((getPrecedence(operator_stack.top.data) > prec_token )|| ((prec_token == getPrecedence(operator_stack.top.data)) && (isLeftAssociative(operator_stack.top.data)))) {
							// then pop operators off stack and add to output queue 
							output_queue.enqueue(operator_stack.pop());

							// and when the stack is empty, break to push the new operator into stack
							if (operator_stack.top == null) break;
						}

						// If not empty, then just add the token to the operator stack.
						operator_stack.push (token);
					}

					// Else if the operator stack is empty, just add the operator token to the stack.
					else operator_stack.push (token);
				}

				// If the token is not an operator and is an operand,
				// add the token to the output queue.
				else output_queue.enqueue(token);
			}

			// When no more string is left in input queue, 
			// pop remaining operators from stack and add to output queue
			while (operator_stack.top != null)
				output_queue.enqueue(operator_stack.pop());

			// And finally print the output queue.
			// print("Postfix: ");
			// while (output_queue.front != null) 
			// print(" " + output_queue.dequeue());
			// println("");

			// Lastly, to evaluate the postfix expression,
			EvaluatePostfix (output_queue);
			println("");
		}

		println("Program ended.");
	}
}



