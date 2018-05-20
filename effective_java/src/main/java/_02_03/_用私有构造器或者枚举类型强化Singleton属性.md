

// Singleton with public final 
public class Elvis {
    public static final Elvis INSTANCE = new Elvis() ;
    private Elvis() {}
}

// Singleton with static factory
public class Elvis {
    private static final Elvis INSTANCE = new Elvis() ;
    private Elvis() {}
    
    public static Elvis getInstance() {
        return INSTANCE ;
    }
}

// Enum singleton - the preferred approach
public enum Elvis {
    INSTANCE ;
    
    public void leaveTheBuilding() {}
}
