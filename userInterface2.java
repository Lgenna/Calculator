package matrixCalculator;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class userInterface2 extends JPanel implements ActionListener, KeyListener {

	final Set<Integer> pressed = new HashSet<Integer>();

	private JTextArea historyWindow = new JTextArea("Output");
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
	JButton buttonDotProduct = new JButton("•");

	JButton buttonAddRow = new JButton("Add Row");
	JButton buttonRemoveRow = new JButton("Remove Row");
	JButton buttonAddColumn = new JButton("Add Column");
	JButton buttonRemoveColumn = new JButton("Remove Column");
	JButton buttonConfirm = new JButton("Confirm");
	JButton buttonCancel = new JButton("Cancel");

	JTextField matrixR1C1 = new JTextField("");
	JTextField matrixR1C2 = new JTextField("");
	JTextField matrixR1C3 = new JTextField("");
	JTextField matrixR1C4 = new JTextField("");
	JTextField matrixR2C1 = new JTextField("");
	JTextField matrixR2C2 = new JTextField("");
	JTextField matrixR2C3 = new JTextField("");
	JTextField matrixR2C4 = new JTextField("");
	JTextField matrixR3C1 = new JTextField("");
	JTextField matrixR3C2 = new JTextField("");
	JTextField matrixR3C3 = new JTextField("");
	JTextField matrixR3C4 = new JTextField("");
	JTextField matrixR4C1 = new JTextField("");
	JTextField matrixR4C2 = new JTextField("");
	JTextField matrixR4C3 = new JTextField("");
	JTextField matrixR4C4 = new JTextField("");

	JLabel historyLabel = new JLabel();
	JLabel inputLabel = new JLabel();

	JFrame frame1;
	JFrame addAMatrix;

	int currentVisibleRow = 2;
	int currentVisibleColumn = 2;

	int[][] matrixLogic = { { 1, 1, 0, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	boolean matrixWindowOpen = false;

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputText = inputWindow.getText();
		String historyText = historyWindow.getText();
		if (e.getSource() == buttonCompute) {
			// when button is pressed, pass input to parser and put the operation in
			// historyWindow
			// when the answer is returned from the parser, put it in the inputWindow and
			// historyWindow

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
		} else if (e.getSource() == buttonDotProduct) {
			inputWindow.setText(inputText + "•");
		} else if (e.getSource() == buttonMatrix) {
			addAMatrix();
		} else if (e.getSource() == buttonAddRow) {
			if (currentVisibleRow <= 3) {
				currentVisibleRow += 1;
				addRowsOrColumns();
			}
			setEditability(matrixLogic);
		} else if (e.getSource() == buttonAddColumn) {
			if (currentVisibleColumn <= 3) {
				currentVisibleColumn += 1;
				addRowsOrColumns();
			}
			setEditability(matrixLogic);
		} else if (e.getSource() == buttonRemoveRow) {
			if (currentVisibleRow > 1) {
				if (currentVisibleColumn >= 2 || currentVisibleRow >= 3) {
					for (int i = 0; i < currentVisibleColumn; i++) {
						int num = 0;
						if (matrixLogic[currentVisibleRow - 1][i + num] == 1) {
							matrixLogic[currentVisibleRow - 1][i + num] = 0;
							num++;
						}
					}
					currentVisibleRow -= 1;
				}
			}
			setEditability(matrixLogic);
		} else if (e.getSource() == buttonRemoveColumn) {
			if (currentVisibleColumn > 1) {
				if (currentVisibleRow >= 2 || currentVisibleColumn >= 3) {
					for (int i = 0; i < currentVisibleRow; i++) {
						int num = 0;
						if (matrixLogic[i + num][currentVisibleColumn - 1] == 1) {
							matrixLogic[i + num][currentVisibleColumn - 1] = 0;
							num++;
						}
					}
					currentVisibleColumn -= 1;
				}
			}
			setEditability(matrixLogic);
		} else if (e.getSource() == buttonCancel) {
			cleanUp();
		} else if (e.getSource() == buttonConfirm) {
			int[][] filledArray = confirmMatrix();
			inputWindow.setText(inputText + Arrays.deepToString(filledArray));
			cleanUp();
		} else {
			inputWindow.setText("ERROR");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		String inputText = inputWindow.getText();
		int key = e.getKeyCode();
		if (key == 111 || key == 47) {
			inputWindow.setText(inputText.substring(0, inputText.length() - 1) + "÷");
		}
		if (key == 106) {
			inputWindow.setText(inputText.substring(0, inputText.length() - 1) + "×");
		}
		if (pressed.size() > 1) {
			if (pressed.contains(56) && pressed.contains(16)) {
				inputWindow.setText(inputText.substring(0, inputText.length() - 1) + "×");
			}
		}
		pressed.clear();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		pressed.add(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	private void addRowsOrColumns() {
		for (int i = 0; i < currentVisibleRow; i++) {
			for (int j = 0; j < currentVisibleColumn; j++) {
				matrixLogic[i][j] = 1;
			}
		}
	}

	private int[][] confirmMatrix() {
		int[][] filledArray = new int[currentVisibleRow][currentVisibleColumn];

		if (matrixLogic[0][0] == 1) {
			if (!matrixR1C1.getText().equals("")) {
				filledArray[0][0] = Integer.parseInt(matrixR1C1.getText());
			} else {
				filledArray[0][0] = 0;
			}
		}

		if (matrixLogic[1][0] == 1) {
			if (!matrixR2C1.getText().equals("")) {
				filledArray[1][0] = Integer.parseInt(matrixR2C1.getText());
			} else {
				filledArray[1][0] = 0;
			}
		}
		if (matrixLogic[2][0] == 1) {
			if (!matrixR3C1.getText().equals("")) {
				filledArray[2][0] = Integer.parseInt(matrixR3C1.getText());
			} else {
				filledArray[2][0] = 0;
			}
		}
		if (matrixLogic[3][0] == 1) {
			if (!matrixR4C1.getText().equals("")) {
				filledArray[3][0] = Integer.parseInt(matrixR4C1.getText());
			} else {
				filledArray[3][0] = 0;
			}
		}
		if (matrixLogic[0][1] == 1) {
			if (!matrixR1C2.getText().equals("")) {
				filledArray[0][1] = Integer.parseInt(matrixR1C2.getText());
			} else {
				filledArray[0][1] = 0;
			}
		}
		if (matrixLogic[1][1] == 1) {
			if (!matrixR2C2.getText().equals("")) {
				filledArray[1][1] = Integer.parseInt(matrixR2C2.getText());
			} else {
				filledArray[1][1] = 0;
			}
		}
		if (matrixLogic[2][1] == 1) {
			if (!matrixR3C2.getText().equals("")) {
				filledArray[2][1] = Integer.parseInt(matrixR3C2.getText());
			} else {
				filledArray[2][1] = 0;
			}
		}
		if (matrixLogic[3][1] == 1) {
			if (!matrixR4C2.getText().equals("")) {
				filledArray[3][1] = Integer.parseInt(matrixR4C2.getText());
			} else {
				filledArray[3][1] = 0;
			}
		}
		if (matrixLogic[0][2] == 1) {
			if (!matrixR1C3.getText().equals("")) {
				filledArray[0][2] = Integer.parseInt(matrixR1C3.getText());
			} else {
				filledArray[0][2] = 0;
			}
		}
		if (matrixLogic[1][2] == 1) {
			if (!matrixR2C3.getText().equals("")) {
				filledArray[1][2] = Integer.parseInt(matrixR2C3.getText());
			} else {
				filledArray[1][2] = 0;
			}
		}
		if (matrixLogic[2][2] == 1) {
			if (!matrixR3C3.getText().equals("")) {
				filledArray[2][2] = Integer.parseInt(matrixR3C3.getText());
			} else {
				filledArray[2][2] = 0;
			}
		}
		if (matrixLogic[3][2] == 1) {
			if (!matrixR4C3.getText().equals("")) {
				filledArray[3][2] = Integer.parseInt(matrixR4C3.getText());
			} else {
				filledArray[3][2] = 0;
			}
		}
		if (matrixLogic[0][3] == 1) {
			if (!matrixR1C4.getText().equals("")) {
				filledArray[0][3] = Integer.parseInt(matrixR1C4.getText());
			} else {
				filledArray[0][3] = 0;
			}
		}
		if (matrixLogic[1][3] == 1) {
			if (!matrixR2C4.getText().equals("")) {
				filledArray[1][3] = Integer.parseInt(matrixR2C4.getText());
			} else {
				filledArray[1][3] = 0;
			}
		}
		if (matrixLogic[2][3] == 1) {
			if (!matrixR3C4.getText().equals("")) {
				filledArray[2][3] = Integer.parseInt(matrixR3C4.getText());
			} else {
				filledArray[2][3] = 0;
			}
		}
		if (matrixLogic[3][3] == 1) {
			if (!matrixR4C4.getText().equals("")) {
				filledArray[3][3] = Integer.parseInt(matrixR4C4.getText());
			} else {
				filledArray[3][3] = 0;
			}
		}
		return filledArray;
	}

	private void cleanUp() {
		for (int i = 0; i < matrixLogic.length; i++) {
			for (int j = 0; j < matrixLogic.length; j++) {
				if ((i == 0 && j == 0) || (i == 0 && j == 1) || (i == 1 && j == 0) || (i == 1 && j == 1)) {
					matrixLogic[i][j] = 1;
				} else {
					matrixLogic[i][j] = 0;
				}
			}
		}

		setEditability(matrixLogic);
		currentVisibleRow = 2;
		currentVisibleColumn = 2;

		buttonAddRow.removeActionListener(this);
		buttonAddColumn.removeActionListener(this);
		buttonRemoveRow.removeActionListener(this);
		buttonAddColumn.removeActionListener(this);
		buttonConfirm.removeActionListener(this);
		buttonCancel.removeActionListener(this);

		matrixR1C1.setText("");
		matrixR2C1.setText("");
		matrixR3C1.setText("");
		matrixR4C1.setText("");
		matrixR1C2.setText("");
		matrixR2C2.setText("");
		matrixR3C2.setText("");
		matrixR4C2.setText("");
		matrixR1C3.setText("");
		matrixR2C3.setText("");
		matrixR3C3.setText("");
		matrixR4C3.setText("");
		matrixR1C4.setText("");
		matrixR2C4.setText("");
		matrixR3C4.setText("");
		matrixR4C4.setText("");

		addAMatrix.dispose();
		matrixWindowOpen = false;
	}

	private void setEditability(int[][] matrixLogic) {
		if (matrixLogic[0][0] == 1) {
			matrixR1C1.setEditable(true);
		} else {
			matrixR1C1.setEditable(false);
		}
		if (matrixLogic[0][1] == 1) {
			matrixR1C2.setEditable(true);
		} else {
			matrixR1C2.setEditable(false);
		}
		if (matrixLogic[0][2] == 1) {
			matrixR1C3.setEditable(true);
		} else {
			matrixR1C3.setEditable(false);
		}
		if (matrixLogic[0][3] == 1) {
			matrixR1C4.setEditable(true);
		} else {
			matrixR1C4.setEditable(false);
		}
		if (matrixLogic[1][0] == 1) {
			matrixR2C1.setEditable(true);
		} else {
			matrixR2C1.setEditable(false);
		}
		if (matrixLogic[1][1] == 1) {
			matrixR2C2.setEditable(true);
		} else {
			matrixR2C2.setEditable(false);
		}
		if (matrixLogic[1][2] == 1) {
			matrixR2C3.setEditable(true);
		} else {
			matrixR2C3.setEditable(false);
		}
		if (matrixLogic[1][3] == 1) {
			matrixR2C4.setEditable(true);
		} else {
			matrixR2C4.setEditable(false);
		}
		if (matrixLogic[2][0] == 1) {
			matrixR3C1.setEditable(true);
		} else {
			matrixR3C1.setEditable(false);
		}
		if (matrixLogic[2][1] == 1) {
			matrixR3C2.setEditable(true);
		} else {
			matrixR3C2.setEditable(false);
		}
		if (matrixLogic[2][2] == 1) {
			matrixR3C3.setEditable(true);
		} else {
			matrixR3C3.setEditable(false);
		}
		if (matrixLogic[2][3] == 1) {
			matrixR3C4.setEditable(true);
		} else {
			matrixR3C4.setEditable(false);
		}
		if (matrixLogic[3][0] == 1) {
			matrixR4C1.setEditable(true);
		} else {
			matrixR4C1.setEditable(false);
		}
		if (matrixLogic[3][1] == 1) {
			matrixR4C2.setEditable(true);
		} else {
			matrixR4C2.setEditable(false);
		}
		if (matrixLogic[3][2] == 1) {
			matrixR4C3.setEditable(true);
		} else {
			matrixR4C3.setEditable(false);
		}
		if (matrixLogic[3][3] == 1) {
			matrixR4C4.setEditable(true);
		} else {
			matrixR4C4.setEditable(false);
		}
	}

	public void addAMatrix() {

		if (matrixWindowOpen == false) {
			matrixWindowOpen = true;

			addAMatrix = new JFrame("Matrix Constructor");

			JPanel Frame = new JPanel(new GridLayout(3, 0, 10, 10));
			JPanel buttonsRow1 = new JPanel(new GridLayout(2, 2, 2, 2));
			JPanel buttonsRow2 = new JPanel(new GridLayout(2, 1, 2, 2));
			JPanel textFieldGrid = new JPanel(new GridLayout(4, 4, 2, 2));

			addAMatrix.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addAMatrix.setUndecorated(true);

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

			Frame.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			add(Frame, BorderLayout.CENTER);

			addAMatrix.add(Frame);
			addAMatrix.pack();
			addAMatrix.setVisible(true);
		}
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
		Color lighterGray = new Color(210, 210, 210);
		historyWindow.setBackground(lighterGray);
		Font font = new Font("Segoe Script", Font.PLAIN, 14);
		Font bolderFont = new Font("Segoe Script", Font.BOLD, 14);
		historyWindow.setFont(font);
		inputWindow.setFont(font);
		Color blue = new Color(51, 173, 255);
		buttonCompute.setFont(bolderFont);
		buttonCompute.setBackground(blue);

		JScrollPane historyScroller = new JScrollPane(historyWindow);
		JScrollPane inputScroller = new JScrollPane(inputWindow);

		inputWindow.addKeyListener(this);

		buttonClear.setToolTipText("Clear");
		buttonCompute.setToolTipText("Compute");
		buttonDotProduct.setToolTipText("Dot Product");
		buttonMatrix.setToolTipText("Add a Matrix");
		buttonDelete.setToolTipText("Backspace");
		buttonCarrot.setToolTipText("Exponet");
		buttonAdd.setToolTipText("Add");
		buttonSub.setToolTipText("Subtract or Negate");
		buttonMul.setToolTipText("Multiply");
		buttonDiv.setToolTipText("Divide");
		buttonDecimal.setToolTipText("Decimal");
		buttonLeftPara.setToolTipText("Left Parenthesis");
		buttonRightPara.setToolTipText("Right Parenthesis");

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
		inputRow4.add(buttonDotProduct);
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
		this.buttonDotProduct.addActionListener(this);
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