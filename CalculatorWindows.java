import java.awt.*;
import javax.swing.*;

public class CalculatorWindows extends JFrame {
    BasicCalculator computer;
    JButton numberButton[];
    JButton operatorButton[];
    JButton back, equation, clear;
    JTextField resultShow;
    JTextField showTempResult;
    JLabel showOperator;
    JTextField showDataItem;
    JTextArea saveComputerProcess;

    public CalculatorWindows() {
        computer = new BasicCalculator();
        initView();
        initActionListener();
    }


    public void initView() {
        setTitle("计算器");
        JPanel panelLeft, panelRight;
        resultShow = new JTextField(10);
        resultShow.setHorizontalAlignment(JTextField.LEFT);
        resultShow.setForeground(Color.PINK);
        resultShow.setFont(new Font("TimesRoman", Font.BOLD, 14));
        resultShow.setEditable(false);
        resultShow.setBackground(Color.PINK);
        showTempResult = new JTextField();
        showTempResult.setHorizontalAlignment(JTextField.RIGHT);
        showTempResult.setFont(new Font("Arial", Font.BOLD, 14));
        showTempResult.setBackground(Color.PINK);
        showTempResult.setEditable(false);
        showOperator = new JLabel();
        showOperator.setBackground(Color.PINK);
        showOperator.setFont(new Font("Arial", Font.BOLD, 18));
        showOperator.setHorizontalAlignment(JTextField.CENTER);
        showDataItem = new JTextField();
        showDataItem.setBackground(Color.white);
        showDataItem.setHorizontalAlignment(JTextField.LEFT);
        showDataItem.setFont(new Font("Arial", Font.BOLD, 14));
        showDataItem.setEditable(false);
        saveComputerProcess = new JTextArea();
        saveComputerProcess.setEditable(false);
        saveComputerProcess.setFont(new Font("宋体", Font.PLAIN, 14));
        numberButton = new JButton[10];
        numberButton[0] = new JButton("0");
        numberButton[0].setFont(new Font("Arial", Font.BOLD, 20));
        numberButton[1] = new JButton("1");
        numberButton[1].setFont(new Font("Arial", Font.BOLD, 20));
        numberButton[2] = new JButton("2");
        numberButton[2].setFont(new Font("Arial", Font.BOLD, 20));
        numberButton[3] = new JButton("3");
        numberButton[3].setFont(new Font("Arial", Font.BOLD, 20));
        numberButton[4] = new JButton("4");
        numberButton[4].setFont(new Font("Arial", Font.BOLD, 20));
        numberButton[5] = new JButton("5");
        numberButton[5].setFont(new Font("Arial", Font.BOLD, 20));
        numberButton[6] = new JButton("6");
        numberButton[6].setFont(new Font("Arial", Font.BOLD, 20));
        numberButton[7] = new JButton("7");
        numberButton[7].setFont(new Font("Arial", Font.BOLD, 20));
        numberButton[8] = new JButton("8");
        numberButton[8].setFont(new Font("Arial", Font.BOLD, 20));
        numberButton[9] = new JButton("9");
        numberButton[9].setFont(new Font("Arial", Font.BOLD, 20));
        operatorButton = new JButton[4];
        operatorButton[0] = new JButton("+");
        operatorButton[0].setFont(new Font("Arial", Font.BOLD, 20));
        operatorButton[1] = new JButton("-");
        operatorButton[1].setFont(new Font("Arial", Font.BOLD, 20));
        operatorButton[2] = new JButton("*");
        operatorButton[2].setFont(new Font("Arial", Font.BOLD, 20));
        operatorButton[3] = new JButton("/");
        operatorButton[3].setFont(new Font("Arial", Font.BOLD, 20));
        back = new JButton("退格");
        equation = new JButton("=");
        clear = new JButton("c");
        panelLeft = new JPanel();
        panelRight = new JPanel();
        panelLeft.setLayout(new BorderLayout());
        JPanel centerInLeft = new JPanel();
        Box boxH = Box.createHorizontalBox();
        boxH.add(showTempResult);
        boxH.add(showOperator);
        boxH.add(showDataItem);
        panelLeft.add(boxH, BorderLayout.NORTH);
        panelLeft.add(centerInLeft, BorderLayout.CENTER);
        centerInLeft.setLayout(new GridLayout(5, 5));
        centerInLeft.add(numberButton[1]);
        centerInLeft.add(numberButton[2]);
        centerInLeft.add(numberButton[3]);
        centerInLeft.add(operatorButton[0]);
        centerInLeft.add(back);
        centerInLeft.add(numberButton[4]);
        centerInLeft.add(numberButton[5]);
        centerInLeft.add(numberButton[6]);
        centerInLeft.add(operatorButton[1]);
        centerInLeft.add(clear);
        centerInLeft.add(numberButton[7]);
        centerInLeft.add(numberButton[8]);
        centerInLeft.add(numberButton[9]);
        centerInLeft.add(operatorButton[2]);
        centerInLeft.add(operatorButton[3]);

        centerInLeft.add(numberButton[0]);
        centerInLeft.add(new JLabel());
        centerInLeft.add(new JLabel());
        centerInLeft.add(new JLabel());
        centerInLeft.add(new JLabel());
        centerInLeft.add(equation);
        panelRight.setLayout(new BorderLayout());
        panelRight.add(resultShow, BorderLayout.NORTH);
        panelRight.add(new JScrollPane(saveComputerProcess), BorderLayout.CENTER);
        JPanel southInPanelRight = new JPanel();
        panelRight.add(southInPanelRight, BorderLayout.SOUTH);
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelLeft, panelRight);
        add(split, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(100, 50, 888, 258);
        validate();
    }

    private void initActionListener() {
        HandleDight handleDigit = new HandleDight(this);
        for (int i = 0; i <= 9; i++) {
            numberButton[i].addActionListener(handleDigit);
        }
        HandleOperator handleOperator = new HandleOperator(this);
        for (int i = 0; i < 4; i++) {
            operatorButton[i].addActionListener(handleOperator);
        }
        back.addActionListener(new HandleBack(this));
        equation.addActionListener(new HandleEquation(this));
        clear.addActionListener(new HandleClear(this));
    }
}