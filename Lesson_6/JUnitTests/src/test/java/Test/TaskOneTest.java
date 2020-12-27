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
public class TaskOneTest {

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {new int[]{1, 6, 5, 4, 2, 3, 3}, new int[]{2, 3, 3}},
                    {new int[]{4, 3, 7, 5, 4, 4, 3, 2}, new int[]{3, 2}},
                    {new int[]{4, 3, 7, 5, 4, 4, 3, 2, 7, 9, 1}, new int[]{3, 2, 7, 9, 1}},
                    {new int[]{1, 3, 7, 5, 2, 3, 3, 2, 7, 9, 1}, new int[]{3, 2, 7, 9, 1}}  // Проверка на ошибку.

            });
        }

        private int[] in;
        private int[] out;

        public TaskOneTest(int[] in, int[] out) {
            this.in = in;
            this.out = out;
        }

        private MainApp task1;

        @Before
        public void startTest() {
            task1 = new MainApp();
        }

        @Test
        public void testAfterLastFour() {
            Assert.assertArrayEquals(out, MainApp.AfterLastFour(in));
        }

}


