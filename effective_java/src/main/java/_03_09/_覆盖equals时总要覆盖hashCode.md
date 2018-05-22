一个很常见的错误根源在与覆盖hashCode方法，在每个覆盖了equals方法的类中，也必须
覆盖hashcode方法。如果不这样做的话，就会违反Object.hashCode的通用约定，从而
导致该类无法结合所有基于散列结合的集合一起正常运行，这样的集合包括HashMap、HashSet
和Hashtable。

 - 在应用程序的执行期间，只要对象的equals方法的比较操作所用到的信息没有被修改，那么对
 这同一个调用多次，hashCode方法都必须始终如一地返回同一个整数，在同一个应用
 程序的多次执行过程中，每次执行所返回的整数可以不一致。

 - 如果两个对象根据equals(Object)方法比较是不想等的，那么调用这两个对象中任意一个
 对象的hashCode方法，则不一定要产生不同的整数结果。但是程序员应该知道，给不相等的对象
 产生截然不同的整数结构，又可能提高散列表（hash table）的性能。
 
 - 如果两个对象根据equals(Object)方法比较是相等的，那么调用这两个对象中任意一个
 对象hashCode方法都必须产生同样的结果。
 
 
 1、 在每个覆盖了equals方法的类中，也必须覆盖了hashCode方法。
 2、 覆盖hashCode而违反的关键约定： 相等的对象必须具有相等的散列码（hash code）. 
 
 
 例如：
 
 public final class PhoneNumber {
    private final short areaCode ;
    private final short prefix ;
    private final short lineNumber ;
    
    public PhoneNumber(int areaCode, int prefix, 
                        int lineNumber) {
        rangeCheck(areaCode,    999,    "area code") ;
        rangeCheck(prefix,      999,    "prefix") ;
        rangeCheck(lineNumber, 9999,    "line number") ;
        
        this.areaCode = (short) areaCode ;
        this.prefix   = (short) prefix ;
        this.lineNumber = (short) lineNumber ;
    }
    
    private static void rangeCheck(int arg,     int max
                                    String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + ": " + arg) ;
        }
    }
    
    @Override 
    public boolean equals(Object o) {
        if (o == this) {
            return true ;
        }
        if (!(o instanceof PhoneNumber)) {
            return false ;
        }
        PhoneNumber pn = (PhoneNumber) o ;
        return pn.lineNumber == lineNumber
            && pn.prefix == prefix
            && pn.areaCode == areaCode ;
    }
 }
 
 如果企图将这个类与HashMap一起使用:
 
 Map<PhoneNumber, String> m 
  = new HashMap<PhoneNumber, String>() ;
 m.put(new PhoneNumber(707, 867, 5309), "Jenny") ;
 
 期望m.get(new PhoneNumber(408, 867, 5309))会返回"Jenny""，但它实际
 上返回的是null。由于PhoneNumber类没有覆盖hashCode方法，从而导致两个相等
 的实例具有不同的散列码，违反了hashCode的约定。
 
 @Override 
 public int hashCode() {
    int result = 17 ;
    result = 31 * result + areaCode ;
    result = 31 * result + prefix ;
    result = 31 * result + lineNumber ;
    return result ;
 }
 
 
 // lazily initialized cached hashCode 
 private volatile int hashCode ; // 
 @Override 
 public int hashCode() {
    int result = hashCode ;
    if (result == 0) {
        result = 17 ;
        result = 31 * result + areaCode ;
        result = 31 * result + prefix ;
        result = 31 * result + lineNumber ;
    }
    return result ;
 }
 
 
 a、对于对象中的每个关键域f（指equals方法中涉及的每个域），完成一下步骤：
    为该域计算int类型的散列码c:
        1、如果该域是boolean类型，则计算（f?1:0）。
        2、如果该域是byte、char、short或者int类型，则计算(int)f。
        3、如果该域是long类型，则计算（int）（f^(f>>>32)）
        4、如果该域是float类型，则计算Float.floatToIntBits(f)。
        5、如果该域是double类型，则计算Double.doubleToLongBits(f),
            然后按照步骤3，为得到的long类型计算散列值。
        6、如果该域是一个对象引用，并且该类的equals方法通过递归地调用equals
        的方法来比较这个域，则同样为这个域递归地调用hashCode。如果需要更复杂
        的比较，则为这个域计算一个"范式"，然后针对这个范式调用hashCode。如果
        这个域的值为null，则返回0（或者其他某个常数，但通常是0）。
        7、如果该域是一个数组，则要把每一个元素当做单独的域来处理。也就是说，递归
        地应用上述规则，对每个重要的元素计算一个散列码，然后根据步骤b中的做法把这些
        散列组合起来。如果数组域中的每个元素都很重要，可以利用发行版本1.5中增加的其中一个
        Arrays.hashCode方法
        
     b、按照下面的公式，把步骤2.a中计算得到的散列码c合并到result中：
        result = 31 * result + c ;