package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    List<String> longString=new ArrayList<>();
    String operator="";
    boolean gt=false;
    List<Float> gtList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        TextView shortTXT=findViewById(R.id.shortTXT);
        TextView longTXT=findViewById(R.id.longTXT);

        DecimalFormatSymbols decimalFormatSymbols=new DecimalFormatSymbols(Locale.US);
        DecimalFormat df=new DecimalFormat("#.##",decimalFormatSymbols);

        String text=((TextView) view).getText().toString();

        if (checkChar(text).equals("number")){
            if (operator.equals("=")){
                longString=new ArrayList<>();
                operator="";
            }
            if (longString.size()>0){
             String lastItemOfList=longString.get(longString.size()-1);
             String lastCharOfThisItem=lastItemOfList.substring(lastItemOfList.length()-1);//last chracter of last item
                if (checkChar(lastCharOfThisItem).equals("number")){//if last item is number
                    if (!text.equals(".") || !lastItemOfList.contains(".")){//if press . check its first time, one . in number
                        longString.remove(longString.size()-1);//remove last item
                        longString.add(lastItemOfList+text);//append text end of item
                    }
                }else{
                    if (text.equals(".")){text="0.";}
                    longString.add(text);
                }
            }else {
                if (text.equals(".")){text="0.";}
                longString.add(text);
            }
            shortTXT.setText(longString.get(longString.size()-1));//last item of list
        }else if (checkChar(text).equals("operator")){
            operator=text;
            if (longString.size()>0){
                String lastItem=longString.get(longString.size()-1);
                if (checkChar(lastItem).equals("operator")){
                    longString.remove(longString.size()-1);//remove last item
                }
                longString.add(operator);
            }


            longTXT.setText("");
            for(int i=0;i<longString.size();i++){
                String ltxt=longTXT.getText()+longString.get(i);
                longTXT.setText(ltxt);
            }
        }else if (text.equals("=")){
            operator="=";
            int i=0;
            while(longString.size()>1){
                if (checkChar(longString.get(i)).equals("operator")){
                    float preNumber=Float.parseFloat(longString.get(i-1));
                    float postNumber=Float.parseFloat(longString.get(i+1));
                    float newFloat=calculate(longString.get(i),preNumber,postNumber);
                    longString.set(i-1,df.format(newFloat));
                    longString.remove(i);
                    longString.remove(i);
                }else{
                    i++;
                }
            }
            String ltxt=longTXT.getText().toString()+shortTXT.getText().toString()+operator;
            longTXT.setText(ltxt);
            shortTXT.setText(longString.get(0));
            if (gt){
                gtList.add(Float.parseFloat(longString.get(0)));
            }
        }else if (text.equals("C")){
            longString=new ArrayList<>();
            shortTXT.setText("");
            longTXT.setText("");
            operator="";
        }else if (text.equals("+-")){
            if (longString.size()>0){
                String lastItem=longString.get(longString.size()-1);
                String lastChar=lastItem.substring(lastItem.length()-1);
                if (checkChar(lastChar).equals("number")){
                    float f=Float.parseFloat(lastItem)*-1;
                    longString.set(longString.size()-1,df.format(f));
                }
                shortTXT.setText(longString.get(longString.size()-1));
            }
        }else if (text.equals("GT")){
            if (!gt){
                view.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.operator,null));
                gt=true;
            }else {
                float sum=0;
                StringBuilder s=new StringBuilder();
                for (int i=0;i<gtList.size();i++){
                    if (i>0){
                        s.append("+");
                    }
                    s.append(df.format(gtList.get(i)));
                    if (i==gtList.size()-1){
                        s.append("=");
                    }
                    sum +=gtList.get(i);
                }
                shortTXT.setText(df.format(sum));
                longTXT.setText(s);
                view.setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.number,null));
                gt=false;
            }
        }
    }

    private float calculate(String operator, float preNumber, float postNumber) {
        float sum=0;
        switch (operator){
            case "+":
                sum=preNumber+postNumber;
                break;
            case "-":
                sum=preNumber-postNumber;
                break;
            case "*":
                sum=preNumber*postNumber;
                break;
            case "/":
                if (preNumber!=0)
                    sum=preNumber/postNumber;
                break;
            case "%":
                sum=preNumber%postNumber;
                break;
        }
        return sum;
    }


    private String checkChar(String s){
        String result="";
        switch (s){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":
                result="number";
                break;
            case "+":
            case "-":
            case "%":
            case "/":
            case "*":
                result="operator";
                break;


        }
        return result;
    }
}