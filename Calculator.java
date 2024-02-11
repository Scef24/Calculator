import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Calculator extends JFrame implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JLabel title;
    private JLabel displayNum1;
    private JLabel displayOperation;
    private JTextField input;
    private JButton[] memory = new JButton[6];
    private JButton[] operations = new JButton[13];
    private JButton[] numbers = new JButton[11];
    private StringBuilder inputText = new StringBuilder();
    private double currentResult = 0.0;
    private Controller controller;
    private boolean isMemoryShowing = false;

    public Calculator() {

		controller = new Controller();
        frame = new JFrame();
        frame.setSize(390, 560);
        frame.setTitle("Calculator");
       frame.getContentPane().setBackground(new Color(160, 160, 160));

        title = new JLabel("Standard");
		title.setBounds(30, 10, 100, 80);
        title.setFont(new Font("Segoe UI", Font.PLAIN, 50));

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(160, 160, 160));

		displayNum1 = new JLabel("");
        displayNum1.setBounds(250, 50, 100, 80);
        displayOperation = new JLabel("");
        displayOperation.setBounds(310, 50, 100, 80);

        input = new JTextField("0");
        input.setBounds(5, 120, 500, 50);
        input.setBorder(null);
         input.setBackground(new Color(160, 160, 160));

		Color dirtyWhite = new Color(192, 192, 192);
		Color darkerColor = new Color(180, 180, 190);
		Color blacknwhite = new Color(230, 230, 235);
		Color greyBorderColor = new Color(169, 169, 169);

		Border buttonBorder = BorderFactory.createCompoundBorder(
		                 new LineBorder(Color.black, 1),
		                new EmptyBorder(5, 10, 5, 10)
        );

        Border numberBorder = BorderFactory.createCompoundBorder(
					new LineBorder(greyBorderColor, 1),
					new EmptyBorder(5,10,5,10)
			);
        memory[0] = new JButton("MC");
        memory[0].setBounds(5, 175, 60, 30);
        memory[1] = new JButton("MR");
        memory[1].setBounds(65, 175, 60, 30);
        memory[2] = new JButton("M+");
        memory[2].setBounds(125, 175, 60, 30);
        memory[3] = new JButton("M-");
        memory[3].setBounds(185, 175, 60, 30);
        memory[4] = new JButton("MS");
        memory[4].setBounds(245, 175, 60, 30);
        memory[5] = new JButton("Mshw");
        memory[5].setBounds(305, 175, 65, 30);

        for(int i = 0; i<=5; i++) {
			memory[i].setBackground(dirtyWhite);
			memory[i].setBorder(buttonBorder);
		}

        operations[0] = new JButton("%");
        operations[0].setBounds(5, 207, 90, 50);
        operations[1] = new JButton("SQR");
        operations[1].setBounds(96, 207, 90, 50);
        operations[2] = new JButton("x2");
        operations[2].setBounds(190, 207, 90, 50);
        operations[3] = new JButton("1/x");
        operations[3].setBounds(280, 208, 90, 50);

        operations[4] = new JButton("CE");
        operations[4].setBounds(5, 259, 90, 50);
        operations[5] = new JButton("C");
        operations[5].setBounds(97, 259, 90, 50);
        operations[6] = new JButton("Erase");
        operations[6].setBounds(190, 259, 90, 50);
        operations[7] = new JButton("/");
        operations[7].setBounds(280, 259, 90, 50);

        operations[8] = new JButton("X");
        operations[8].setBounds(280, 310, 90, 50);
        operations[9] = new JButton("-");
        operations[9].setBounds(280, 362, 90, 50);
        operations[10] = new JButton("+");
        operations[10].setBounds(280, 415, 90, 50);
        operations[11] = new JButton("=");
        operations[11].setBounds(280, 467, 90, 50);
        operations[12] = new JButton("+-");
        operations[12].setBounds(5, 467, 90, 50);

        for(int i = 0; i<=12; i++) {
			operations[i].setBorder(null);
			operations[i].setBackground(darkerColor);
			operations[i].setBorder(buttonBorder);
		}

        numbers[0] = new JButton("0");
        numbers[0].setBounds(5, 310, 90, 50);
        numbers[1] = new JButton("1");
        numbers[1].setBounds(97, 310, 90, 50);
        numbers[2] = new JButton("2");
        numbers[2].setBounds(190, 310, 90, 50);

        numbers[3] = new JButton("3");
        numbers[3].setBounds(5, 362, 90, 50);
        numbers[4] = new JButton("4");
        numbers[4].setBounds(97, 362, 90, 50);
        numbers[5] = new JButton("5");
        numbers[5].setBounds(190, 362, 90, 50);

        numbers[6] = new JButton("6");
        numbers[6].setBounds(5, 415, 90, 50);
        numbers[7] = new JButton("7");
        numbers[7].setBounds(97, 415, 90, 50);
        numbers[8] = new JButton("8");
        numbers[8].setBounds(190, 415, 90, 50);
        numbers[9] = new JButton("9");
        numbers[9].setBounds(97, 467, 90, 50);
        numbers[10] = new JButton(".");
        numbers[10].setBounds(190, 467, 90, 50);

        for(int i = 0; i<=10; i++){
			numbers[i].setBorder(buttonBorder);
			numbers[i].setBackground(blacknwhite);

		}

 			Font calculatorFont = new Font("Segoe UI", Font.PLAIN, 16);
		        title.setFont(calculatorFont);
		        displayNum1.setFont(calculatorFont);
		        displayOperation.setFont(calculatorFont);
		        input.setFont(calculatorFont);

		        for (JButton button : memory) {
		            button.setFont(calculatorFont);
		        }

		        for (JButton button : operations) {
		            button.setFont(calculatorFont);
		        }

		        for (JButton button : numbers) {
		            button.setFont(calculatorFont);
		        }


        panel.add(title);
        panel.add(displayNum1);
        panel.add(displayOperation);
        panel.add(input);
        panel.add(memory[0]);
        panel.add(memory[1]);
        panel.add(memory[2]);
        panel.add(memory[3]);
        panel.add(memory[4]);
        panel.add(memory[5]);

        panel.add(operations[0]);
        panel.add(operations[1]);
        panel.add(operations[2]);
        panel.add(operations[3]);
        panel.add(operations[4]);
        panel.add(operations[5]);
        panel.add(operations[6]);
        panel.add(operations[7]);
        panel.add(operations[8]);
        panel.add(operations[9]);
        panel.add(operations[10]);
        panel.add(operations[11]);
        panel.add(operations[12]);

        panel.add(numbers[0]);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(numbers[10]);

        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 6; i++) {
            memory[i].addActionListener(this);
        }
        for (int i = 0; i < 13; i++) {
            operations[i].addActionListener(this);
        }

        for (int i = 0; i < 11; i++) {
            numbers[i].addActionListener(this);
        }

    }
        public StringBuilder getInputText() {
		        return inputText;
		    }


	public void setInputText(StringBuilder newText) {
	    inputText = newText;
	    input.setText(inputText.toString());
	}


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Calculator c = new Calculator();
        });
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
    	// Controller c = new Controller();

        if (source == numbers[10]) { // Dot button
            if (!inputText.toString().contains(".")) {
                inputText.append(".");
                input.setText(inputText.toString());
            }
        } else {
            for (int n = 9; n >= 0; n--) {
                if (source == numbers[n]) {
                    inputText.append(n);
                    input.setText(inputText.toString());
                }
            }
        }

        if (source == operations[0]) { // Percentage button
            try {
                double x = controller.sqRoot(parseInput());
                String formattedResult = String.format("%.3f", x);
                input.setText(formattedResult);
            } catch (NumberFormatException ex) {
                input.setText("Invalid Input");
            }
        }

        if (source == operations[1]) {
            try {
                double x = controller.sqRoot(parseInput());
                input.setText(String.valueOf(x));
            } catch (NumberFormatException ex) {
                input.setText("Invalid Input");
            }
        }

        if (source == operations[2]) {
            try {
                int x = controller.squared(Integer.parseInt(input.getText()));
                input.setText(String.valueOf(x));
            } catch (NumberFormatException ex) {
                input.setText("Invalid Input");
            }
        }

        if (source == operations[3]) {
            try {
                double x = controller.reciprocal(parseInput());
                String formattedResult = String.format("%.3f", x);
                input.setText(formattedResult);
            } catch (NumberFormatException ex) {
                input.setText("Invalid Input");
            }
        }

        if (source == operations[4]) {
            inputText.setLength(0);
            input.setText("");
        }

        if (source == operations[5]) {
            inputText.setLength(0);
            input.setText("");
        }

        if (source == operations[6]) {
            String currentText = input.getText();
            int length = currentText.length();
            if (length > 0) {
                inputText.deleteCharAt(inputText.length() - 1);
                input.setText(inputText.toString());
            }
        }

       if (source == operations[7]) { // Division button
	       try {
	           double x = parseInput();
	           currentResult = x;
	           if (x % 1 == 0) {
	               displayNum1.setText(String.valueOf((int) x));
	           } else {
	               displayNum1.setText(String.valueOf(x));
	           }

	           displayOperation.setText("/");
	           inputText.setLength(0);
	           input.setText("");
	       } catch (NumberFormatException ex) {
	           input.setText("Invalid Input");
	       }
	   }

        if (source == operations[8]) { // Multiplication button
            try {
		   	           double x = parseInput();
		   	           currentResult = x;

		   	           if (x % 1 == 0) {
		   	               displayNum1.setText(String.valueOf((int) x));
		   	           } else {
		   	               displayNum1.setText(String.valueOf(x));
		   	           }

		   	           displayOperation.setText("x");
		   	           inputText.setLength(0);
		   	           input.setText("");
		   	       } catch (NumberFormatException ex) {
		   	           input.setText("Invalid Input");
	       }
        }

        if (source == operations[9]) { // Subtraction button
               try {
		   		   	           double x = parseInput();
		   		   	           currentResult = x;
		   		   	           if (x % 1 == 0) {
		   		   	               displayNum1.setText(String.valueOf((int) x));
		   		   	           } else {
		   		   	               displayNum1.setText(String.valueOf(x));
		   		   	           }

		   		   	           displayOperation.setText("-");
		   		   	           inputText.setLength(0);
		   		   	           input.setText("");
		   		   	       } catch (NumberFormatException ex) {
		   		   	           input.setText("Invalid Input");
		   	       }
        }

        if (source == operations[10]) { // Addition button
              try {
		  		   	           double x = parseInput();
		  		   	           currentResult = x;
		  		   	           if (x % 1 == 0) {
		  		   	               displayNum1.setText(String.valueOf((int) x));
		  		   	           } else {
		  		   	               displayNum1.setText(String.valueOf(x));
		  		   	           }

		  		   	           displayOperation.setText("+");
		  		   	           inputText.setLength(0);
		  		   	           input.setText("");
		  		   	       } catch (NumberFormatException ex) {
		  		   	           input.setText("Invalid Input");
		  	       }
        }

       if (source == operations[11]) { // Equals button
	       try {
	           double y = parseInput();
	           switch (displayOperation.getText()) {
	               case "/":
	                   if (y != 0) {
	                       double result = controller.division(currentResult, y);

	                       if (result % 1 == 0) {
	                           input.setText(String.valueOf((int) result));
	                       } else {
	                           input.setText(String.valueOf(result));
	                       }
	                   } else {
	                       input.setText("Error: Division by zero");
	                   }
	                   break;
	               case "x":
	                   double res = controller.multiplication(currentResult, y);

	                   if (res % 1 == 0) {
	                       input.setText(String.valueOf((int) res));
	                   } else {
	                       input.setText(String.valueOf(res));
	                   }
	                   break;
	                   case "-":
	                   double r = controller.Subtraction(currentResult,y);
	                   if(r %1 == 0) {
					   		input.setText(String.valueOf((int) r));
					   }
					   else {
						   input.setText(String.valueOf(r));
						   }
						   break;
 					case "+":
	                   double re = controller.Addition(currentResult,y);
	                   if(re %1 == 0) {
					   		input.setText(String.valueOf((int) re));
					   }
					   else {
						   input.setText(String.valueOf(re));
						   }
						   break;


	           }

	           currentResult = 0;
	           inputText.setLength(0);
	           displayNum1.setText("");
	           displayOperation.setText("");
	       } catch (NumberFormatException ex) {
	           input.setText("Invalid Input");
	       }
	   }


     if (source == operations[12]) {
               try {
                double x = controller.invertValue(Double.parseDouble(input.getText()));
                   input.setText(String.valueOf(x));
               } catch (NumberFormatException ex) {
                   input.setText("Invalid Input");
               }
        }


		if(source == memory[0]){
		controller.memoryClear();
		input.setText("0");
}
 if (source == memory[1]) { // MR button
     double recalledValue = controller.memoryRecall();
     inputText = new StringBuilder(String.valueOf(recalledValue));
     input.setText(inputText.toString());
 }


  if (source == memory[2]) { // M+ button
            try {
                double currentValue = parseInput();
                controller.memoryAdd(currentValue);
            } catch (NumberFormatException ex) {
                input.setText("Invalid Input");
            }
        }



	  if (source == memory[3]) { // M- button
	            try {
	                double currentValue = parseInput();
	                controller.memorySubstract(currentValue);
	            } catch (NumberFormatException ex) {
	                input.setText("Invalid Input");
	            }
        }
  if (source == memory[4]) { // MS button
      try {
          double currentValue = parseInput();
          controller.memoryStore(currentValue);
      } catch (NumberFormatException ex) {
          input.setText("Invalid Input");
      }
      inputText.setLength(0);
      input.setText("0");
}

if (source == memory[5]) { // Mshw button

    if (!isMemoryShowing) {
        for (JButton button : numbers) {
            panel.remove(button);
        }
        for (JButton button : operations) {
            panel.remove(button);
        }

      JList<String> memoryList = new JList<>(controller.memoryShow().split("\n"));
        JScrollPane scrollPane = new JScrollPane(memoryList);
        scrollPane.setBounds(5, 200, 300, 150);
        panel.add(scrollPane);
          isMemoryShowing = true;
          if (isMemoryShowing) {
		 memoryList.setFont(new Font("Segoe UI", Font.PLAIN, 16));
}
    } else {

        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JScrollPane) {
                panel.remove(component);
                break;
            }
        }


        for (JButton button : numbers) {
            panel.add(button);
        }
        for (JButton button : operations) {
            panel.add(button);
        }

        isMemoryShowing = false;
    }


    panel.revalidate();
    panel.repaint();
}


}



private double parseInput() {
    String inputString = input.getText();
    return Double.parseDouble(inputString);
}



}
