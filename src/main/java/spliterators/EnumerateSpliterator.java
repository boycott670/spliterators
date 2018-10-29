package spliterators;

import java.util.Spliterator;
import java.util.function.Consumer;

public class EnumerateSpliterator<T> implements Spliterator<EnumeratePair<T>> {

    private final Spliterator<T> source;
    private int current;

    public EnumerateSpliterator(Spliterator<T> source) {
        this.source = source;
        current = 0;
    }

    @Override
    public boolean tryAdvance(Consumer<? super EnumeratePair<T>> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<EnumeratePair<T>> trySplit() {
        Spliterator<T> splitSource = source.trySplit();
        return splitSource == null ? null : new EnumerateSpliterator<T>(splitSource);
    }

    @Override
    public long estimateSize() {
        return source.estimateSize();
    }

    @Override
    public int characteristics() {
        return source.characteristics() | SORTED | NONNULL | DISTINCT;
    }
}
