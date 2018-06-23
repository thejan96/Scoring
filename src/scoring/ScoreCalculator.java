/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoring;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pulasthi Thejan
 */
public final class ScoreCalculator {

    String word,constants,constants2,constants3,constants4,constants5,constants6,constants7;
    int totalValue = 0, timeCount = 0;
    Map<Character, Integer> lettersMap;
    
    public ScoreCalculator(String input,String constants,int timeCount) {
        lettersMap = new HashMap<>();
        lettersMap.put('A', 1);
        lettersMap.put('B', 3);
        lettersMap.put('C', 3);
        lettersMap.put('D', 2);
        lettersMap.put('E', 1);
        lettersMap.put('F', 4);
        lettersMap.put('G', 2);
        lettersMap.put('H', 4);
        lettersMap.put('I', 1);
        lettersMap.put('J', 8);
        lettersMap.put('K', 5);
        lettersMap.put('L', 1);
        lettersMap.put('M', 3);
        lettersMap.put('N', 1);
        lettersMap.put('O', 1);
        lettersMap.put('P', 3);
        lettersMap.put('Q', 10);
        lettersMap.put('R', 1);
        lettersMap.put('S', 1);
        lettersMap.put('T', 1);
        lettersMap.put('U', 1);
        lettersMap.put('V', 4);
        lettersMap.put('X', 8);
        lettersMap.put('Y', 4);
        lettersMap.put('Z', 10);
        
        word = input;
        this.timeCount = timeCount;
        
        this.constants = constants;     //If contants are on the beggining
        this.constants2= ".*"+constants+".*";     //If constants are somewhere on the word in same order
        this.constants3= ".*"+constants.charAt(0)+".*"+constants.charAt(1)+".*"+constants.charAt(2)+".*|.*"+constants.charAt(0)+".*"+constants.charAt(2)+".*"+constants.charAt(1)+".*|.*"+constants.charAt(1)+".*"+constants.charAt(0)+".*"+constants.charAt(2)+".*|.*"+constants.charAt(1)+".*"+constants.charAt(2)+".*"+constants.charAt(0)+".*|.*"+constants.charAt(2)+".*"+constants.charAt(0)+".*"+constants.charAt(1)+".*|.*"+constants.charAt(2)+".*"+constants.charAt(1)+".*"+constants.charAt(0)+".*";     //If constants are somewhere on the word in any order
        this.constants4 = "^"+constants.charAt(0)+""+constants.charAt(1)+"|^"+constants.charAt(1)+""+constants.charAt(2)+"|^"+constants.charAt(0)+""+constants.charAt(2)+""+"|^"+constants.charAt(1)+""+constants.charAt(0)+"|^"+constants.charAt(2)+""+constants.charAt(1)+"|^"+constants.charAt(2)+""+constants.charAt(0)+"";//If only 2 constants are used on the beggining
        this.constants5 = ".*"+constants.charAt(0)+".*"+constants.charAt(1)+".*|.*"+constants.charAt(1)+".*"+constants.charAt(2)+".*|.*"+constants.charAt(0)+".*"+constants.charAt(2)+".*|.*"+constants.charAt(1)+".*"+constants.charAt(0)+".*|.*"+constants.charAt(2)+".*"+constants.charAt(1)+".*|.*"+constants.charAt(2)+".*"+constants.charAt(0)+".*";//If only 2 constants are used on anywhere
        this.constants6 = "^"+constants.charAt(0)+"|^"+constants.charAt(1)+"|^"+constants.charAt(2)+"";   //If only 1 constants are used on the beggining
        this.constants7 = ".*"+constants.charAt(0)+".*|.*"+constants.charAt(1)+".*|.*"+constants.charAt(2)+".*";  //If only 1 constants are used on anywhere of word
        
        if (!"".equals(word)||this.timeCount>60) {
            this.calculateScore(word);
        }
        
        
    }
       
