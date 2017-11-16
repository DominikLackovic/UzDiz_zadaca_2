/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.iterator;

/**
 *
 * @author foobar
 */
public interface Iterator<E>
{

    Boolean hasNext();

    E next();

    void remove();
}
