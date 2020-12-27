package Test;

import example.MainApp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TaskTwoTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 4, 4, 1, 4, 1}, true},
                {new int[]{8, 8, 7, 7, 7, 3, 5, 1}, false},
                {new int[]{4, 4, 4, 4, 1, 1, 1, 1}, false},   // Проверка на ошибку.
                {new int[]{1, 4, 8, 7}, false}
        });
    }

    private int[] in;
    private boolean out;

    public TaskTwoTest(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private MainApp task2;

    @Before
    public void startTest() {
        task2 = new MainApp();
    }

    @Test
    public void OnlyOneAndFour() {
        Assert.assertEquals(MainApp.OnlyOneAndFour(in), out);
    }

}
