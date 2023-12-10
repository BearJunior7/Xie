import java.awt.event.*;
public class HandleBack extends HandleEvent {
    HandleBack(CalculatorWindows window) {
        super(window);
    }
    public void actionPerformed(ActionEvent e) {
        window.computer.backspace();
        showMess();
    }
}