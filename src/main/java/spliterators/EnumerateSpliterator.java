package spliterators;

import java.util.Spliterator;
import java.util.function.Consumer;

public final class EnumerateSpliterator<T> implements Spliterator<EnumeratePair<T>>
{
    private final Spliterator<T> source;

    public EnumerateSpliterator(Spliterator<T> source)
    {
        this.source = source;
    }

    @Override
    public boolean tryAdvance(Consumer<? super EnumeratePair<T>> consumer)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<EnumeratePair<T>> trySplit()
    {
        final Spliterator<T> subSpliterator = source.trySplit();

        if (subSpliterator != null)
            return new EnumerateSpliterator<>(subSpliterator);

        return null;
    }

    @Override
    public long estimateSize()
    {
        return source.estimateSize();
    }

    @Override
    public int characteristics()
    {
        return source.characteristics() | DISTINCT | NONNULL | SORTED;
    }
}
