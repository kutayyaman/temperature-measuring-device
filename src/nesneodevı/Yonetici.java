/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodevı;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kutay
 */
public class Yonetici implements ISubject{
    private List<IObserver> subscribers=new ArrayList<IObserver>();
    
    @Override
    public void attach(IObserver o) {
        subscribers.add(o);
    }

    @Override
    public void detach(IObserver o) {
        subscribers.remove(o);
    }

    @Override
    public void notify(String m) {
        for(IObserver observer:subscribers){
            observer.update(m);
        }
    }
    
}
