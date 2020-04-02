package pl.converter.conversion;

import pl.converter.constant.Constant;

public class FahrenheitStrategy  implements Strategy{
    @Override
    public String getConversedValue(String unit, String valueString) {
        String scoreString = "NULL";
        double value = Double.valueOf(valueString);
        Double score = null;
        switch (unit){
            case Constant.CELSIUS:
                score = (value-32)/1.8;
                break;
            case Constant.KALVIN:
                score = (value+459.67)*(5/9);
                break;
            case Constant.FAHRENHEIT:
                scoreString = valueString;
                break;
        }
        if(score!=null){
            scoreString = String.valueOf(score);
        }

        return scoreString;
    }
}
