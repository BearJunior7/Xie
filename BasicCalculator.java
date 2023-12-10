import java.util.*;

public class BasicCalculator {
    public double result;
    public Stack<Character> dataItem;
    public Stack<Double> tempResult;
    public Stack<Character> operator;
    public int SCALE = 10;

    public BasicCalculator() {
        init();
    }

    public void init() {
        dataItem = new Stack<Character>();
        tempResult = new Stack<Double>();
        dataItem.push('0');
        operator = new Stack<Character>();
    }

    public void setDataItem(char c) {
        if (c != '.')
            dataItem.push(c);
        else {
            if (!dataItem.contains('.'))
                dataItem.push(c);
        }
    }

    public void setOperator(char p) {
        if (dataItem.empty()) {
            operator.clear();
            operator.push(p);
            return;
        }
        if (operator.empty()) {
            operator.push(p);
            double m = computerDataItem();
            dataItem.removeAllElements();
            tempResult.push(m);
        } else {
            double mData = computerDataItem();
            dataItem.removeAllElements();
            char yuansuan = operator.pop();
            double rTemp = tempResult.pop();
            if (yuansuan == '+')
                rTemp = rTemp + mData;
            else if (yuansuan == '-')
                rTemp = rTemp - mData;
            else if (yuansuan == '/')
                rTemp = rTemp / mData;
            else if (yuansuan == '*')
                rTemp = rTemp * mData;
            tempResult.push(rTemp);
            operator.push(p);
        }
    }

    public char getOperator() {
        if (operator.empty()) {
            return '\0';
        }
        return operator.peek();
    }

    public void backspace() {
        if (dataItem.size() >= 1) {
            dataItem.pop();
        }
    }

    public void initDataItemByMath(PrimerCalculator computer) {
        computer.handle(this);
    }

    public double getResult() {
        double endItem = 0;
        if (dataItem.empty()) {
            if (!tempResult.empty()) {
                endItem = tempResult.peek();
            }
        } else {
            endItem = computerDataItem();
        }

        if (operator.empty()) {
            result = endItem;
            return result;
        }
        char yunsuan = operator.peek();
        if ((yunsuan == '+') && (!tempResult.empty())) {
            result = tempResult.peek() + endItem;
        } else if (yunsuan == '-') {
            result = tempResult.peek() - endItem;
        }else if (yunsuan == '*') {
            result = tempResult.peek() * endItem;
        }else if (yunsuan == '/') {
            result = tempResult.peek() / endItem;
        }
        return result;
    }

    public double getTempResult() {
        double r = 0;
        if(tempResult.empty()) {
            r = computerDataItem();
        }else {
            r = tempResult.peek();
        }
        return r;
    }

    public double computerDataItem() {
        if(dataItem.empty()&&!tempResult.empty()) {
            return tempResult.peek();
        }
        StringBuffer str = new StringBuffer();
        double doubleData = 0;
        for(int i = 0;i < dataItem.size(); i++) {
            str.append(dataItem.get(i));
        }
        try {
            doubleData = Double.parseDouble(str.toString());
        }catch(NumberFormatException e){
            doubleData = 0;
        }
        return doubleData;
    }
}