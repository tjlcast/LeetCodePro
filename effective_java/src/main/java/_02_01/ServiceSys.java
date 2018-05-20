package _02_01;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by tangjialiang on 2018/5/19.
 */
public class ServiceSys {
}


// Service provider framework sketch

// Service interface
interface Service {
    // Service-specific methods go here.
}

// Service provider interface
interface Provider {
    Service newService() ;
}


// Noninstantiable class for service registration and access.
class Services {
    private Services() {} // Prevents instantiation(Item 4)

    // Maps servier names to services.
    private static final Map<String, Provider> providers =
            new ConcurrentHashMap<String, Provider>() ;

    public static final String DEFAULT_PROVIDER_NAME = "<def>" ;

    // Provider registratoin API
    public static void registerDefaultProvider(Provider provider) {
        registerProvider(DEFAULT_PROVIDER_NAME, provider) ;
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p) ;
    }

    // Service access API
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME) ;
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name) ;
        if (p == null) {
            throw new IllegalArgumentException(
                    "No provider registered with name: " + name) ;
        }
        return p.newService() ;
    }
}