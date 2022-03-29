package util;

import java.util.ArrayList;

public class BMI {

//Konstruktor
  public BMI() { }

    public double BMIValue;


    public double compute(double height, double weight) {
        BMIValue = weight / (height * height)*10000;
        return BMIValue;
    }

    public String BMICategory(double BMIValue) {
      if (BMIValue < 18.5){
        return "Underweight";
      }
      else if (BMIValue >= 18.5 && BMIValue<=24.9){
        return "Healthy Weight";
      }
      else if (BMIValue >=25 && BMIValue<=29.9){
        return "Overweight";
      }
      else return "Obese";
    }



    //String[] bmiList = new ArrayList<>


}
