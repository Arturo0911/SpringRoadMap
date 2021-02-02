package com.example.springclient.properties;

import java.util.ArrayList;
import java.util.Arrays;

public class Credentials {

    public boolean verifyCredential(String credential){

        try{

            String[] digits = credential.split("");
            ArrayList<String>vector = new ArrayList<>(Arrays.asList(digits[1],digits[2],
                    digits[3],digits[4],digits[5],digits[6],digits[7],digits[8],digits[9],digits[10]));



            int thirdDigit = Integer.parseInt(vector.get(2));
            int verifyDigit = Integer.parseInt(vector.get(9));
            int size = vector.size();
            int sum = 0;
            if (size == 10 &&  thirdDigit< 6){

                for(int x= 0; x < size - 1; x++ ) {

                    if (x%2 == 0){
                        if (Integer.parseInt(vector.get(x))*2 >= 10 ){
                            sum +=  Integer.parseInt(vector.get(x))*2 - 9;
                        }else{
                            sum += Integer.parseInt(vector.get(x)) * 2;
                        }
                    }else{
                        sum += Integer.parseInt(vector.get(x));
                    }
                }

                int lastDigit = sum%10;

                return 10 - lastDigit == verifyDigit;

            }else {
                return false;
            }




        }catch (Exception e){
            e.printStackTrace();
            return false;
        }



    }



}
