Java Concurrency Notes
-----------------------

Threads:
---------

start() vs run():
While working with threads, if you call run() method of thread then it doesn't spawn a new thread but instead it uses the parent/main thread to run the runnable object.
So it's important to call start() to spawn an actual new thread and then run the runnable.

Thread Safe Objects:
- Local variables (primitive values) are Thread-Safe because every thread has their own stack of local variables.
- Objects created locally in a method could be thread safe if these objects are not passed to other methods which could be accessed by different threads.
- Immutable Objects are Thread-Safe or, objects which are read only are thread safe.
- The reference is not thread safe.

