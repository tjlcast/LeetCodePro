package Timer;

/**
 * Created by tangjialiang on 2018/4/29.
 *
 */
public interface ExpirationListener<E> {

    void expired(E expiredObject) ;
}
