package social.media.platform.users;

@FunctionalInterface
public interface CustomFunction<T, R> {
    R apply(T t);
}

