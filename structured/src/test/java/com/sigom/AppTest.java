package com.sigom;

import com.sigom.Trees.ITree;
import com.sigom.Trees.TreeImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testTreeNotNull(){
        ITree t = new TreeImpl();
        int[] values = new int[]{1,2,3,4,5,6,7};
        t.insertKeys(values);
        assertNotNull(t);
        assertEquals(2, t.findLCA(4, 5).key);
    }

}
