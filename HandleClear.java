import java.awt.event.*;
public class HandleClear extends HandleEvent {
    HandleClear(CalculatorWindows window) {
        super(window);
    }
    public void actionPerformed(ActionEvent e) {
        window.computer.init();
        showMess();
    }
}