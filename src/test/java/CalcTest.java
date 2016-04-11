import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Dag Østgulen Heradstveit.
 */
@RunWith(JUnit4.class)
public class CalcTest {

    @Test
    public void calc() throws Exception {
        int mid = new Calc().calc(0, 100);
        assertThat("Mid Should be 50", mid, is(50));
    }
}
