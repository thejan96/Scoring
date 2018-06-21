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

    String word,constants,constants2,constants3,constants4,constants5;
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
        this.constants3= ".*"+constants.charAt(0)+".*"+constants.charAt(1)+".*"+constants.charAt(2)+".*";     //If constants are somewhere on the word in any order
        this.constants4= ""+constants.charAt(0)+""+constants.charAt(1)+"|"+constants.charAt(1)+""+constants.charAt(2)+"|"+constants.charAt(0)+""+constants.charAt(2)+"";    //If only 2 constants are used on the beggining
        this.constants5 = ".*"+constants.charAt(0)+".*"+constants.charAt(1)+".*|.*"+constants.charAt(1)+".*"+constants.charAt(2)+".*|.*"+constants.charAt(0)+".*"+constants.charAt(2)+".*"; //If only 2 constants are used on anywhere
        
        
        //System.out.print(constants5);
        this.calculateScore(word);
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
        
        
        if (m.lookingAt()) {      //Looking for given 3 constants in the begging of input
            System.out.print("done");
        }
        else if (m1.find()) {   //If constants are somewhere on the word in same order
            System.out.print("**done2**");
        }
        else if (m2.find()) {   //If constants are somewhere on the word in any order
            System.out.print("----done3----");
        }
        else if (m3.find()) {   //If only 2 constants are used on the beggining
            System.out.print("//// Done 4 /////");
        }
        else if (m4.find()) {   //If only 2 constants are used on anywhere
            System.out.print("&&& Done 5 &&&&");
        }
            
        
        System.out.print(totalValue);
        //return totalValue;
    }
    
    
}
