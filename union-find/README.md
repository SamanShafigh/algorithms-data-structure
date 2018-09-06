# Union Find

## Quick Find Algorithm

![Quick Find Algorithm](asset/quick-find.png?raw=true "Quick Find Algorithm")

```java
  public boolean connected(int n, int m) {
    return nodes[n] == nodes[m];
  }

  public void union(int n, int m) {
    int nId = nodes[n];
    int mId = nodes[m];
    for (int i = 0; i < nodes.length; i++) {
      if (nodes[i] == nId) {
        nodes[i] = mId;
      }
    }
  }
```

## Quick Union Algorithm

![Quick Union Algorithm](asset/quick-union.png?raw=true "Quick Union Algorithm")

```java
  public int root(int n) {
    while (n != nodes[n]) {
      n = nodes[n];
    }
    return n;
  }

  public boolean connected(int n, int m) {
    return root(n) == root(m);
  }

  public void union(int n, int m) {
    int nId = root(n);
    int mId = root(m);
    nodes[nId] = mId;
  }
  ```

