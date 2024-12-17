package social.media.platform.users;

import java.util.List;

@FunctionalInterface
public interface Sorter<T> {
    List<T> sort(List<T> items);
}

