package by.ita.je;

import org.junit.Assert;
import org.junit.Test;

public class testForFirstService {
    @Test
    public void testMethod(){
        FirstService object=new FirstService();
        String excpected="testik";
        String actual=object.sayMe("testik");
        Assert.assertEquals(excpected,actual);
    }
}
