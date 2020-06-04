/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator.ejb;

import javax.ejb.Stateful;

/**
 *
 * @author se7en
 */
@Stateful
public class KalkulatorBean implements KalkulatorBeanLocal {
    private double value = 0;
    
    @Override
    public double fill(double value2){
        value = value2;
        return value;
    }
    @Override
    public double add(double value2) {
        value += value2;
        return value;
    }
    @Override
    public double subtract(double value2) {
        value -= value2;
        return value;
    }
    @Override
    public double multiply(double value2) {
        value *= value2;
        return value;
    }
    @Override
    public double divide(double value2) {
        value /= value2;
        return value;
    }
    @Override
    public double getValue(){
        return value;
    }
    @Override
    public void reset(){
        value = 0;
    }
}
