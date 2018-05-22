
显示的终止方法通常与try-finally结合起来使用，从而保证及时终止。
在finally子句内部调用显示的终止方法，可以保证即使在使用对象的
时候有异常抛出，该终止方法也会执行。

// try-finally block guarantees execution of termination method
Foo foo = new Foo() ;
try {
    // Do what must be done with foo
} finally {
    foo.terminate() ; // Explicit termination method. 
}

子类需要手动调用超类的终结方法.
// Manual finalizer ``````
@Override protected void finalize() throws Throwable {
    try {
        // Finalize subclass state
    } finally {
        super.finalizer() ;
    }
}