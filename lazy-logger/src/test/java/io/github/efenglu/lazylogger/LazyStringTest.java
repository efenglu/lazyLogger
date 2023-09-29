package io.github.efenglu.lazylogger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.efenglu.lazylogger.LazyString.lazy;

public class LazyStringTest {
    private static final Logger log = LoggerFactory.getLogger(LazyStringTest.class);

    private int calls2;

    private int calls1;

    @Before
    public void setup() {
        calls1 = 0;
        calls2 = 0;
    }

    @Test
    public void testLog() {
        log.debug("I found {} and {}", getone(), gettwo());

        Assert.assertEquals(1, calls1);
        Assert.assertEquals(1, calls2);
    }

    @Test
    public void testLogLazyEnabled() {
        if (log.isDebugEnabled()) {
            log.debug("I found {} and {}", getone(), gettwo());
        }

        Assert.assertEquals(0, calls1);
        Assert.assertEquals(0, calls2);
    }

    @Test
    public void testLogLazySupplier() {
        log.debug("I found {} and {}", lazy(this::getone), lazy(this::gettwo));

        Assert.assertEquals(0, calls1);
        Assert.assertEquals(0, calls2);
    }

    @Test
    public void testLogOn() {
        log.error("I found {} and {}", getone(), gettwo());

        Assert.assertEquals(1, calls1);
        Assert.assertEquals(1, calls2);
    }

    @Test
    public void testLogLazyEnabledOn() {
        if (log.isErrorEnabled()) {
            log.error("I found {} and {}", getone(), gettwo());
        }

        Assert.assertEquals(1, calls1);
        Assert.assertEquals(1, calls2);
    }

    @Test
    public void testLogLazySupplierOn() {
        log.error("I found {} and {}", lazy(this::getone), lazy(this::gettwo));

        Assert.assertEquals(1, calls1);
        Assert.assertEquals(1, calls2);
    }

    private Object gettwo() {
        calls2++;
        return 2;
    }

    private Object getone() {
        calls1++;
        return 1;
    }

}