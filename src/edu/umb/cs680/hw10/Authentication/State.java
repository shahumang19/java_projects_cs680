package edu.umb.cs680.hw10.Authentication;

public interface State {
    public void login(SecurityContext ctx, EncryptedString pwd) throws Exception;
    public void logout(SecurityContext ctx);
}