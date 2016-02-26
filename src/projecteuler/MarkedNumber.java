/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler;

/**
 *
 * @author max
 */
public class MarkedNumber {
    
    private Long storedNumber;
    private Boolean marked;
    
    public MarkedNumber(Long aNumber, Boolean aBoolean)
    {
        storedNumber = aNumber;
        marked = aBoolean;
    }
    
    public Long getNumber()
    {
        return storedNumber;
    }
    
    public Boolean getMarked()
    {
       return marked;
    }
    
    public void setNumber(Long aNumber)
    {
        storedNumber = aNumber;
    }
    
    public void setMarked(Boolean aBoolean)
    {
        marked = aBoolean;
    }

    @Override
    public String toString() 
    {
        return storedNumber.toString();
    }

    
}
