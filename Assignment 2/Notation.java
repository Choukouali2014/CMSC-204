/**
 * @author Frank Choukouali
 */
public class Notation {

	
	/**
	 * Calcul the value of the postfix expression
	 * @param postfixExpr to be calculated
	 * @return the value of the postfix expression caculated
	 * @throws InvalidNotationFormatException if the format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		NotationStack<String> result = new NotationStack<String>(postfixExpr.length());
		double eval = 0;
		double firstElmt = 0, secondElmt = 0, OperationResult = 0;
		for (int i = 0; i < postfixExpr.length(); i++) {
			char OneCharExpre = postfixExpr.charAt(i);

			if (Character.isLetterOrDigit(OneCharExpre)) {
				try {
					result.push(OneCharExpre + "");
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			} else {
				if (result.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				try {
					firstElmt = Double.parseDouble(result.pop());
					secondElmt = Double.parseDouble(result.pop());
				} catch (NumberFormatException | StackUnderflowException e) {
					e.printStackTrace();
				}
				try {
					result.push(OperationFunc(OneCharExpre, firstElmt, secondElmt) + "");
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}
		}

		if (result.size() > 1) {
			throw new InvalidNotationFormatException();
		}

		try {
			eval = Double.parseDouble(result.top());
		} catch (NumberFormatException | StackUnderflowException e) {
			e.printStackTrace();
		}
		return eval;
	}

	
	/**
	 * Convert postfix notation to infix notation
	 * @param postfix expression to be converted
	 * @return the infix notation
	 * @throws InvalidNotationFormatException  if the format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		NotationStack<String> result = new NotationStack<String>(postfix.length());

		for (int i = 0; i < postfix.length(); i++) {
			char OneCharExpre = postfix.charAt(i);

			if (Character.isLetterOrDigit(OneCharExpre)) {
				try {
					result.push(OneCharExpre + "");
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			} else {
				if (result.size() < 2) {
					throw new InvalidNotationFormatException();
				}
				String firstVal = "", secondVal = "";
				try {
					firstVal = result.pop();
					secondVal = result.pop();
					result.push("(" + secondVal + "" + OneCharExpre + "" + firstVal + ")");
				} catch (StackUnderflowException e) {
					e.printStackTrace();
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}

			}
		}
		if (result.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return result.toString();
	}

	
	/**
	 * Convert infix notation to postfix notation
	 * @param infix expression to be converted
	 * @return the postfix notation 
	 * @throws InvalidNotationFormatException if the format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		NotationQueue<String> result = new NotationQueue<String>(infix.length());
		NotationStack<String> queueElmt = new NotationStack<String>(infix.length());

		for (int i = 0; i < infix.length(); i++) {
			char OneCharExpre = infix.charAt(i);

			if (Character.isLetterOrDigit(OneCharExpre)) {
				try {
					result.enqueue(OneCharExpre + "");
				} catch (QueueOverflowException e) {
					e.printStackTrace();
				}
			} else if (OneCharExpre == '(') {
				try {
					queueElmt.push(OneCharExpre + "");
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			} else if (OneCharExpre == ')') {
				try {
					while (!queueElmt.isEmpty() && queueElmt.top().charAt(0) != '(') {
						result.enqueue(queueElmt.pop());
					}
				} catch (StackUnderflowException | QueueOverflowException e) {
					e.printStackTrace();
				}

				if (!queueElmt.isEmpty()) {
					try {
						queueElmt.pop();
					} catch (StackUnderflowException e) {
						e.printStackTrace();
					}

				} else {
					throw new InvalidNotationFormatException();
				}

			} else {
				try {
					while (!queueElmt.isEmpty() && Precedent(OneCharExpre) <= Precedent(queueElmt.top().charAt(0))) {
						result.enqueue(queueElmt.pop());
					}
				} catch (StackUnderflowException | QueueOverflowException e) {
					e.printStackTrace();
				}

				try {
					queueElmt.push(OneCharExpre + "");
				} catch (StackOverflowException e) {
					e.printStackTrace();
				}
			}
		}

		while (!queueElmt.isEmpty()) {
			try {
				if (queueElmt.top().charAt(0) == '(')
					throw new InvalidNotationFormatException();
				result.enqueue(queueElmt.pop());
			} catch (QueueOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}
		}

		return result.toString();
	}

	/**
	 * Determines the precedence of an operator
	 * @param opt for operator
	 * @return returns 1 if the operator is addition or subtraction , returns 2 if
	 *         the operator is multiplication or division, returns -1 if none
	 */
	private static int Precedent(char opt) {
		switch (opt) {
		case '+':
		case '-':
			return 1;
		case '/':
		case '*':
			return 2;
		}
		return -1;
	}

	/**
	 * Determines the operation to do based on the operator 
	 * @param OneCharExpre
	 * @param firstElmt
	 * @param secondElmt
	 * @return the result of the operation 
	 */
	private static double OperationFunc(char OneCharExpre, double firstElmt, double secondElmt) {
		double result = 0;
		switch (OneCharExpre) {
		case '*':
			result = secondElmt * firstElmt;
			break;
		case '/':
			result = secondElmt / firstElmt;
			break;
		case '+':
			result = secondElmt + firstElmt;
			break;
		case '-':
			result = secondElmt - firstElmt;
			break;
		}
		return result;
	}

}