    public void calculateScore(String word)
    {
        for (int j = 0; j < word.length(); j++) {

            totalValue += lettersMap.get(word.charAt(j));
        }
               
        Pattern p = Pattern.compile(constants);
        Matcher m = p.matcher(word);
        
        Pattern p1 = Pattern.compile(constants2);
        Matcher m1 = p1.matcher(word);
        
        Pattern p2 = Pattern.compile(constants3);
        Matcher m2 = p2.matcher(word);
        
        Pattern p3 = Pattern.compile(constants4);
        Matcher m3 = p3.matcher(word);
        
        Pattern p4 = Pattern.compile(constants5);
        Matcher m4 = p4.matcher(word);
        
        Pattern p5 = Pattern.compile(constants6);
        Matcher m5 = p5.matcher(word);
        
        Pattern p6 = Pattern.compile(constants7);
        Matcher m6 = p6.matcher(word);
        
        
        if (m.lookingAt()) {      //Looking for given 3 constants in the begging of input
            //totalValue +=10;
            totalValue += totalValue *0.8;   //80% BONUS
           // System.out.print("TotalH =" +totalValue);
        }
        else if (m1.find()) {   //If constants are somewhere on the word in same order
            //totalValue *=8;
            totalValue += totalValue *0.6; //60% BONUS
            //System.out.print("Total'HEL'=" +totalValue);
        }
        else if (m2.find()) {   //If constants are somewhere on the word in any order
            //totalValue *=6;
            totalValue += totalValue *0.5; //50% BONUS
            //System.out.print("Total'**HEL**' =" +totalValue);
        }
        else if (m3.find()) {   //If only 2 constants are used on the beggining
            //totalValue *=5;
            totalValue += totalValue *0.4; //40% BONUS
            //System.out.print("Total'EHL*' =" +totalValue);
        }
        else if (m4.find()) {   //If only 2 constants are used on anywhere
            //totalValue *=4;
            totalValue += totalValue *0.3; //30% BONUS
            //System.out.print("Total''EH'' =" +totalValue);
        }
        else if (m5.find()) {   //If only 1 constants are used on the beggining
            //totalValue *=3;
            totalValue += totalValue *0.2; //20% BONUS
            //System.out.print("Total'***HE**' =" +totalValue);
        }
         else if (m6.find()) {   //If only 1 constants are used on anywhere of word
            //totalValue *=2;
            totalValue += totalValue *0.1; //10% BONUS
           //System.out.print("Total''*L**H**E*'' =" +totalValue);
        }
        
        System.out.print(word.length());
        switch(word.length()){
            case 11:
               totalValue +=10;
               //System.out.print("Total CASE11 =" +totalValue);
                break;
            case 10:
                totalValue +=9;
                //System.out.print("Total CASE10 =" +totalValue);
                break;
            case 9:
                totalValue +=8;
                //System.out.print("Total CASE9 =" +totalValue);
                break;
            case 8:
                totalValue +=7;
                //System.out.print("Total CASE8 =" +totalValue);
                break;
            case 7:
                totalValue *=6;
                //System.out.print("Total CASE7 =" +totalValue);
                break;
            case 6:
                totalValue +=5;
                //System.out.print("Total CASE6 =" +totalValue);
                break;
            case 5:
                totalValue +=4;
                //System.out.print("Total CASE5 =" +totalValue);
                break;
            case 4:
                totalValue +=3;
                //System.out.print("Total CASE4 =" +totalValue);
                break;
            case 3:
               totalValue +=2;
               //System.out.print("Total CASE3 =" +totalValue);
                break;
            case 2:
                totalValue +=1;
                //System.out.print("Total CASE2 =" +totalValue);
                break;
            default:
                break;
        }
        
        if (timeCount<15) {
             totalValue +=8;
             //System.out.print("Total<15 =" +totalValue);
            
        }
        else if (timeCount<30) {
             totalValue +=5;
             //System.out.print("Total<30 =" +totalValue);
        }
        else if (timeCount<45) {
             totalValue +=3;
             //System.out.print("Total<45 =" +totalValue);
        }
 
            
        
        
       System.out.print("Total SCORE =" +totalValue);
        //return totalValue;
    }
    
    
}
