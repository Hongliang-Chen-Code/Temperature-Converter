package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private TextField textField1; // Right text field
    @FXML
    private TextField textField2; // Middle text field
    @FXML
    private TextField textField3; // Left text field
    @FXML
    private Text text2;  // Operator symbol

    @FXML
    private ComboBox<String> comboBox; // Combo box. Note the type argument String.
    // If you use it like ComboBox comBox1; then the type is Object and you will have
    // to cast it back to String at the line 60

    /**
     * Returns the value according to the selected math operator. updateTextField3
     * method will call this method.
     * @param operator String
     * @param number1 String
     * @param number2 String
     * @return result Double
     */
    public double mathOperation(String operator, String number1, String number2){
        double result;
        // System.out.println(operator); debugging to check operator
        switch (operator){
            case "+":  // Summation
                result = Double.parseDouble(number1) + Double.parseDouble(number2);
                break; // Intellij suggested parseDouble over valueOf
            case "-":  // Subtraction
                result = Double.parseDouble(number1) - Double.parseDouble(number2);
                break;
            case "*":  // Multiplication
                result = Double.parseDouble(number1) * Double.parseDouble(number2);
                break;
            default:
                result = 0;
        }
         return result;
    }
    /**
     * This will update the right text fFiled textField3 with the result. Upon hitting
     * the enter key at textField2 this will be executed.
     */
    @FXML
    public void updateTextField3(){
        String operator = comboBox.getValue(); // Reading the comboBox value
        String number1 = textField1.getText(); // Reading the textField1 value
        String number2 = textField2.getText(); // Reading the textField2 value

        text2.setText(operator);  // Guarantees change to the correct operator between
        // testField1 and textField2
        textField3.setText(String.valueOf(mathOperation(operator, number1, number2)));
    }

    /**
     * This will update the test value in between textField1 and textField2 with
     * the selected operator from the comboBox.
     */
    @FXML
    public void updateText2(){
        text2.setText(comboBox.getValue() );
    }
}
