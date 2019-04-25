package matrixCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class userInterface2 extends JPanel implements ActionListener {

	private JTextArea historyWindow = new JTextArea();
	private JTextArea inputWindow = new JTextArea();
	JButton buttonZero = new JButton("0");
	JButton buttonOne = new JButton("1");
	JButton buttonTwo = new JButton("2");
	JButton buttonThree = new JButton("3");
	JButton buttonFour = new JButton("4");
	JButton buttonFive = new JButton("5");
	JButton buttonSix = new JButton("6");
	JButton buttonSeven = new JButton("7");
	JButton buttonEight = new JButton("8");
	JButton buttonNine = new JButton("9");
	JButton buttonAdd = new JButton("+");
	JButton buttonSub = new JButton("-");
	JButton buttonMul = new JButton("×");
	JButton buttonDiv = new JButton("÷");
	JButton buttonClear = new JButton("C");
	JButton buttonDecimal = new JButton(".");
	JButton buttonCompute = new JButton("=");
	JButton buttonMatrix = new JButton("[#]");
	JButton buttonLeftPara = new JButton("(");
	JButton buttonRightPara = new JButton(")");
	JButton buttonDelete = new JButton("⌫");
	JButton buttonCarrot = new JButton("^");
	JButton buttonInverse = new JButton("x¯¹");

	JButton buttonAddRow = new JButton("Add Row");
	JButton buttonRemoveRow = new JButton("Remove Row");
	JButton buttonAddColumn = new JButton("Add Column");
	JButton buttonRemoveColumn = new JButton("Remove Column");
	JButton buttonConfirm = new JButton("Confirm");
	JButton buttonCancel = new JButton("Cancel");

	JTextField matrixR1C1 = new JTextField();
	JTextField matrixR1C2 = new JTextField();
	JTextField matrixR1C3 = new JTextField();
	JTextField matrixR1C4 = new JTextField();
	JTextField matrixR2C1 = new JTextField();
	JTextField matrixR2C2 = new JTextField();
	JTextField matrixR2C3 = new JTextField();
	JTextField matrixR2C4 = new JTextField();
	JTextField matrixR3C1 = new JTextField();
	JTextField matrixR3C2 = new JTextField();
	JTextField matrixR3C3 = new JTextField();
	JTextField matrixR3C4 = new JTextField();
	JTextField matrixR4C1 = new JTextField();
	JTextField matrixR4C2 = new JTextField();
	JTextField matrixR4C3 = new JTextField();
	JTextField matrixR4C4 = new JTextField();

	JLabel historyLabel = new JLabel();
	JLabel inputLabel = new JLabel();
	
	JFrame frame;
	JFrame addAMatrix;

	int currentVisibleRow = 2;
	int currentVisibleColumn = 2;

	int[][] matrixLogic = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	boolean matrixWindowOpen = false;

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputText = inputWindow.getText();
		String historyText = historyWindow.getText();
		if (e.getSource() == buttonCompute) {
			//when button is pressed, pass input to parser and put the operation in historyWindow
			// when the answer is returned from the parser, put it in the inputWindow and historyWindow
			
			historyWindow.setText(historyText + "\n" + inputText);
			
		} else if (e.getSource() == buttonClear) {
			inputWindow.setText("");
		} else if (e.getSource() == buttonZero) {
			inputWindow.setText(inputText + "0");
		} else if (e.getSource() == buttonOne) {
			inputWindow.setText(inputText + "1");
		} else if (e.getSource() == buttonTwo) {
			inputWindow.setText(inputText + "2");
		} else if (e.getSource() == buttonThree) {
			inputWindow.setText(inputText + "3");
		} else if (e.getSource() == buttonFour) {
			inputWindow.setText(inputText + "4");
		} else if (e.getSource() == buttonFive) {
			inputWindow.setText(inputText + "5");
		} else if (e.getSource() == buttonSix) {
			inputWindow.setText(inputText + "6");
		} else if (e.getSource() == buttonSeven) {
			inputWindow.setText(inputText + "7");
		} else if (e.getSource() == buttonEight) {
			inputWindow.setText(inputText + "8");
		} else if (e.getSource() == buttonNine) {
			inputWindow.setText(inputText + "9");
		} else if (e.getSource() == buttonAdd) {
			inputWindow.setText(inputText + "+");
		} else if (e.getSource() == buttonSub) {
			inputWindow.setText(inputText + "-");
		} else if (e.getSource() == buttonMul) {
			inputWindow.setText(inputText + "×");
		} else if (e.getSource() == buttonDiv) {
			inputWindow.setText(inputText + "÷");
		} else if (e.getSource() == buttonDecimal) {
			inputWindow.setText(inputText + ".");
		} else if (e.getSource() == buttonCarrot) {
			inputWindow.setText(inputText + "^");
		} else if (e.getSource() == buttonDelete) {
			inputWindow.setText(inputText.substring(0, inputText.length() - 1));
		} else if (e.getSource() == buttonLeftPara) {
			inputWindow.setText(inputText + "(");
		} else if (e.getSource() == buttonRightPara) {
			inputWindow.setText(inputText + ")");
		} else if (e.getSource() == buttonInverse) {
			inputWindow.setText(inputText + "¯¹");
		} else if (e.getSource() == buttonMatrix) {
			addAMatrix();
//		------------------------------------------------------------
		} else if (e.getSource() == buttonAddRow) {
			if (currentVisibleRow <= 3) {
				currentVisibleRow += 1;
				for (int i = 0; i < currentVisibleRow; i++) {
					for (int j = 0; j < currentVisibleColumn; j++) {
						matrixLogic[i][j] = 1;
					}
				}

			}
			setEditability(matrixLogic);

//			printThisInTheTerminal(matrixLogic);
//		------------------------------------------------------------	
		} else if (e.getSource() == buttonAddColumn) {
			if (currentVisibleColumn <= 3) {
				currentVisibleColumn += 1;
				for (int i = 0; i < currentVisibleRow; i++) {
					for (int j = 0; j < currentVisibleColumn; j++) {
						matrixLogic[i][j] = 1;
					}
				}
			}
			setEditability(matrixLogic);

//			printThisInTheTerminal(matrixLogic);

//		------------------------------------------------------------	
		} else if (e.getSource() == buttonRemoveRow) {
//			if (currentVisibleColumn >= 1) {
//				
//				for (int i = currentVisibleRow; i > 1; i--) {
//					for (int j = currentVisibleColumn; i > 1; j--) {
//						matrixLogic[i][j] = 0;
//					}
//				}
//				currentVisibleColumn -= 1;
//			}
//			
//			printThisInTheTerminal(matrixLogic);
//		
//		------------------------------------------------------------
		} else if (e.getSource() == buttonRemoveColumn) {

//		------------------------------------------------------------	
		} else if (e.getSource() == buttonCancel) {
			cleanUp();
		} else if (e.getSource() == buttonConfirm) {
			// TODO addAMatrix passes string to input window in form [2.0, 3.0, 4.5, 6.0]
			
			cleanUp();
		} else {
			inputWindow.setText("ERROR");
		}
	}

	private void cleanUp() {
		for (int i = 0; i < matrixLogic.length; i++) {
			for (int j = 0; j < matrixLogic.length; j++) {
				matrixLogic[i][j] = 0;
			}
		}			
		currentVisibleRow = 2;
		currentVisibleColumn = 2;
		addAMatrix.dispose();
		matrixWindowOpen = false;
	}
	
	private void setEditability(int[][] matrixLogic) {
		for (int i = 0; i < matrixLogic.length; i++) {
			for (int j = 0; j < matrixLogic.length; j++) {
				if (matrixLogic[0][0] == 1) {
					matrixR1C1.setEditable(true);
				}
				else {
					matrixR1C1.setEditable(false);
				}
				if (matrixLogic[0][1] == 1) {
					matrixR1C2.setEditable(true);
				}
				else {
					matrixR1C2.setEditable(false);
				}
				if (matrixLogic[0][2] == 1) {
					matrixR1C3.setEditable(true);
				}
				else {
					matrixR1C3.setEditable(false);
				}
				if (matrixLogic[0][3] == 1) {
					matrixR1C4.setEditable(true);
				}
				else {
					matrixR1C4.setEditable(false);
				}
				if (matrixLogic[1][0] == 1) {
					matrixR2C1.setEditable(true);
				}
				else {
					matrixR2C1.setEditable(false);
				}
				if (matrixLogic[1][1] == 1) {
					matrixR2C2.setEditable(true);
				}
				else {
					matrixR2C2.setEditable(false);
				}
				if (matrixLogic[1][2] == 1) {
					matrixR2C3.setEditable(true);
				}
				else {
					matrixR2C3.setEditable(false);
				}
				if (matrixLogic[1][3] == 1) {
					matrixR2C4.setEditable(true);
				}
				else {
					matrixR2C4.setEditable(false);
				}
				if (matrixLogic[2][0] == 1) {
					matrixR3C1.setEditable(true);
				}
				else {
					matrixR3C1.setEditable(false);
				}
				if (matrixLogic[2][1] == 1) {
					matrixR3C2.setEditable(true);
				}
				else {
					matrixR3C2.setEditable(false);
				}
				if (matrixLogic[2][2] == 1) {
					matrixR3C3.setEditable(true);
				}
				else {
					matrixR3C3.setEditable(false);
				}
				if (matrixLogic[2][3] == 1) {
					matrixR3C4.setEditable(true);
				}
				else {
					matrixR3C4.setEditable(false);
				}
				if (matrixLogic[3][0] == 1) {
					matrixR4C1.setEditable(true);
				}
				else {
					matrixR4C1.setEditable(false);
				}
				if (matrixLogic[3][1] == 1) {
					matrixR4C2.setEditable(true);
				}
				else {
					matrixR4C2.setEditable(false);
				}
				if (matrixLogic[3][2] == 1) {
					matrixR4C3.setEditable(true);
				}
				else {
					matrixR4C3.setEditable(false);
				}
				if (matrixLogic[3][3] == 1) {
					matrixR4C4.setEditable(true);
				}
				else {
					matrixR4C4.setEditable(false);
				}				
			}
		}
	}

