package com.ubs.opsit.interviews.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExampleTest {

    @Test
    public void thisTestShouldPassIfYouHaveEverythingIsSetupCorrectly() {
        new Example().sayHi();
        assertThat(true, is(true));
    }
}
