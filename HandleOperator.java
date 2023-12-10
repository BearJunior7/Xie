import javax.swing.JButton;
import java.awt.event.*;
public class HandleOperator extends HandleEvent {
    HandleOperator (CalculatorWindows window) {
        super (window) ;
    }
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        String buttonName = b.getText().trim();
        char operator = buttonName.charAt(0);
        window.computer.setOperator(operator);
        showMess();
    }
}