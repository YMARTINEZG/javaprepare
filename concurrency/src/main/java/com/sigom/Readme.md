## Interview questions:

Q1. Diference between process and thread.
    - process has own memory don't share common memory , thread share memory
Q2. How to create a thread and run it?
    Runnable is functional interface parameter for the Thread.

    Thread thread1 = new Thread(() -> System.out.println("this is a thread");
    thread1.run();
    
    Thread thread2 = new Thread() {
        @Override
        public void run() {
            System.out.println("Hello World from subclass!");
        }
    };
    thread2.start();
    
Q3. Describe differents states of a Thread, and when it occurs.
    NEW, created Thread ready to run
    RUNNABLE, thread is runnable or waiting any moment.
    WAITING,wait for another thread , Object.wait() called or Thread.join()
    BLOCKED, Thread need to enter a syncronized methos but cant because another thread is holding it.
    TIME_WAITING, thread enter this state after calling Thread.sleep(), Object.wait() or Thread.join().
    TERMINATED, when the thread completed it executions.
    
Q4. Difference between Runnable and Callable interfaces.
    Runnable interface do not return value or throw exception
    Callable interface return value or throw exception ,used with ExecutorService.
Q5. What is the JMM.
    It specifies how multiple threads access common memory in a concurrent Java application, and how data changes by one thread are made 
    visible to other threads
       
Q6. What is a volatile field.
    The reads and writes of a volatile variable are synchronization actions, meaning that they have a total ordering (all threads will observe a consistent order of these actions). A read of a volatile variable is guaranteed to observe the last 
    write to this variable, according to this order.
    If you have a field that is accessed from multiple threads, with at least one thread writing to it, then you should consider making it volatile, or else there is a little guarantee to what a certain thread would read 
    from this field.
Q7. What of the operations are atomic.
    writing to a non-volatile int;
    writing to a volatile int;
    writing to a non-volatile long;
    writing to a volatile long;
    incrementing a volatile long?
    
    A write to an int (32-bit) variable is guaranteed to be atomic, whether it is volatile or not. 
    A long (64-bit) variable could be written in two separate steps, for example, on 32-bit architectures, 
    so by default, there is no atomicity guarantee. However, if you specify the volatile modifier, 
    a long variable is guaranteed to be accessed atomically.
    
    The increment operation is usually done in multiple steps (retrieving a value, changing it and writing back), 
    so it is never guaranteed to be atomic, wether the variable is volatile or not. If you need to implement 
    atomic increment of a value, you should use classes AtomicInteger, AtomicLong etc.
    
Q8. What is the meaning of Synchronized keyword in the definition of a method, static method or before a block.
      
    