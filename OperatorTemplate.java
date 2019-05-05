
import java.util.function.BiFunction;

/**
 * 
 * @author V. Corina
 * Factory template to define and build operations
 */
public class OperatorTemplate {

	public static final OperatorTemplate[] OPERATORS_LOW_TO_HIGH_PRIORITY = {			
			new OperatorTemplate('-', (left, right)->{return ((Literal)left).minus((Literal) right);}),					
			new OperatorTemplate('+', (left, right)->{return ((Literal)left).plus((Literal) right);}),					
			new OperatorTemplate('/', (left, right)->{return ((Literal)left).dividedBy((Literal) right);}),
			new OperatorTemplate('x', (left, right)->{return ((Literal)left).times((Literal) right);}),
			new OperatorTemplate('^', (left, right)->{return ((Literal)left).toThePowerOf((Literal)right);}),					
			new OperatorTemplate((char)183, (left, right)->{return ((Literal)left).dot((Literal)right);}),					
		};
	
	private BiFunction<Token, Token, Literal> operation;
	private char symbol;
	
	private OperatorTemplate(char symbol, BiFunction<Token, Token, Literal> operation) {
		this.symbol = symbol;
		this.operation = operation;
	}
	
	private OperatorTemplate(char symbol, BiFunction<Token, Token, Literal> operation, boolean dummyOp) {
		this.symbol = symbol;
		this.operation = operation;
	
	}
	
	/**
	 * Creates an operator from the template
	 * @param left the token to the left of the new operator
	 * @return the new operator
	 */
	public Operator creatOp(Token left) {
		return new Operator(symbol, operation, left);
	}
	
	/**
	 * 
	 * @return the OperatorTemplate's character representation
	 */
	public char getSymbol() {
		return symbol;
	}
	
	@Override
	public String toString() {
		return ""+ symbol;
	}
	
	
}
