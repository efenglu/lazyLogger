# Lazy Logger
Evaluate Log Statement only when the logger is enabled.

Usage:
```java
log.debug("I found {} and {}", LazyString.lazy(this::getone), LazyString.lazy(this::gettwo));
```
