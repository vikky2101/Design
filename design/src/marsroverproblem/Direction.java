package marsroverproblem;

public enum Direction {

  N(0, 1) {
    @Override
    public Direction right() {
      return E;
    }

    @Override
    public Direction left() {
      return W;
    }
  },
  S(0, -1) {
    @Override
    public Direction right() {
      return E;
    }

    @Override
    public Direction left() {
      return W;
    }
  },
  W(-1, 0) {
    @Override
    public Direction right() {
      return N;
    }

    @Override
    public Direction left() {
      return S;
    }
  },
  E(1, 0) {
    @Override
    public Direction right() {
      return S;
    }

    @Override
    public Direction left() {
      return N;
    }
  };

  private int x;
  private int y;

  Direction(int a, int b) {
    this.x = a;
    this.y = b;
  }

  public abstract Direction right();

  public abstract Direction left();

  public int stepX() {
    return this.x;
  }

  public int stepY() {
    return this.y;
  }
}
