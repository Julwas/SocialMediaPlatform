package social.media.platform.users;

@FunctionalInterface
public interface Counter<T> {
    long count(T t);
}

