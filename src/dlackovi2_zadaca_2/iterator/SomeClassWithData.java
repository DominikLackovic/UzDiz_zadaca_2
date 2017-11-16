/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dlackovi2_zadaca_2.iterator;

import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 *
 * @author foobar
 */
public class SomeClassWithData
{

    private TreeSet<Integer> m_data = new TreeSet<Integer>();

    public class Iterator
    {

        private SomeClassWithData m_collection;
        private java.util.Iterator m_it;
        private int m_current;

        public Iterator(SomeClassWithData in)
        {
            m_collection = in;
        }

        public void first()
        {
            m_it = m_collection.m_data.iterator();
            next();
        }

        public void next()
        {
            try
            {
                m_current = (int) m_it.next();
            }
            catch (NoSuchElementException ex)
            {
                m_current = - 999;
            }
        }

        public boolean is_done()
        {
            return m_current == - 999;
        }

        public int current_item()
        {
            return m_current;
        }
    }

    public void add(int in)
    {
        m_data.add(in);
    }

    public Iterator create_iterator()
    {
        return new Iterator(this);
    }
}
