package util;


import java.util.OptionalDouble;

public class BMI {

//Konstruktor
  public BMI() { }

    public double BMIValue;
    public static Double high;
    public static Double low;
    private static final String[] bmiCategories = {
          "Underweight",
          "Healthy Weight",
          "Overweight",
          "Obese",
  };


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

    public static void Rating(Double low, Double high) {
      BMI.low =low;
      BMI.high = high;
    }


    public static String[] getBmiCategories() {return bmiCategories;}
  //public String getBmiCategories() {return  bmiCategories[OrdinalBuilder]};


  public static Double getHigh() {
    return high;
  }

  public static Double getLow() {
    return low;
  }


}
