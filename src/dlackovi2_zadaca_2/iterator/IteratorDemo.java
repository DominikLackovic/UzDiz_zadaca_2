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
public class IteratorDemo
{

    public static void main(String[] args)
    {
        SomeClassWithData some_object = new SomeClassWithData();
        for (int i = 9; i > 0; --i)
        {
            some_object.add(i);
        }
// get_data() has been removed.
// Client has to use Iterator.
        SomeClassWithData.Iterator it1 = some_object.create_iterator();
        SomeClassWithData.Iterator it2 = some_object.create_iterator();
        for (it1.first(); !it1.is_done(); it1.next())
        {
            System.out.print(it1.current_item() + " ");
        }
        System.out.println();
// Two simultaneous iterations
        for (it1.first(), it2.first(); !it1.is_done(); it1.next(), it2.next())
        {
            System.out.print(it1.current_item() + " " + it2.current_item() + " ");

        }
        

        System.out.println();
    }
}
