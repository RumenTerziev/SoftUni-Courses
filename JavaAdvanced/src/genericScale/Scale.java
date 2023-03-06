package genericScale;

public class Scale<T extends  Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {

        if (left.equals(right)) {
            return null;
        }

        return left;
    }


}
