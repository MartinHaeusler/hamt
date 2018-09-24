package org.neatutils.collections.util;

import java.util.Map;
import java.util.Map.Entry;

public class Pair<A, B> implements Map.Entry<A, B>{

    public static <A, B> Pair<A, B> of(Entry<A, B> entry){
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    public static <A, B> Pair<A, B> of(A left, B right){
        return new Pair<>(left, right);
    }


    private final A left;
    private final B right;

    public Pair(A left, B right){
        this.left = left;
        this.right =right;
    }

    public A getLeft() {
        return left;
    }

    public B getRight() {
        return right;
    }

    @Override
    public A getKey() {
        return this.left;
    }

    @Override
    public B getValue() {
        return this.right;
    }

    @Override
    public B setValue(final B value) {
        throw new UnsupportedOperationException("This entry is immutable.");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (left != null ? !left.equals(pair.left) : pair.left != null)
            return false;
        return right != null ? right.equals(pair.right) : pair.right == null;
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pair{");
        sb.append("left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}
