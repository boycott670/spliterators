package spliterators;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EnumerateSpliterator<T> implements Spliterator<EnumeratePair<T>> {

    private final Spliterator<T> source;

    public EnumerateSpliterator(Spliterator<T> source) {
        this.source = source;
    }

    @Override
    public boolean tryAdvance(Consumer<? super EnumeratePair<T>> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<EnumeratePair<T>> trySplit() {
        Spliterator<T> splitSource = source.trySplit();
        return splitSource == null ? null : new EnumerateSpliterator<>(splitSource);
    }

    @Override
    public long estimateSize() {
        return source.estimateSize();
    }

    @Override
    public int characteristics() {
        return source.characteristics() | SORTED | NONNULL | DISTINCT | ORDERED;
    }

    @Override
    public Comparator<? super EnumeratePair<T>> getComparator() {
        return null;
    }
}
