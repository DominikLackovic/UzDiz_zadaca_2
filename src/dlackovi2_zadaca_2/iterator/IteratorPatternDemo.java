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
public class IteratorPatternDemo
{

    public static void main(String[] args)
    {
        NameRepository namesRepository = new NameRepository();
        for (Iterator iter = namesRepository.getIterator(); iter.hasNext();)
        {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }
}
