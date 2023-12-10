import javax.swing.JButton;
import java.awt.event.*;
public class HandleDight extends HandleEvent {
    HandleDight(CalculatorWindows window) {
        super(window);
    }
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        String buttomName = b.getText().trim();
        char digit = buttomName.charAt(0);
        window.computer.setDataItem(digit);
        showMess();
        if (digit == '.') {
            String s = get(window.computer.computerDataItem());
            window.showDataItem.setText(" " + s + ".");
        }
    }
}