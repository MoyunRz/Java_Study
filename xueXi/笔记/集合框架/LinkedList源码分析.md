## 简述
对于频繁的增加和删除操作使用这个效率比ArrayList高，底层使用双向链表实现

## 分析
```
LinkedList list =new LinkedList(); // 内部声明了Node类型的first和last属性，默认值为null,

list.add(123); // 将123封装到Node中，创建了Node对象

// 定义Node
 Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
 // 向前插入
private void linkFirst(E e) {
        // 定义开头的Node
        final Node<E> f = first;
        // 设置一个插入的新Node
        final Node<E> newNode = new Node<>(null, e, f);
        // 给头部插入新值
        first = newNode;
        // 判断是否为空
        if (f == null)
            // 头为空，给尾部赋值
            last = newNode;
        else
            // 否则向前指向
            f.prev = newNode;
        size++;
        modCount++;
    }

// 向后插入
 void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

```
