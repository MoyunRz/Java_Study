所谓拒绝策略，就是当线程池满了、队列也满了的时候，我们对任务采取的措施。或者丢弃、或者执行、或者其他...

jdk自带4种拒绝策略，我们来看看。

    CallerRunsPolicy // 在调用者线程执行
    AbortPolicy // 直接抛出RejectedExecutionException异常
    DiscardPolicy // 任务直接丢弃，不做任何处理
    DiscardOldestPolicy // 丢弃队列里最旧的那个任务，再尝试执行当前任务

这四种策略各有优劣，比较常用的是DiscardPolicy，但是这种策略有一个弊端就是任务执行的轨迹不会被记录下来。所以，我们往往需要实现自定义的拒绝策略， 通过实现RejectedExecutionHandler接口的方式。

