package social.media.platform.users;

@FunctionalInterface
public interface Transformer<T, R> {
    R transform(T t);
}

