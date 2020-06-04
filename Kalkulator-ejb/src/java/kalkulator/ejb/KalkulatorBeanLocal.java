/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator.ejb;

import javax.ejb.Local;

/**
 *
 * @author se7en
 */
@Local
public interface KalkulatorBeanLocal {

    public double add(double value2);

    public double subtract(double value2);

    public double multiply(double value2);

    public double divide(double value2);

    public double getValue();

    public void reset();

    public double fill(double value2);
    
}
