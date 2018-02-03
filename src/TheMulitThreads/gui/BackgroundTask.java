package TheMulitThreads.gui;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by tangjialiang on 2018/1/25.
 */
abstract class BackgroundTask<V>  {

    private final FutureTask<V> computation = new Computation() ;

    private class Computation extends FutureTask<V> {
        public Computation() {
            super(new Callable<V>() {
                      @Override
                      public V call() throws Exception {
                          return BackgroundTask.this.compute() ;
                      }
                  }
            ) ;
        }

        protected final void done() {
            GuiExecutor.instance().execute(new Runnable() {
                @Override
                public void run() {
                    V value = null ;
                    Throwable thrown = null ;
                    boolean cancelled = false ;
                    try {
                        value = get() ;
                    } catch (ExecutionException e) {
                        thrown = e.getCause() ;
                    } catch (CancellationException e) {
                        cancelled = true ;
                    } catch (InterruptedException consumed) {
                    } finally {
                        onCompletion(value, thrown, cancelled);
                    }
                }
            });
        }
    }

    protected abstract V compute() throws Exception ;

    protected void onCompletion(V result, Throwable exception, boolean cancelled) {}

    // compute方法可以调用setProgress方法以数字形式来指定进度
    protected void setProgress(final int current, final int max) {
        GuiExecutor.instance().execute(new Runnable() {
            @Override
            public void run() {
                onProgress(current, max);
            }
        });
    }

    protected void onProgress(int current, int max) {}

    protected abstract V get() ;
}
