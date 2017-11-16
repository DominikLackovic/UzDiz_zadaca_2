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
public class NameRepository implements Container
{

    public String names[] =
    {
        "Robert", "John", "Julie", "Lora"
    };

    @Override
    public Iterator1 getIterator()
    {
        return new NameIterator();

    }

    private class NameIterator implements Iterator1
    {

        int index;

        @Override
        public boolean hasNext()
        {
            if (index < names.length)
            {
                return true;
            }
            return false;
        }

        @Override
        public Object next()
        {
            if (this.hasNext())
            {
                return names[index++];
            }
            return null;
        }
    }
}