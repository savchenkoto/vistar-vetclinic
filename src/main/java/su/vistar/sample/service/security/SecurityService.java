package su.vistar.sample.service.security;

public interface SecurityService {

    String findLoggedInEmail();

    void autologin(String email, String password);

}
