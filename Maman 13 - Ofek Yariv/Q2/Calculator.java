package application;

import java.util.*;


public class Calculator {
	public double result;
	public boolean status; 
    private ArrayList<Object> list; 
    private String evaluation; 

    public Calculator(){
        list = new ArrayList<Object>();
        evaluation ="";
    }

    // make array of numbers and action, then solve
    public void equation(String equation) throws Errors{
        list = new ArrayList<Object>();
        evaluation = equation;
        status = false;
        makeArray();
        System.out.printf("%s%n",list.toString());
        Calculate();
    }

    // make array of numbers and actions
    public void makeArray() throws RuntimeException{
        int start = 0,end;
        char c;
        int i=0,sign=1;
        while (i<evaluation.length()){
            c = evaluation.charAt(i);
            if (c == '('){
                sign = sign*-1;
                i += 5;
                start = i;
                continue;
            }
            if ((c>='0' && c<='9') || c=='.')
            {
                i+=1;
                continue;
            }
            if (c == '+' || c == '-' || c == '*' || c== '/'){
                end = i;
                String numberSt = evaluation.substring(start,end);
                double number = Double.parseDouble(numberSt);
                number = number * sign;
                list.add(number);
                list.add(c);
                i+=1;
                sign=1;
                start = i;
                continue;
            }
            throw new RuntimeException();
        }
        end = i;
        String numberSt = evaluation.substring(start,end);
        double number = Double.parseDouble(numberSt);
        number = number * sign;
        list.add(number);
    }

    // calculate the equation
    public void Calculate() throws Errors{
        Double first = null,second = null;
        char action = ' ';
        Object object;
        for (int i=0;i<list.size();i++){
            object = list.get(i);
            if (object instanceof Double){
                if (first == null)
                {
                    first = (double)(object);
                }
                else
                {
                    second = (double)(object);
                    switch (action){
                        case '+':
                            first = first + second;
                            break;
                        case '/':
                            if (second != 0){
                                first = first/second;
                            }
                            else
                                throw new Errors("diviation by zero");
                            break;
                        case '*':
                            first = first *second;
                            break;
                        case '-':
                            first = first -second;
                            break;
                        default:
                            throw new Errors("Unknown function");
                    }
                }
            }
            else if (object instanceof Character){
                action = (char)(object);
            }
        }
        System.out.printf("%f%n",first);
        result = first;
        status = true;
    }
}
