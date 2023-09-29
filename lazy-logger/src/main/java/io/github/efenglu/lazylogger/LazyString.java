package io.github.efenglu.lazylogger;

import java.util.function.Supplier;

public class LazyString {
    private final Supplier<?> stringSupplier;

    public static LazyString lazy(Supplier<?> stringSupplier) {
        return new LazyString(stringSupplier);
    }

    public LazyString(final Supplier<?> stringSupplier) {
        this.stringSupplier = stringSupplier;
    }

    @Override
    public String toString() {
        return String.valueOf(stringSupplier.get());
    }
}
