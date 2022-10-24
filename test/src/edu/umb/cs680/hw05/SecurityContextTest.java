package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class SecurityContextTest {
    private User user;
    private SecurityContext ctx;

    @BeforeEach
    void setUp(){
        this.user = new User(1, "Sheldon Cooper", "scooper2003");
        this.ctx = new SecurityContext(user);
    } 

    @Test
    public void verifyLoggedOutBeforeLogin(){
        assertTrue(this.ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void verifyLogin() throws Exception{
        this.ctx.login(new EncryptedString(user.getUsername(), "flash"));
        assertTrue(this.ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void verifyLoginAfterLogin() throws Exception{
        this.ctx.login(new EncryptedString(user.getUsername(), "flash"));
        this.ctx.login(new EncryptedString(user.getUsername(), "flash"));

        assertTrue(this.ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void verifyLogout() throws Exception{
        this.ctx.login(new EncryptedString(user.getUsername(), "flash"));
        this.ctx.logout();
        assertTrue(this.ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void verifyLoginAfterLogout() throws Exception{
        this.ctx.login(new EncryptedString(user.getUsername(), "flash"));
        this.ctx.logout();
        this.ctx.login(new EncryptedString(user.getUsername(), "flash"));
        assertTrue(this.ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void verifyActiveLoginSession() throws Exception{
        this.ctx.login(new EncryptedString(user.getUsername(), "flash"));
        assertTrue(this.ctx.isActive());
    }

    @Test
    public void verifyInActiveLoginSession(){
        assertFalse(this.ctx.isActive());
    }

    @Test
    public void verifyMultipleUserLogin() throws Exception{
        //Verify if single user logs in then state of other user is loggedOut
        User user2 = new User(2, "Penny", "penny2");
        SecurityContext ctx2 = new SecurityContext(user2);

        // First user login
        this.ctx.login(new EncryptedString(user.getUsername(), "flash"));

        // Second user state check
        assertTrue(ctx2.getState() instanceof LoggedOut);
    }
}
