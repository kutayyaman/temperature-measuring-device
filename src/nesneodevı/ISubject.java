/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodevı;

/**
 *
 * @author kutay
 */
public interface ISubject {
    void attach(IObserver o);
    void detach(IObserver o);
    void notify(String m);
}
