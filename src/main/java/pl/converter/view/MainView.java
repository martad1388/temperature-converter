package pl.converter.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.converter.constant.Constant;
import pl.converter.conversion.KalvinStrategy;
import pl.converter.conversion.CelsiusStrategy;
import pl.converter.conversion.FahrenheitStrategy;
import pl.converter.conversion.Strategy;


@Route("index")
public class MainView extends VerticalLayout {

    private RadioButtonGroup<String> fromUnit;

    private RadioButtonGroup<String> toUnit;

    private TextField valueField;

    private TextField scoreField;


    public MainView() {
        fromUnit = createRadioButton("From Unit");
        toUnit = createRadioButton("To Unit");

        valueField = new TextField("From Value");
        scoreField = new TextField("Score");
        scoreField.setEnabled(false);

        Button recalculationButton = new Button("Recalculation");
        recalculationButton.addClickListener(p->recalculation());

        add(fromUnit, toUnit, valueField, scoreField, recalculationButton);

    }

    RadioButtonGroup<String> createRadioButton(String label) {
        RadioButtonGroup<String> radioButtonGroup = new RadioButtonGroup<>();
        radioButtonGroup.setItems(Constant.CELSIUS,Constant.FAHRENHEIT,Constant.KALVIN);
        radioButtonGroup.setLabel(label);
        radioButtonGroup.setRequired(true);
        return radioButtonGroup;
    }

    private void recalculation() {
        String fromUnitValue = fromUnit.getValue();
        String toUnitValue = toUnit.getValue();
        String value = valueField.getValue();
        if(fromUnitValue==null || toUnitValue ==null || value==null){
            return;
        }
        Strategy strategy = getStrategy(fromUnitValue);
        String conversedValue = strategy.getConversedValue(toUnitValue, value);
        scoreField.setValue(conversedValue);
    }

    private Strategy getStrategy(String fromUnit){
        Strategy strategy = null;
        switch (fromUnit){
            case Constant.CELSIUS:
                strategy =  new CelsiusStrategy();
                break;
            case Constant.KALVIN:
                strategy =  new KalvinStrategy();
                break;
            case Constant.FAHRENHEIT:
                strategy =  new FahrenheitStrategy();
                break;
        }
        return strategy;
    }

}
