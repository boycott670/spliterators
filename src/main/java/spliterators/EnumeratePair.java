package spliterators;

import java.util.Objects;

public class EnumeratePair<T> implements Comparable<EnumeratePair<?>>
{
    private final int index;
    private final T value;

    public EnumeratePair(final int index, final T value)
    {
        this.index = index;
        this.value = value;
    }

    public int getIndex()
    {
        return index;
    }

    public T getValue()
    {
        return value;
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof EnumeratePair<?>))
            return false;

        return Objects.equals(index, ((EnumeratePair<?>)other).getIndex());
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(index);
    }

    @Override
    public int compareTo(EnumeratePair<?> other)
    {
        return Integer.compare(index, other.getIndex());
    }
}
