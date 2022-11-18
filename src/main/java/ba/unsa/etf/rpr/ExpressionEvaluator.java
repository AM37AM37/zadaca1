package ba.unsa.etf.rpr;


import  java.util.*;

public class ExpressionEvaluator {




    public static double evaluate(String ulaz){


        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();


        for(int i=0;i<ulaz.length();i++) {
            String s = String.valueOf(ulaz.charAt(i));
            /**
             * procita token, pusha ako je operator
             */

            if (s.equals("(") || s.equals(" "));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("s")) {
                ops.push(s);
                i+=3;
            }
            else if (s.equals(")")) {
                /**
                 * pop, podigne i pusha razultal ako je token ")"
                 */
                String op =ops.pop();
                double v=vals.pop();
                if (op.equals("+"))  v=vals.pop()+v;
                else if (op.equals("-"))  v=vals.pop()-v;
                else if (op.equals("*"))  v=vals.pop()*v;
                else if (op.equals("/"))  v=vals.pop()/v;
                else if (op.equals("s"))  v = Math.sqrt(v);

                vals.push(v);
            } else  {
                // ako token nije operator ili zagrada, pushaj double
                double x=Double.parseDouble(s);
                while(s.charAt(0)<58 && s.charAt(0)>47) {
                    s = String.valueOf(ulaz.charAt(i + 1));
                    if (s.charAt(0) < 58 && s.charAt(0) > 47) {
                        i++;
                        x = x * 10 + Double.parseDouble(s);
                    }
                }
                vals.push(x);
            }
        }

        double ret=vals.pop();
        return ret;

    }
}