//	private void printThisInTheTerminal(int[][] matrixLogic) {
//		String someString = "";
//
//		for (int i = 0; i < 4; i++) {
//			someString += "\n";
//			for (int j = 0; j < 4; j++) {
//				someString += matrixLogic[i][j];
//			}
//		}
//		System.out.print(someString + "\n");
//	}

	public String addAMatrix() {
		if (matrixWindowOpen == false) {
			matrixWindowOpen = true;

			addAMatrix = new JFrame("Matrix Constructor");

			JPanel Frame = new JPanel(new GridLayout(3, 0, 10, 10));
			JPanel buttonsRow1 = new JPanel(new GridLayout(2, 2, 2, 2));
			JPanel buttonsRow2 = new JPanel(new GridLayout(2, 1, 2, 2));
			JPanel textFieldGrid = new JPanel(new GridLayout(4, 4, 2, 2));
			addAMatrix.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			buttonAddRow.addActionListener(this);
			buttonRemoveRow.addActionListener(this);
			buttonAddColumn.addActionListener(this);
			buttonRemoveColumn.addActionListener(this);
			buttonConfirm.addActionListener(this);
			buttonCancel.addActionListener(this);

			buttonsRow1.add(buttonAddRow);
			buttonsRow1.add(buttonAddColumn);
			buttonsRow1.add(buttonRemoveRow);
			buttonsRow1.add(buttonRemoveColumn);

			matrixR1C3.setEditable(false);
			matrixR1C4.setEditable(false);

			textFieldGrid.add(matrixR1C1);
			textFieldGrid.add(matrixR1C2);
			textFieldGrid.add(matrixR1C3);
			textFieldGrid.add(matrixR1C4);

			matrixR2C3.setEditable(false);
			matrixR2C4.setEditable(false);

			textFieldGrid.add(matrixR2C1);
			textFieldGrid.add(matrixR2C2);
			textFieldGrid.add(matrixR2C3);
			textFieldGrid.add(matrixR2C4);

			matrixR3C1.setEditable(false);
			matrixR3C2.setEditable(false);
			matrixR3C3.setEditable(false);
			matrixR3C4.setEditable(false);

			textFieldGrid.add(matrixR3C1);
			textFieldGrid.add(matrixR3C2);
			textFieldGrid.add(matrixR3C3);
			textFieldGrid.add(matrixR3C4);

			matrixR4C1.setEditable(false);
			matrixR4C2.setEditable(false);
			matrixR4C3.setEditable(false);
			matrixR4C4.setEditable(false);

			textFieldGrid.add(matrixR4C1);
			textFieldGrid.add(matrixR4C2);
			textFieldGrid.add(matrixR4C3);
			textFieldGrid.add(matrixR4C4);

			buttonsRow2.add(buttonConfirm);
			buttonsRow2.add(buttonCancel);

			Frame.add(buttonsRow1);
			Frame.add(textFieldGrid);
			Frame.add(buttonsRow2);

			addAMatrix.add(Frame);

			addAMatrix.pack();
			addAMatrix.setVisible(true);

		}

		return null;
	}

	public userInterface2() {
		super(new BorderLayout());

		
		
		JPanel fullWindow = new JPanel(new GridLayout(3, 0, 10, 10));
		JPanel inputButtons = new JPanel(new GridLayout(4, 0, 2, 2));
		JPanel inputRow1 = new JPanel(new GridLayout(1, 0, 2, 0));
		JPanel inputRow2 = new JPanel(new GridLayout(1, 0, 2, 0));
		JPanel inputRow3 = new JPanel(new GridLayout(1, 0, 2, 0));
		JPanel inputRow4 = new JPanel(new GridLayout(1, 0, 2, 0));

		historyWindow.setEditable(false);
		
		JScrollPane historyScroller = new JScrollPane(historyWindow);
		JScrollPane inputScroller = new JScrollPane(inputWindow);

		historyScroller.setPreferredSize(new Dimension(0, 0));
		inputScroller.setPreferredSize(new Dimension(0, 0));

		fullWindow.setFocusable(true);

		fullWindow.add(historyScroller);
		fullWindow.add(inputScroller);

		inputRow1.add(buttonSeven);
		inputRow1.add(buttonEight);
		inputRow1.add(buttonNine);
		inputRow1.add(buttonAdd);
		inputRow1.add(buttonSub);
		inputRow1.add(buttonClear);

		inputRow2.add(buttonFour);
		inputRow2.add(buttonFive);
		inputRow2.add(buttonSix);
		inputRow2.add(buttonMul);
		inputRow2.add(buttonDiv);
		inputRow2.add(buttonDelete);

		inputRow3.add(buttonOne);
		inputRow3.add(buttonTwo);
		inputRow3.add(buttonThree);
		inputRow3.add(buttonLeftPara);
		inputRow3.add(buttonRightPara);
		inputRow3.add(buttonCarrot);

		inputRow4.add(buttonZero);
		inputRow4.add(buttonDecimal);
		inputRow4.add(buttonInverse);
		inputRow4.add(buttonMatrix);
		inputRow4.add(buttonCompute);

		inputButtons.add(inputRow1);
		inputButtons.add(inputRow2);
		inputButtons.add(inputRow3);
		inputButtons.add(inputRow4);
		fullWindow.add(inputButtons);

		this.buttonZero.addActionListener(this);
		this.buttonOne.addActionListener(this);
		this.buttonTwo.addActionListener(this);
		this.buttonThree.addActionListener(this);
		this.buttonFour.addActionListener(this);
		this.buttonFive.addActionListener(this);
		this.buttonSix.addActionListener(this);
		this.buttonSeven.addActionListener(this);
		this.buttonEight.addActionListener(this);
		this.buttonNine.addActionListener(this);
		this.buttonAdd.addActionListener(this);
		this.buttonSub.addActionListener(this);
		this.buttonMul.addActionListener(this);
		this.buttonDiv.addActionListener(this);
		this.buttonClear.addActionListener(this);
		this.buttonDecimal.addActionListener(this);
		this.buttonCompute.addActionListener(this);
		this.buttonCarrot.addActionListener(this);
		this.buttonInverse.addActionListener(this);
		this.buttonMatrix.addActionListener(this);
		this.buttonLeftPara.addActionListener(this);
		this.buttonRightPara.addActionListener(this);
		this.buttonDelete.addActionListener(this);

		fullWindow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(fullWindow, BorderLayout.CENTER);
	}

	private static void createCalculator() {
		JFrame UI = new JFrame("Matrix Calculator");

		UI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = new userInterface2();
		newContentPane.setOpaque(true);
		UI.setContentPane(newContentPane);
		UI.pack();
		UI.setVisible(true);

	}

	public static void main(String[] args) {
		createCalculator();
	}

}