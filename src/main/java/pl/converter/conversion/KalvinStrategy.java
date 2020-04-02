package pl.converter.conversion;

import pl.converter.constant.Constant;

public class KalvinStrategy implements Strategy {
    @Override
    public String getConversedValue(String unit, String valueString) {
        String scoreString = "NULL";
        double value = Double.valueOf(valueString);
        Double score = null;
        switch (unit){
            case Constant.CELSIUS:
                score = value - 273.15 ;
                break;
            case Constant.KALVIN:
                scoreString = valueString;
                break;
            case Constant.FAHRENHEIT:
                score = (value*1.8)-459.67;
                break;
        }
        if(score!=null){
            scoreString = String.valueOf(score);
        }
        return scoreString;
    }

}
