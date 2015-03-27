Java Concurrency Notes
-----------------------

Threads:
---------

start() vs run():
While working with threads, if you call run() method of thread then it doesn't spawn a new thread but instead it uses the parent/main thread to run the runnable object.
So it's important to call start() to spawn an actual new thread and then run the runnable.
