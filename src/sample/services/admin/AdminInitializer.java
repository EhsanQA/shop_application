package sample.services.admin;

import static sample.services.admin.Admin.admin;

public class AdminInitializer {
    public static void initializer() {

        admin = new Admin();
        admin.setName("Hooman");
        admin.setFamilyName("Khalili");
        admin.setEmail("admin");
        admin.setPassword("admin");
    }
}
